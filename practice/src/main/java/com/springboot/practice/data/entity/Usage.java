package com.springboot.practice.data.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Usage {
    private @Id @GeneratedValue Long id;
    private Integer download;
    private Integer char_num;

    Usage() {}

    public Usage(Long id, Integer download, Integer char_num) {
        this.id = id;
        this.download = download;
        this.char_num = char_num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Integer getChar_num() {
        return char_num;
    }

    public void setChar_num(Integer char_num) {
        this.char_num = char_num;
    }
}
