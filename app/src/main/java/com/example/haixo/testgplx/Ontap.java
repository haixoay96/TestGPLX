package com.example.haixo.testgplx;

import android.graphics.Color;
import android.renderscript.ScriptGroup;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;

import com.example.haixo.testgplx.test.Answer;
import com.example.haixo.testgplx.test.Key;
import com.example.haixo.testgplx.test.Piece;
import com.example.haixo.testgplx.test.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ontap extends AppCompatActivity {
    private ArrayList<Piece> pieceArrayList = new ArrayList<Piece>();
    private ViewPager viewPager;

    public void assign(String data, String key) {
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
            if (arrayData[i].length() > 3)
                answer.getStringArrayList().add(arrayData[i]);
        }
        piece.setPart_question(question);
        piece.setPart_answer(answer);
        piece.setPart_key(_key);
        pieceArrayList.add(piece);

    }

    public void loadData() {
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

            for (int i = 0; i < 450; i++) {
                data = bufferedReaderquestion.readLine();
                key = bufferedReaderkey.readLine();
                assign(data, key);

            }
            bufferedReaderquestion.close();
            inputStreamReaderquestion.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontap);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadData();
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < pieceArrayList.size(); i++) {
            fragments.add(new FragmentOntap(pieceArrayList.get(i), i + 1));
        }
        viewPager = (ViewPager) findViewById(R.id.viewpagerontap);
        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapterViewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuontap, menu);
        MenuItem menuItem = menu.findItem(R.id.searchview);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setInputType(InputType.TYPE_CLASS_NUMBER);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.equals("")) {
                    viewPager.setCurrentItem(Integer.parseInt(newText) - 1);
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
