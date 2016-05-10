package com.example.haixo.testgplx.test;

import java.io.Serializable;

/**
 * Class lưu phần câu hỏi của một câu trong đề thi
 */
public class Question implements Serializable{
    private String text ;
    private String  image;//link của bức ảnh

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
