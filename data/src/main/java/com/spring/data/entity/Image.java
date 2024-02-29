package com.spring.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_image")
public class Image extends BaseEntity{
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "height")
    private int height;
    @Column(name = "width")
    private int width;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne(mappedBy = "image")
    private ImageContent imageContent;
}
