package com.springboot.practice.data.repository;

import com.springboot.practice.data.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}