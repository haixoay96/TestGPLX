package com.example.haixo.testgplx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haixo on 3/30/2016.
 */
public class AdapterListviewBienbao extends ArrayAdapter<String> {
    private ArrayList<String> stringArrayList;
    public static float convertDpToPixels(float dp,Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi/160f);
        return px;
    }

    public AdapterListviewBienbao(Context context,List<String> objects) {
        super(context, -1, objects);
        this.stringArrayList = (ArrayList<String>)objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.rowadapterlistviewbienbao,parent,false);
        LinearLayout linearLayout = (LinearLayout)row.findViewById(R.id.listrow);
        String [] data = stringArrayList.get(position).split("[|]");
        if(!data[1].equals("")){
            ImageView imageView = new ImageView(getContext());
            float dp = convertDpToPixels(100,getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) dp,(int)dp);
            imageView.setLayoutParams(layoutParams);
            Picasso.with(getContext()).load("file:///android_asset/images/signs/"+data[1]+".png").into(imageView);
           /* InputStream inputStream = null;
            Bitmap bitmap = null;
            try {
                inputStream = getContext().getAssets().open("images/signs/"+data[1]+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);*/
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setAdjustViewBounds(true);
            linearLayout.addView(imageView);

            TextView textView =new TextView(getContext());
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams1.gravity= Gravity.CENTER_VERTICAL;
            textView.setLayoutParams(layoutParams1);
            textView.setText(data[2]);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextColor(Color.BLACK);
            textView.setAllCaps(false);
            textView.setPadding(10,10,10,10);
            linearLayout.addView(textView);
        }
        else {
            TextView textView =new TextView(getContext());
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(layoutParams1);
            textView.setText(data[2]);
            textView.setBackgroundResource(R.color.primary);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(15);
            textView.setAllCaps(false);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setPadding(20,20,20,20);
            textView.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);

        }
        return row;
    }
}
