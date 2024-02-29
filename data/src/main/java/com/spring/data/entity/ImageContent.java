package com.spring.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_image_content")
public class ImageContent extends  BaseEntity{

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;
    @Lob
    private byte[] content;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
