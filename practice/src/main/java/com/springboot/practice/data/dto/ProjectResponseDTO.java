package com.springboot.practice.data.dto;

public class ProjectResponseDTO {

    private Long id;
    private String title;
    private String language;
    private Boolean is_bookmarked;

    public ProjectResponseDTO() {}

    public ProjectResponseDTO(Long id, String title, String language, Boolean is_bookmarked) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.is_bookmarked = is_bookmarked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getIs_bookmarked() {
        return is_bookmarked;
    }

    public void setIs_bookmarked(Boolean is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }
}
