package com.example.haixo.testgplx;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haixo.testgplx.test.Piece;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private Piece piece;
    private int x;
    private boolean trueorfalse;
    private ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

    public DetailFragment() {

    }
    @SuppressLint("ValidFragment")
    public DetailFragment(Piece piece, int x, boolean trueorfalse) {
        this();
        this.piece = piece;
        this.x = x;
        this.trueorfalse = trueorfalse;
    }

    // hàm lấy đáp án
    public void getKey() {
        for (int i = 0; i < piece.getPart_key().getKey().length(); i++) {
            String s = piece.getPart_key().getKey().charAt(i) + "";
            integerArrayList.add(Integer.parseInt(s));

        }
    }
//hàm kiểm tra
    public boolean isTrue(int x) {
        for (int i = 0; i < integerArrayList.size(); i++) {
            int y = integerArrayList.get(i) - 1;
            if (x == y) {
                return true;
            }
        }
        return false;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_ontap, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.fragmentontap);
        TextView question = new TextView(getContext());
        question.setText("Câu " + x + " :" + piece.getPart_question().getText());
        question.setTextColor(Color.BLACK);
        question.setTypeface(Typeface.DEFAULT_BOLD);
        question.setTextSize(15);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        question.setLayoutParams(layoutParams);
        linearLayout.addView(question);
        // hiện thị phần hình ảnh của câu hỏi
        if (!piece.getPart_question().getImage().equals("")) {
            ImageView imageViewQuestion = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParamsq = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParamsq.gravity = Gravity.CENTER_HORIZONTAL;
            imageViewQuestion.setLayoutParams(layoutParamsq);
            imageViewQuestion.setScaleType(ImageView.ScaleType.FIT_CENTER);
            layoutParams.setMargins(0, 0, 0, 0);
            InputStream inputStream = null;
            Bitmap bitmap = null;
            try {
                inputStream = getActivity().getAssets().open("images/" + piece.getPart_question().getImage() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmap = BitmapFactory.decodeStream(inputStream);
            imageViewQuestion.setImageBitmap(bitmap);
            imageViewQuestion.setAdjustViewBounds(true);
            linearLayout.addView(imageViewQuestion);
        }
        // hiện thị phần các câu trả lời
        getKey();
        for (int i = 0; i < piece.getPart_answer().getStringArrayList().size(); i++) {
            CheckBox answer = new CheckBox(getContext());
            if (isTrue(i)) {
                answer.setChecked(true);
                answer.setTextColor(Color.parseColor("#03A9F4"));

            }
            else {
                answer.setTextColor(Color.BLACK);
            }
            if(!piece.getCheckBoxes().isEmpty()) {
                if (piece.getCheckBoxes().get(i).isChecked()) {
                    if(trueorfalse){
                        answer.setTextColor(Color.parseColor("#03A9F4"));
                    }
                    else {
                        answer.setTextColor(Color.parseColor("#ff0000"));
                    }
                }
            }
            answer.setEnabled(false);
            answer.setTypeface(Typeface.DEFAULT_BOLD);
         //   piece.getCheckBoxes().add(answer);
            answer.setText(piece.getPart_answer().getStringArrayList().get(i));
            LinearLayout.LayoutParams layoutParamsa = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            answer.setLayoutParams(layoutParamsa);
            linearLayout.addView(answer);
        }
    }
}
