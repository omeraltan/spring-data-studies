package com.spring.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_image")
public class Image extends BaseEntity{
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "height")
    private int height;
    @Column(name = "width")
    private int width;
}
