package com.springboot.practice.data.dao.impl;

import com.springboot.practice.data.dao.ProjectDAO;
import com.springboot.practice.data.entity.Project;
import com.springboot.practice.data.repository.ProjectRepository;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProjectDAOImpl implements ProjectDAO {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectDAOImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project insertProject(Project project) {
        Project savedProduct = projectRepository.save(project);

        return savedProduct;
    }

    @Override
    public Project selectProject(Long id) {
        Project selectedProject = projectRepository.getReferenceById(id);

        return selectedProject;
    }

    @Override
    public Project updateProjectTitle(Long id, String title) throws Exception {
        Optional<Project> selectedProject = projectRepository.findById(id);

        Project updatedProject;
        if (selectedProject.isPresent()) {
            Project project = selectedProject.get();

            project.setTitle(title);
            project.setUpdatedAt(LocalDateTime.now());

            updatedProject = projectRepository.save(project);
        } else {
            throw new Exception();
        }

        return updatedProject;
    }

    @Override
    public void deleteProject(Long id) throws Exception {
        Optional<Project> selectedProject = projectRepository.findById(id);

        if (selectedProject.isPresent()) {
            Project project = selectedProject.get();

            projectRepository.delete(project);
        } else {
            throw new Exception();
        }
    }
}
