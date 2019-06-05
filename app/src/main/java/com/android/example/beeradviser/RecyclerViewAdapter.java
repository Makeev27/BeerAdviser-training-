package com.android.example.beeradviser;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<RecyclerViewItem> arrayList;
    Context context;



    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public ImageView rubleImageView;
        public TextView percentTextView;
        public TextView producingCountryTextView;
        public RatingBar ratingBar;
        public CardView parentLayout;
        public Context context;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1= itemView.findViewById(R.id.descriptionTextView);
            textView2 = itemView.findViewById(R.id.costTextView);
            rubleImageView = itemView.findViewById(R.id.rubleImageView);
            percentTextView = itemView.findViewById(R.id.percentTextView);
            producingCountryTextView = itemView.findViewById(R.id.country);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public Context getContext() {
            return context;
        }
    }

    public RecyclerViewAdapter(Context context , ArrayList<RecyclerViewItem> arrayList){
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup , false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder recyclerViewViewHolder, int i) {
        RecyclerViewItem recyclerViewItem = arrayList.get(i);

        recyclerViewViewHolder.imageView.setImageResource(recyclerViewItem.getImageRecource());
        recyclerViewViewHolder.textView1.setText(recyclerViewItem.getText1());
        recyclerViewViewHolder.textView2.setText(recyclerViewItem.getText2());
        recyclerViewViewHolder.rubleImageView.setImageResource(recyclerViewItem.getMoneyImageResource());
        recyclerViewViewHolder.percentTextView.setText(recyclerViewItem.getPercentText());
        recyclerViewViewHolder.producingCountryTextView.setText(recyclerViewItem.getProducingCountry());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
