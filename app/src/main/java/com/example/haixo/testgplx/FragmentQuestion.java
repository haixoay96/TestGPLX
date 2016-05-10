package com.example.haixo.testgplx;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haixo.testgplx.test.Piece;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *class hiện thị một câu hỏi
 */
public class FragmentQuestion extends Fragment {
    private Piece piece;
    private int x;
    private boolean check_cau;
    private boolean [] ischeck ;
    private boolean [] enable ;
    private Button buttonBig;
    private Button buttonSmall;
    @SuppressLint("ValidFragment")
    public FragmentQuestion(Piece piece, int x, Button buttonBig, Button buttonSmall){
        this.piece = piece;
        this.x = x;
        this.buttonBig = buttonBig;
        this.buttonSmall = buttonSmall;
        ischeck = new boolean[piece.getPart_answer().getStringArrayList().size()];
        enable = new boolean[piece.getPart_answer().getStringArrayList().size()];

    }
    public FragmentQuestion() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view =inflater.inflate(R.layout.fragment_fragment_question,container,false);
            return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // hiện thị câu hỏi
            LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.fragmentquestion);
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
            piece.getCheckBoxes().clear();
            for (int i = 0; i < piece.getPart_answer().getStringArrayList().size(); i++) {
                CheckBox answer = new CheckBox(getContext());
                answer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        for(int i =0 ;i<piece.getCheckBoxes().size();i++){
                            if(piece.getCheckBoxes().get(i).isChecked()){
                                if(!check_cau){
                                    check_cau=true;
                                    ActivityLamde.cau++;
                                    ActivityLamde.done_cau.setText(ActivityLamde.cau+"/30");
                                }
                                buttonBig.setBackgroundColor(Color.YELLOW);
                                buttonSmall.setBackgroundColor(Color.YELLOW);
                                return;
                            }
                        }
                        if(check_cau){
                            check_cau =false;
                            ActivityLamde.cau--;
                            ActivityLamde.done_cau.setText(ActivityLamde.cau+"/30");
                        }
                        buttonBig.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        buttonSmall.setBackgroundColor(Color.parseColor("#B3E5FC"));
                        return;
                    }
                });
                piece.getCheckBoxes().add(answer);

                if(savedInstanceState!=null){
                    answer.setChecked(savedInstanceState.getBooleanArray("chẹck")[i]);
                    answer.setEnabled(savedInstanceState.getBooleanArray("enable")[i]);
                    buttonBig.setBackgroundColor(savedInstanceState.getInt("colorbig"));
                    buttonSmall.setBackgroundColor(savedInstanceState.getInt("colorsmall"));

                }
                answer.setText(piece.getPart_answer().getStringArrayList().get(i));
                answer.setTextColor(Color.BLACK);
                answer.setTypeface(Typeface.DEFAULT_BOLD);
                LinearLayout.LayoutParams layoutParamsa = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                answer.setLayoutParams(layoutParamsa);
                linearLayout.addView(answer);
            }



    }
    // Lưu trạng thái của câu hỏi để nạp lại nếu như nó bị reload

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for(int i = 0 ;i<piece.getPart_answer().getStringArrayList().size();i++){
            ischeck[i]=piece.getCheckBoxes().get(i).isChecked();
            enable[i]=piece.getCheckBoxes().get(i).isEnabled();
        }

        outState.putBooleanArray("chẹck", ischeck);
        outState.putBooleanArray("enable", enable);
        ColorDrawable colorDrawableBig = (ColorDrawable) buttonBig.getBackground();
        ColorDrawable colorDrawableSmall = (ColorDrawable)buttonSmall.getBackground();
        outState.putInt("colorbig",colorDrawableBig.getColor() );
        outState.putInt("colorsmall", colorDrawableSmall.getColor());

    }
}
