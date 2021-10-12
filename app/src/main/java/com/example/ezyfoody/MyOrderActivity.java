package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity implements OnItemDeletedListener {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    TextView tvTotalPrice;
    Button btnPay;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        getSupportActionBar().setTitle("BINUS EzFoody: My Order");

        MainActivity.orderedItems = getOrderedMenu(MainActivity.items);
        items = MainActivity.orderedItems;

        recyclerView = (RecyclerView) findViewById(R.id.rv_menu);
        btnPay = (Button) findViewById(R.id.btn_pay_now);
        tvTotalPrice = (TextView) findViewById(R.id.tv_total);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CustomAdapter customAdapter = new CustomAdapter(items ,"My Order", MyOrderActivity.this);
        customAdapter.setOnItemDeletedListener(this);
        recyclerView.setAdapter(customAdapter);
        setTotalPrice();
    }

    private ArrayList<Item> getOrderedMenu(ArrayList<Item> tempList) {
        ArrayList<Item> temp = new ArrayList<>();
        for (Item item: tempList) {
            if (item.getQty() > 0) temp.add(item);
        }
        return temp;
    }

    private void setTotalPrice() {
        tvTotalPrice = (TextView) findViewById(R.id.tv_total);
        int total = 0;
        for (Item item: MainActivity.orderedItems) {
            total += (item.getPrice() * item.getQty());
        }

        String tempTotal = "Total : Rp. " + total;
        tvTotalPrice.setText(tempTotal);

        if(total > 0) {
            btnPay.setEnabled(true);
            btnPay.setText("Pay Now");
            btnPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            btnPay.setEnabled(false);
            btnPay.setText("No Order");
        }
    }

    @Override
    public void onItemDeleted() {
        setTotalPrice();
    }
}
