package com.springboot.practice.controller;

import com.springboot.practice.data.dto.ChangeProjectTitleDTO;
import com.springboot.practice.data.dto.ProjectDTO;
import com.springboot.practice.data.dto.ProjectResponseDTO;
import com.springboot.practice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectResponseDTO> getProject(@PathVariable Long id) {
        ProjectResponseDTO projectResponseDTO = projectService.getProject(id);

        return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTO);
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectResponseDTO projectResponseDTO = projectService.saveProject(projectDTO);

        return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTO);
    }

    @PutMapping("/projects")
    public ResponseEntity<ProjectResponseDTO> changeProjectTitle(@RequestBody ChangeProjectTitleDTO changeProjectTitleDTO) throws Exception {
        ProjectResponseDTO projectResponseDTO = projectService.changeProjectTitle(
                changeProjectTitleDTO.getId(),
                changeProjectTitleDTO.getTitle());

        return ResponseEntity.status(HttpStatus.OK).body(projectResponseDTO);
    }
}
