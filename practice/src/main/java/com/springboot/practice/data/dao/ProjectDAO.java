package com.springboot.practice.data.dao;

import com.springboot.practice.data.entity.Project;


public interface ProjectDAO {

    Project insertProject(Project project);

    Project selectProject(Long id);

    Project updateProjectTitle(Long id, String title) throws Exception;

    void deleteProject(Long id) throws Exception;

}
