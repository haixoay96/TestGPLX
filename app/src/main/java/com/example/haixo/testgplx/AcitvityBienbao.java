package com.example.haixo.testgplx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AcitvityBienbao extends AppCompatActivity {
    private ArrayList<String> stringArrayList;

    private ListView listView;
// hàm nạp dữ liệu
    public void loadData(){
        String data;
        stringArrayList = new ArrayList<String>();
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            inputStreamReader = new InputStreamReader(getAssets().open("data/signs.csv"));
            bufferedReader =  new BufferedReader(inputStreamReader);
            while ((data=bufferedReader.readLine())!=null){
                stringArrayList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitvity_bienbao);
        loadData();
        listView = (ListView)findViewById(R.id.list);
        AdapterListviewBienbao adapterListviewBienbao = new AdapterListviewBienbao(this,stringArrayList);
        listView.setAdapter(adapterListviewBienbao);

    }
}
