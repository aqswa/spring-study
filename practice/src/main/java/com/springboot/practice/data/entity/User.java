package com.springboot.practice.data.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class User {

    private @Id @GeneratedValue Long id;
    private String email;
    private String password;
    private String nickname;
    private String social_type;
    private String social_id;
    private String refresh_token;
    private Integer record_done;

    User() {}

    public User(Long id, String email, String password, String nickname, String social_type, String social_id, String refresh_token, Integer record_done) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.social_type = social_type;
        this.social_id = social_id;
        this.refresh_token = refresh_token;
        this.record_done = record_done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSocial_type() {
        return social_type;
    }

    public void setSocial_type(String social_type) {
        this.social_type = social_type;
    }

    public String getSocial_id() {
        return social_id;
    }

    public void setSocial_id(String social_id) {
        this.social_id = social_id;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Integer getRecord_done() {
        return record_done;
    }

    public void setRecord_done(Integer record_done) {
        this.record_done = record_done;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.email, this.password);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", email='" + this.email + '\'' + '}';
    }
}
