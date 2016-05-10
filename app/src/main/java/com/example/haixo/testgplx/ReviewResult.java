package com.example.haixo.testgplx;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.haixo.testgplx.test.Piece;
import com.example.haixo.testgplx.test.Test;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReviewResult extends AppCompatActivity {
    private Test test;
    private Button btnSum;
    private Button btnTrue;
    private Button btnFalse;
    private Button btnMiss;
    private TextView time;
    private TextView danhgia;
    private TextView diem;
    private ArrayList<String> listKey;
    private ArrayList<String> listAnwer;
    private FragmentTransaction fragmentTransaction;
    private ReviewFragment reviewFragment;



    public void initiView(){
        time = (TextView) findViewById(R.id.review_time);
        danhgia = (TextView) findViewById(R.id.review_danhgia);
        diem = (TextView) findViewById(R.id.review_diem);
        btnSum = (Button) findViewById(R.id.review_sum);
        btnSum.setText("30");
        btnTrue = (Button) findViewById(R.id.review_true);
        btnTrue.setText(getCountTrue()+"");
        btnFalse = (Button) findViewById(R.id.review_false);
        btnFalse.setText(getCountFalse()+"");
        btnMiss = (Button) findViewById(R.id.review_miss);
        btnMiss.setText(getCountMiss()+"");
    }
    public String getTime(){
        int time = getIntent().getIntExtra("timedo",0);
        int minute = time/60;
        int second = time%60;
        return minute+":"+second;
    }
    public int getCountTrue(){
        int diem = 0;
        for(int i = 0;i<listAnwer.size();i++){
            if(listAnwer.get(i).equals(listKey.get(i))){
                diem++;
            }
        }
        return diem;
    }
    public int getCountFalse(){
        return 30-getCountTrue()-getCountMiss();
    }
    public int getCountMiss(){
        int diem = 0;
        for(int i = 0;i<listAnwer.size();i++){
            if(listAnwer.get(i).equals("")){
                diem++;
            }
        }
        return diem;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_result);
        listKey = getIntent().getStringArrayListExtra("key");
        listAnwer = getIntent().getStringArrayListExtra("dapan");
        initiView();
        time.setText(getTime());
        if(getCountTrue()>=26){
            danhgia.setText("Bạn đạt yêu cầu");
        }
        else {
            danhgia.setText("Bạn không đạt yêu cầu");
        }
        diem.setText(getCountTrue()+"/30");
        test = Test.test;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        reviewFragment = new ReviewFragment(test,"sum",listKey,listAnwer);
        fragmentTransaction.add(R.id.container_fragment, reviewFragment);
        fragmentTransaction.commit();
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new ReviewFragment(test,"sum",listKey,listAnwer));
                fragmentTransaction.commit();
            }
        });
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new ReviewFragment(test,"true",listKey,listAnwer));
                fragmentTransaction.commit();
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new ReviewFragment(test,"false",listKey,listAnwer));
                fragmentTransaction.commit();
            }
        });
        btnMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new ReviewFragment(test,"miss",listKey,listAnwer));
                fragmentTransaction.commit();
            }
        });

    }

}
