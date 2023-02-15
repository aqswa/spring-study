package com.example.demo.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
