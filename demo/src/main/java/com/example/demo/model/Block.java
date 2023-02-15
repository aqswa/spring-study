package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Block{
    private @Id @GeneratedValue Long id;
    private String content;
    @Column(name="`INTERVAL`")
    private Long interval;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false) //외래키 명시
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore //ignore the logical property used in serialization and deserialization.
    private Project project;

    Block() {}

    Block(String content, Long interval, String path, Project project) {
        this.content = content;
        this.interval = interval;
        this.path = path;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Block))
            return false;
        Block block = (Block) o;
        return Objects.equals(this.id, block.id) && Objects.equals(this.content, block.content)
                && Objects.equals(this.interval, block.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.content, this.interval);
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + this.id + ", title='" + this.content + '\'' + ", language='" + this.interval + '\'' + '}';
    }
}
