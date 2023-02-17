package com.springboot.practice.service.impl;

import java.time.LocalDateTime;

import com.springboot.practice.data.dao.ProjectDAO;
import com.springboot.practice.data.dto.ProjectDTO;
import com.springboot.practice.data.dto.ProjectResponseDTO;
import com.springboot.practice.data.entity.Project;
import com.springboot.practice.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public ProjectResponseDTO getProject(Long id) {
        Project project = projectDAO.selectProject(id);

        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setId(project.getId());
        projectResponseDTO.setTitle(project.getTitle());
        projectResponseDTO.setLanguage(project.getLanguage());
        projectResponseDTO.setIs_bookmarked(project.getIs_bookmarked());

        return projectResponseDTO;
    }

    @Override
    public ProjectResponseDTO saveProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setLanguage(projectDTO.getLanguage());
        project.setIs_bookmarked(projectDTO.getIs_bookmarked());
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());

        Project savedProject = projectDAO.insertProject(project);

        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setId(savedProject.getId());
        projectResponseDTO.setTitle(savedProject.getTitle());
        projectResponseDTO.setLanguage(savedProject.getLanguage());
        projectResponseDTO.setIs_bookmarked(savedProject.getIs_bookmarked());

        return projectResponseDTO;
    }

    @Override
    public ProjectResponseDTO changeProjectTitle(Long id, String title) throws Exception {
        Project changedProduct = projectDAO.updateProjectTitle(id, title);

        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setId(changedProduct.getId());
        projectResponseDTO.setTitle(changedProduct.getTitle());
        projectResponseDTO.setLanguage(changedProduct.getLanguage());
        projectResponseDTO.setIs_bookmarked(changedProduct.getIs_bookmarked());

        return projectResponseDTO;
    }

    @Override
    public void deleteProject(Long id) throws Exception {
        projectDAO.deleteProject(id);
    }
}
