package com.springboot.practice.service;

import com.springboot.practice.data.dto.ProjectDTO;
import com.springboot.practice.data.dto.ProjectResponseDTO;

public interface ProjectService {

    ProjectResponseDTO getProject(Long id);

    ProjectResponseDTO saveProject(ProjectDTO productDto);

    ProjectResponseDTO changeProjectTitle(Long id, String title) throws Exception;

    void deleteProject(Long id) throws Exception;

}