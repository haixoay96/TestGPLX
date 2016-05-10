package com.example.haixo.testgplx;
/*
Activity chọn đề để thi
* */

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.example.haixo.testgplx.test.Test;

import java.util.ArrayList;

public class Thitheode extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Test> testArrayList;
    private ArrayList<Button> buttonArrayList;
// hàm ánh xạ các button
    public void assignData(){
        buttonArrayList = new ArrayList<Button>();
        buttonArrayList.add((Button)findViewById(R.id.d1));
        buttonArrayList.add((Button)findViewById(R.id.d2));
        buttonArrayList.add((Button)findViewById(R.id.d3));
        buttonArrayList.add((Button)findViewById(R.id.d4));
        buttonArrayList.add((Button)findViewById(R.id.d5));
        buttonArrayList.add((Button)findViewById(R.id.d6));
        buttonArrayList.add((Button)findViewById(R.id.d7));
        buttonArrayList.add((Button)findViewById(R.id.d8));
        buttonArrayList.add((Button)findViewById(R.id.d9));
        buttonArrayList.add((Button)findViewById(R.id.d10));
        buttonArrayList.add((Button)findViewById(R.id.d11));
        buttonArrayList.add((Button)findViewById(R.id.d12));
        buttonArrayList.add((Button)findViewById(R.id.d13));
        buttonArrayList.add((Button)findViewById(R.id.d14));
        buttonArrayList.add((Button)findViewById(R.id.d15));
        for (int i = 0;i<buttonArrayList.size();i++){
            buttonArrayList.get(i).setOnClickListener(this);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thitheode);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        testArrayList = (ArrayList<Test>)getIntent().getSerializableExtra("data");
        assignData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuthitheode,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,ActivityLamde.class);
        int n = v.getId();
        switch (n){
            case R.id.d1:
                intent.putExtra("data",testArrayList.get(0));
                intent.putExtra("title", "Đề thi số 1");
                break;
            case R.id.d2:
                intent.putExtra("data",testArrayList.get(1));
                intent.putExtra("title", "Đề thi số 2");
                break;
            case R.id.d3:
                intent.putExtra("data",testArrayList.get(2));
                intent.putExtra("title", "Đề thi số 3");
                break;
            case R.id.d4:
                intent.putExtra("data",testArrayList.get(3));
                intent.putExtra("title", "Đề thi số 4");
                break;
            case R.id.d5:
                intent.putExtra("data",testArrayList.get(4));
                intent.putExtra("title", "Đề thi số 5");
                break;
            case R.id.d6:
                intent.putExtra("data",testArrayList.get(5));
                intent.putExtra("title", "Đề thi số 6");
                break;
            case R.id.d7:
                intent.putExtra("data",testArrayList.get(6));
                intent.putExtra("title", "Đề thi số 7");

                break;
            case R.id.d8:
                intent.putExtra("data",testArrayList.get(7));
                intent.putExtra("title", "Đề thi số 8");
                break;
            case R.id.d9:
                intent.putExtra("data",testArrayList.get(8));
                intent.putExtra("title", "Đề thi số 9");
                break;
            case R.id.d10:
                intent.putExtra("data",testArrayList.get(9));
                intent.putExtra("title", "Đề thi số 10");
                break;
            case R.id.d11:
                intent.putExtra("data",testArrayList.get(10));
                intent.putExtra("title", "Đề thi số 11");
                break;
            case R.id.d12:
                intent.putExtra("data",testArrayList.get(11));
                intent.putExtra("title", "Đề thi số 12");
                break;
            case R.id.d13:
                intent.putExtra("data",testArrayList.get(12));
                intent.putExtra("title", "Đề thi số 13");
                break;
            case R.id.d14:
                intent.putExtra("data",testArrayList.get(13));
                intent.putExtra("title", "Đề thi số 14");
                break;
            case R.id.d15:
                intent.putExtra("data",testArrayList.get(14));
                intent.putExtra("title", "Đề thi số 15");
                break;

        }
        startActivity(intent);
    }
}
