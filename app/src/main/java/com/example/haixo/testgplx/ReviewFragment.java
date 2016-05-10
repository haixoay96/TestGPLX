package com.example.haixo.testgplx;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haixo.testgplx.test.Piece;
import com.example.haixo.testgplx.test.Test;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends Fragment {
    public static Test testCurrent;
    private Test test;
    private String name = "Rong";
    private Button button;
    private ArrayList<String> listKey;
    private ArrayList<String> listAnswer;
    private ArrayList<Button> buttonArrayList = new ArrayList<Button>();


    public ReviewFragment() {
        // Required empty public constructor
    }
    public ReviewFragment(Test test,String name , ArrayList<String> listKey , ArrayList<String> listAnswer){
        this.test = test;
        this.name = name;
        this.listAnswer = listAnswer;
        this.listKey = listKey;
        testCurrent = test;

    }
    public void initiView(){
       /* button = (Button) getView().findViewById(R.id.review_1);
        button.setText("Câu 1");
        button.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.exclamation_mark30);*/
        buttonArrayList.add((Button)getView().findViewById(R.id.review_1));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_2));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_3));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_4));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_5));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_6));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_7));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_8));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_9));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_10));

        buttonArrayList.add((Button)getView().findViewById(R.id.review_11));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_12));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_13));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_14));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_15));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_16));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_17));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_18));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_19));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_20));

        buttonArrayList.add((Button)getView().findViewById(R.id.review_21));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_22));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_23));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_24));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_25));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_26));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_27));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_28));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_29));
        buttonArrayList.add((Button)getView().findViewById(R.id.review_30));


    }
    public int checkKindAnswer(int i){
      if(listAnswer.get(i).equals("")){
          return 3;
      }
      else if(listAnswer.get(i).equals(listKey.get(i))){
          return 1;
      }
        else {
          return 2;
      }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initiView();
        if(name.equals("sum")){
            Toast.makeText(getContext(),"sum", Toast.LENGTH_SHORT).show();
            for( int i = 0;i<buttonArrayList.size();i++){
                final int d = i;
                buttonArrayList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(),DisplayDetail.class);
                        intent.putExtra("position",d);
                        intent.putExtra("dapan", listAnswer);
                        intent.putExtra("key", listKey);
                        intent.putExtra("trueorfalse", checkKindAnswer(d)==1);
                        getContext().startActivity(intent);

                    }
                });
                buttonArrayList.get(i).setText("Câu "+(i+1));
                buttonArrayList.get(i).setVisibility(View.VISIBLE);
                if(checkKindAnswer(i)==1){
                    buttonArrayList.get(i).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.right_mark30);
                }
                else if(checkKindAnswer(i)==2){
                    buttonArrayList.get(i).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.wrong_mark30);
                }
                else {
                    buttonArrayList.get(i).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.exclamation_mark30);
                }

            }

        }
        else if(name.equals("true")){
            Toast.makeText(getContext(),"true", Toast.LENGTH_SHORT).show();
            int k =0;
            for(int i = 0;i<buttonArrayList.size();i++){
                if(checkKindAnswer(i)==1){
                    final int d = i;
                    buttonArrayList.get(k).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.right_mark30);
                    buttonArrayList.get(k).setText("Câu "+(i+1));
                    buttonArrayList.get(k).setVisibility(View.VISIBLE);
                    buttonArrayList.get(k).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),DisplayDetail.class);
                            intent.putExtra("position",d);
                            intent.putExtra("dapan", listAnswer);
                            intent.putExtra("key", listKey);
                            intent.putExtra("trueorfalse", checkKindAnswer(d)==1);
                            getContext().startActivity(intent);
                        }
                    });
                    k++;
                }
            }
        }
        else if(name.equals("false")){
            Toast.makeText(getContext(),"false", Toast.LENGTH_SHORT).show();
            int k =0;
            for(int i = 0;i<buttonArrayList.size();i++){
                final int d = i;
                if(checkKindAnswer(i)==2){
                    buttonArrayList.get(k).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.wrong_mark30);
                    buttonArrayList.get(k).setText("Câu "+(i+1));
                    buttonArrayList.get(k).setVisibility(View.VISIBLE);
                    buttonArrayList.get(k).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),DisplayDetail.class);
                            intent.putExtra("position",d);
                            intent.putExtra("dapan", listAnswer);
                            intent.putExtra("key", listKey);
                            intent.putExtra("trueorfalse", checkKindAnswer(d)==1);
                            getContext().startActivity(intent);
                        }
                    });
                    k++;
                }
            }
        }
        else if(name.equals("miss")){
            Toast.makeText(getContext(),"miss", Toast.LENGTH_SHORT).show();
            int k =0;
            for(int i = 0;i<buttonArrayList.size();i++){
                final int d = i;
                if(checkKindAnswer(i)==3){
                    buttonArrayList.get(k).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.exclamation_mark30);
                    buttonArrayList.get(k).setText("Câu "+(i+1));
                    buttonArrayList.get(k).setVisibility(View.VISIBLE);
                    buttonArrayList.get(k).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),DisplayDetail.class);
                            intent.putExtra("position",d);
                            intent.putExtra("dapan", listAnswer);
                            intent.putExtra("key", listKey);
                            intent.putExtra("trueorfalse", checkKindAnswer(d)==1);
                            getContext().startActivity(intent);
                        }
                    });
                    k++;
                }
            }

        }
    }
}
