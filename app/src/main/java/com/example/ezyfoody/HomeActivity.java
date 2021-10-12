package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    Button btnDrinks, btnFoods, btnSnacks, btnTopUp, btnMyOrder;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("BINUS EzFoody");

        items = MainActivity.items;

        btnDrinks = (Button) findViewById(R.id.btn_drinks);
        btnFoods = (Button) findViewById(R.id.btn_foods);
        btnSnacks = (Button) findViewById(R.id.btn_snacks);
        btnTopUp = (Button) findViewById(R.id.btn_top_up);
        btnMyOrder = (Button) findViewById(R.id.btn_my_order);

        btnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });

    }
}
