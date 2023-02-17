package com.springboot.practice.data.dto;

public class ChangeProjectTitleDTO {

    private Long id;
    private String title;

    public ChangeProjectTitleDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ChangeProjectTitleDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
