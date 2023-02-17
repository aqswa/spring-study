package com.springboot.practice.data.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Project {

    private @Id @GeneratedValue Long id;
    private String title;
    @Column(nullable = false)
    private String language;
    private Boolean is_bookmarked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Project() {}

    public Project(String title, String language, Boolean is_bookmarked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.language = language;
        this.is_bookmarked = is_bookmarked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLanguage() {
        return this.language;
    }

    public Boolean getIs_bookmarked() {
        return is_bookmarked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setIs_bookmarked(Boolean is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Project))
            return false;
        Project project = (Project) o;
        return Objects.equals(this.id, project.id) && Objects.equals(this.title, project.language)
                && Objects.equals(this.language, project.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.language);
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + this.id + ", title='" + this.title + '\'' + ", language='" + this.language + '\'' + '}';
    }
}
