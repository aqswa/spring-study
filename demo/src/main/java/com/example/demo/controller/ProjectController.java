package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.ProjectNotFoundException;

@RestController
public class ProjectController {

    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/projects")
    List<Project> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    // Single item

    @GetMapping("/projects/{id}")
    Project one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @PutMapping("/projects/{id}")
    Project replaceProject(@RequestBody Project newProject, @PathVariable Long id) {

        return repository.findById(id)
                .map(project -> {
                    project.setTitle(newProject.getTitle());
                    project.setLanguage(newProject.getLanguage());
                    project.setIs_bookmarked(Boolean.FALSE);
                    return repository.save(project);
                })
                .orElseGet(() -> {
                    newProject.setId(id);
                    return repository.save(newProject);
                });
    }

    @DeleteMapping("/projects/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}