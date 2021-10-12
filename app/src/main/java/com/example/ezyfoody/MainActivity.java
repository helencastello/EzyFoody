package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Item> items;
    public static ArrayList<Item> orderedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int SPLASH_TIME_OUT = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                items = createDrinkMenu();
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    private ArrayList<Item> createDrinkMenu() {
        ArrayList<Item> temp = new ArrayList<>();
        Item item1 = new Item("Air Mineral", "Rp. 10.000", 0, 10000, R.drawable.air_mineral);
        temp.add(item1);
        Item item2 = new Item("Jus Apel", "Rp. 15.000", 0, 15000, R.drawable.jus_apel);
        temp.add(item2);
        Item item3 = new Item("Jus Mangga", "Rp. 17.000", 0, 17000, R.drawable.jus_mangga);
        temp.add(item3);
        Item item4 = new Item("Jus Alpukat", "Rp. 20.000", 0, 20000, R.drawable.jus_alpukat);
        temp.add(item4);
        return temp;
    }
}
