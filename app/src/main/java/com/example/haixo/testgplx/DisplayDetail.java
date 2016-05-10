package com.example.haixo.testgplx;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.haixo.testgplx.test.Piece;
import com.example.haixo.testgplx.test.Test;

import java.util.ArrayList;

public class DisplayDetail extends AppCompatActivity {
    private Test test;
    private ViewPager  viewPager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> listAnswer;
    private ArrayList<String> listKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detail);
        fragments = new ArrayList<Fragment>();
        test = Test.test;
        listAnswer = getIntent().getStringArrayListExtra("dapan");
        listKey = getIntent().getStringArrayListExtra("key");
        viewPager = (ViewPager) findViewById(R.id.detail_viewpager);
        for(int i = 0;i <test.getPieceArrayList().size();i++){
            fragments.add(new DetailFragment(test.getPieceArrayList().get(i), i + 1,getIntent().getBooleanExtra("trueorfalse",false)));
        }
        AdapterViewPager adapterViewPager= new AdapterViewPager(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapterViewPager);
        Toast.makeText(this,getIntent().getIntExtra("position", 0)+"",Toast.LENGTH_SHORT).show();
        viewPager.setCurrentItem(getIntent().getIntExtra("position",0));


    }
}
