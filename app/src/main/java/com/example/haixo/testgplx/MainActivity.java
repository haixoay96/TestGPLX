package com.example.haixo.testgplx;
/*
Activity khi chính , chọn các chức năng
*/
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.haixo.testgplx.test.Answer;
import com.example.haixo.testgplx.test.Key;
import com.example.haixo.testgplx.test.Piece;
import com.example.haixo.testgplx.test.Question;
import com.example.haixo.testgplx.test.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Test> testArrayList;// biến lưu trữ dữ liệu của các đề thi

    public void initi(){// khỏi tạo
        testArrayList =new ArrayList<Test>();
        for(int i = 0;i<15;i++){
            testArrayList.add(new Test());
        }
    }
// hàm gán dữ liệu vào các biến thành phần
    public void assignData(String data ,String key, int x) {
        String[] arrayData = data.split("[|]");
        Question question = new Question();
        Answer answer = new Answer();
        Piece piece = new Piece();
        Key _key = new Key();
        _key.setKey(key);
        question.setText(arrayData[0]);
        question.setImage(arrayData[5]);
        int i;
        for (i = 1; i < arrayData.length; i++) {
            if(arrayData[i].length()>3)
            answer.getStringArrayList().add(arrayData[i]);
        }
        piece.setPart_question(question);
        piece.setPart_answer(answer);
        piece.setPart_key(_key);
        testArrayList.get(x).getPieceArrayList().add(piece);

    }
// hàm nạp dữ liệu các đề thi
    public void LoadDataForArrayTest() {
        initi();
        String data = null;
        String key = null;
        InputStreamReader inputStreamReaderquestion = null;
        InputStreamReader inputStreamReaderkey = null;

        BufferedReader bufferedReaderquestion = null;
        BufferedReader bufferedReaderkey = null;
        try {
            inputStreamReaderquestion = new InputStreamReader(getAssets().open("data/questions.csv"));
            inputStreamReaderkey = new InputStreamReader(getAssets().open("data/dapan.txt"));
            bufferedReaderquestion = new BufferedReader(inputStreamReaderquestion);
            bufferedReaderkey = new BufferedReader(inputStreamReaderkey);
            for(int i=0;i<30;i++) {
                for (int j = 0; j < 15; j++) {
                    data = bufferedReaderquestion.readLine();
                    key = bufferedReaderkey.readLine();
                    assignData(data,key, j);
                }
            }
            bufferedReaderquestion.close();
            inputStreamReaderquestion.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void handingUI(){
        final Handler handler =  new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
                        setSupportActionBar(toolbar);
                        Button buttondengaunhien = (Button) findViewById(R.id.dengaunhien);
                        buttondengaunhien.setOnClickListener(MainActivity.this);
                        Button buttonthitheobo = (Button)findViewById(R.id.thitheobo);
                        buttonthitheobo.setOnClickListener(MainActivity.this);
                        Button buttonontap = (Button)findViewById(R.id.ontap);
                        buttonontap.setOnClickListener(MainActivity.this);
                        Button buttonmeoghinho = (Button)findViewById(R.id.meoghinho);
                        buttonmeoghinho.setOnClickListener(MainActivity.this);
                        Button buttonsahinh =(Button)findViewById(R.id.baithisahinh);
                        buttonsahinh.setOnClickListener(MainActivity.this);
                        Button buttonbienbao = (Button)findViewById(R.id.bienbao);
                        buttonbienbao.setOnClickListener(MainActivity.this);
                    }
                });

            }
        });
        thread.start();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                LoadDataForArrayTest();

            }
        });
        thread.start();
       //LoadDataForArrayTest();
        handingUI();


/*

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        Button buttondengaunhien = (Button) findViewById(R.id.dengaunhien);
        buttondengaunhien.setOnClickListener(this);
        Button buttonthitheobo = (Button)findViewById(R.id.thitheobo);
        buttonthitheobo.setOnClickListener(this);
        Button buttonontap = (Button)findViewById(R.id.ontap);
        buttonontap.setOnClickListener(this);
        Button buttonmeoghinho = (Button)findViewById(R.id.meoghinho);
        buttonmeoghinho.setOnClickListener(this);
        Button buttonsahinh =(Button)findViewById(R.id.baithisahinh);
        buttonsahinh.setOnClickListener(this);
        Button buttonbienbao = (Button)findViewById(R.id.bienbao);
        buttonbienbao.setOnClickListener(this);
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menumainactivity, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.dengaunhien:
                Intent intent = new Intent(MainActivity.this, ActivityLamde.class);
                Random random = new Random();
                int n = random.nextInt(14)+1;
                intent.putExtra("data", testArrayList.get(n));
                intent.putExtra("title","Đề thi ngẫu nhiên");
                startActivity(intent);
                break;
            case R.id.thitheobo:
                Intent intent1= new Intent(MainActivity.this, Thitheode.class);
                intent1.putExtra("data", testArrayList);
                startActivity(intent1);
                break;
            case R.id.causai:
            case R.id.ontap:
                Toast.makeText(this, "Ôn tập", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Ontap.class);
                startActivity(intent2);
                break;
            case R.id.bienbao:
                Intent intent5 = new Intent(this, AcitvityBienbao.class);
                startActivity(intent5);
                break;
            case R.id.meoghinho:
                Intent intent3 = new Intent(this, ActivityMeoghinho.class);
                startActivity(intent3);
                break;
            case R.id.baithisahinh:
                Intent intent4 = new Intent(this, ActivitySahinh.class);
                startActivity(intent4);
                break;
            default:
        }
    }
}
