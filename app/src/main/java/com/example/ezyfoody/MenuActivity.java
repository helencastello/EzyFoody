package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    Button btnMyOrder, btnAirMineral, btnJusApel, btnJusMangga, btnJusAlpukat;
    String itemName = "";
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("BINUS EzFoody: Drink");

        items = MainActivity.items;

        btnMyOrder = (Button) findViewById(R.id.btn_my_order);
        btnAirMineral = (Button) findViewById(R.id.btn_add_air_mineral);
        btnJusApel = (Button) findViewById(R.id.btn_add_jus_apel);
        btnJusMangga = (Button) findViewById(R.id.btn_add_jus_mangga);
        btnJusAlpukat = (Button) findViewById(R.id.btn_add_jus_alpukat);

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myOrderIntent = new Intent(MenuActivity.this, MyOrderActivity.class);
                startActivity(myOrderIntent);
            }
        });
    }

    public void add_to_list(View view){
        Intent orderIntent = new Intent(MenuActivity.this, OrderActivity.class);
        Bundle bundle = new Bundle();
        int idx = -1;
        if(view == findViewById(R.id.btn_add_air_mineral)) {
            idx = 0;
        } else if(view == findViewById(R.id.btn_add_jus_apel)) {
            idx = 1;
        } else if(view == findViewById(R.id.btn_add_jus_mangga)) {
            idx = 2;
        } else if(view == findViewById(R.id.btn_add_jus_alpukat)) {
            idx = 3;
        }
        items.get(idx).setQtyIncrement();
        bundle.putInt("idx", idx);
        orderIntent.putExtras(bundle);
        startActivity(orderIntent);
    }
}
