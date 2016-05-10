package com.example.haixo.testgplx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.haixo.testgplx.R;
import com.example.haixo.testgplx.ReviewResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haixo on 3/26/2016.
 */
public class AdapterLisview extends ArrayAdapter<String> {
    private ArrayList<String> listKey;
    private ArrayList<String> stringArrayList;
    private Context context;

    public AdapterLisview(Context context, ArrayList<String> listKey , ArrayList<String> stringArrayList) {
        super(context, -1, listKey);
        this.listKey = (ArrayList<String>) listKey;
        this.context = context;
        this.stringArrayList = stringArrayList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.rowlayoutadapterlistview, parent, false);
        TextView textView1 = (TextView)row.findViewById(R.id.cau);
        textView1.setText("Câu "+(position+1));
        TextView textView2 = (TextView)row.findViewById(R.id.cautraloi);
        textView2.setText("Câu trả lời của bạn: "+stringArrayList.get(position));
        TextView textView3 = (TextView)row.findViewById(R.id.dapan);
        textView3.setText("Đáp án của câu hỏi là: "+listKey.get(position));
        return row;
    }
}
