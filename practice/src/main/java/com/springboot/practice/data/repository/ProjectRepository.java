package com.springboot.practice.data.repository;

import com.springboot.practice.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}