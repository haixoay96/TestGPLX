package com.example.haixo.testgplx.test;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class thể hiện một đề thi
 */
public class Test implements Serializable {
    public static Test test;
    private ArrayList<Piece> pieceArrayList;

    public Test() {
        pieceArrayList = new ArrayList<Piece>();
    }

    public ArrayList<Piece> getPieceArrayList() {
        return pieceArrayList;
    }

    public void setPieceArrayList(ArrayList<Piece> pieceArrayList) {
        this.pieceArrayList = pieceArrayList;
    }
}
