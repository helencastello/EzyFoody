package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    TextView tvTotalPrice;
    Button btnHome;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        getSupportActionBar().setTitle("BINUS EzFoody: Complete Order");

        items = getOrderedMenu(MainActivity.orderedItems);

        btnHome = (Button) findViewById(R.id.btn_home);
        tvTotalPrice = (TextView) findViewById(R.id.tv_total);
        setTotalPrice();

        recyclerView = (RecyclerView) findViewById(R.id.rv_menu);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CustomAdapter customAdapter = new CustomAdapter(items,"Complete Order", OrderCompleteActivity.this);
        recyclerView.setAdapter(customAdapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myOrderIntent = new Intent(OrderCompleteActivity.this, HomeActivity.class);
                resetOrderedMenu();
                startActivity(myOrderIntent);
            }
        });
    }

    private int getTotalPrice(ArrayList<Item> tempList) {
        int total = 0;
        for (Item item: tempList) {
            total += (item.getPrice() * item.getQty());
        }
        return total;
    }

    private ArrayList<Item> getOrderedMenu(ArrayList<Item> tempList) {
        ArrayList<Item> temp = new ArrayList<>();
        for (Item item: tempList) {
            if (item.getQty() > 0) temp.add(item);
        }
        return temp;
    }

    private void resetOrderedMenu() {
        for (Item item: MainActivity.items) {
            item.setQty(0);
        }
        MainActivity.orderedItems.clear();
    }

    private void setTotalPrice() {
        int total = 0;
        for (Item item: MainActivity.orderedItems) {
            total += (item.getPrice() * item.getQty());
        }

        String tempTotal = "Total : Rp. " + total;
        tvTotalPrice.setText(tempTotal);
    }
}
