package com.springboot.practice.data.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;


public class ProjectDTO {

    private String title;
    private String language;
    private Boolean is_bookmarked;

    public ProjectDTO(String title, String language, Boolean is_bookmarked) {
        this.title = title;
        this.language = language;
        this.is_bookmarked = is_bookmarked;
    }

    public ProjectDTO() {}

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
