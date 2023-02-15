package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Block;
import com.example.demo.repository.BlockRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {

    private final BlockRepository repository;

    BlockController(BlockRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/blocks")
    List<Block> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/blocks")
    Block newBlock(@RequestBody Block newBlock) {
        return repository.save(newBlock);
    }

    // Single item

    @GetMapping("/blocks/{id}")
    Optional<Block> one(@PathVariable Long id) {

        return repository.findById(id);
                //.orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @PutMapping("/blocks/{id}")
    Block replaceBlock(@RequestBody Block newBlock, @PathVariable Long id) {

        return repository.findById(id)
                .map(block -> {
                    block.setContent(newBlock.getContent());
                    block.setInterval(newBlock.getInterval());
                    block.setPath(newBlock.getPath());
                    return repository.save(block);
                })
                .orElseGet(() -> {
                    newBlock.setId(id);
                    return repository.save(newBlock);
                });
    }

    @DeleteMapping("/blocks/{id}")
    void deleteBlock(@PathVariable Long id) {
        repository.deleteById(id);
    }
}