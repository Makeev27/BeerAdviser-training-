package com.android.example.beeradviser;

import android.content.Context;
import android.content.Intent;
import android.widget.RatingBar;

public class RecyclerViewItem {

    private int imageResource;
    private String text1;
    private String text2;
    private int moneyImageResource;
    private String percentText;
    private String producingCountry;
    private float ratingBar;
    private Context context;

    public RecyclerViewItem(Context context , int imageRecource , String text1, String text2, int moneyImageResource,
                            String percentText, int id, String producingCountry){
        this.imageResource = imageRecource;
        this.text1 = text1;
        this.text2 = text2;
        this.moneyImageResource = moneyImageResource;
        this.percentText = percentText;
        this.producingCountry = producingCountry;
        this.context = context;
    }

    public int getImageRecource(){
        return imageResource;
    }

    public String getText1(){
        return text1;
    }

    public String getText2(){
        return text2;
    }

    public int getMoneyImageResource(){
        return moneyImageResource;
    }

    public String getPercentText(){
        return percentText;
    }


    public String getProducingCountry(){
        return producingCountry;
    }

    public float getRatingBar() { return ratingBar; }

    public Context getContext() { return context; }
}
