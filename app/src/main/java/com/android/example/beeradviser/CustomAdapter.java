package com.android.example.beeradviser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
        Context context;
        int[] icon;
        LayoutInflater inflater;

        public CustomAdapter(Context applicationContext, int[] icon){
            this.context = applicationContext;
            this.icon = icon;
            inflater = (LayoutInflater.from(applicationContext));
        }


    @Override
    public int getCount() {
        return icon.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.spinner_custom_adapter, null);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(icon[position]);
        return convertView;
    }
}
