package com.android.example.beeradviser;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.AnimRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static android.view.KeyEvent.ACTION_DOWN;

/**
 *
 * @author Makeev
 * @since 31.05.19 / 13:50
 * @version 0.5
 *
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private RecyclerView recyclerView; // используется для связки recyclerView c Java кодом
    private RecyclerView.Adapter adapter; // "мост" между recyclerView и заполняемыми данными, он управляет заполнениями необходимых кол-в элементов
    private RecyclerView.LayoutManager layoutManager; // управляет расположением элементов RecyclerView
    Spinner spinner;
    int[] icon = {R.mipmap.beer_light, R.mipmap.beer_dark, R.mipmap.beer_weat, R.mipmap.beer_strong, R.mipmap.beer_fruit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
        setRecyclerViewLight();
    }

    public void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), icon);
        spinner.setAdapter(customAdapter);
        spinner.setBackgroundColor(Color.TRANSPARENT);
    }

    public void setRecyclerViewLight(){
        setTitle("Светлое Пиво");
        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(this , R.drawable.zhiguli, "Вкус пива свежий и чистый, в нем легкая хмелевая горчинка " +
                "и округлые тона солода перетекают в несколько вяжущее послевкусие."
                , "45" , R.drawable.ruble , "4.5" , 1 , "Россия" ));
        recyclerViewItems.add(new RecyclerViewItem(this , R.drawable.tomskoe, "Пиво высокого качества, приготовленное из натурального солода" +
                " и хмеля. Пиво имеет классический вкус, тонкий аромат и светло-золотистый цвет."
                , "65" , R.drawable.ruble , "4.0" , 2 , "Россия" ));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(this, recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setRecyclerViewDark(){
        setTitle("Тёмное пиво");
        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(this,  R.drawable.spaten, "Пиво демонстрирует бархатный, обволакивающий вкус, в котором хлебно-ржаная кислинка гармонично переплетается с сенными, зерновыми и карамельными тонами."
                , "100" , R.drawable.ruble , "5.1", 1 , "Германия"  ));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(this , recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setRecyclerViewStrong(){

    }

    public void setRecyclerViewWeat(){

    }

    public void setRecyclerViewFruit(){

    }

    public void randomizeBeer(View view) {
        Random random;
        int number;
        random = new Random();
        number = random.nextInt( (5) + 1);
        switch (number){
            case 1:
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) setRecyclerViewLight();
        else if (position == 1) setRecyclerViewDark();
        else if (position == 2) setRecyclerViewWeat();
        else if (position == 3) setRecyclerViewStrong();
        else if (position == 4) setRecyclerViewFruit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getMapActivity(View view) {
        Intent mapIntent = new Intent(MainActivity.this , MapsActivity.class);
        startActivity(mapIntent);
    }

    public void getActivity(View view){
        Intent intent = new Intent(MainActivity.this , ItemActivity.class);
        startActivity(intent);

    }


}
