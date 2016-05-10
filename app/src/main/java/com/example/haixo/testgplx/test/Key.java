package com.example.haixo.testgplx.test;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *class lưu đáp án đúng của câu hỏi
 */
public class Key implements Serializable {
    private String key;
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
