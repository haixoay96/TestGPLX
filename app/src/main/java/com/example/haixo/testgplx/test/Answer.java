package com.example.haixo.testgplx.test;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class luu các đáp ản của câu hỏi
 */
public class Answer implements Serializable {
    private ArrayList<String> stringArrayList;
    public Answer(){
        stringArrayList = new ArrayList<String>();
    }

    public ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }

    public void setStringArrayList(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }
}
