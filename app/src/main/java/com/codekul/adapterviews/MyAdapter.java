package com.codekul.adapterviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aniruddha on 4/7/16.
 */
public class MyAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<MyItem> dataSet;

    public MyAdapter(Context context, ArrayList<MyItem> dataSet){
        this.dataSet = dataSet;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position * 100;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.my_item,
                null,false); // compound view

        ImageView image = (ImageView)
                view.findViewById(R.id.imageIcon);
        image.setImageResource(dataSet
                .get(position)
                .getImageId());


        TextView text = (TextView)
                view.findViewById(R.id.textCountry);
        text.setText(dataSet
                .get(position)
                .getText());


        return view;
    }
}
