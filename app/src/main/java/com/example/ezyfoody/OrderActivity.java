package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class OrderActivity extends AppCompatActivity {

    private ImageView ivItem;
    private TextView tvItemName, tvItemPrice;
    private EditText etQty;
    private int idx;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setTitle("BINUS EzFoody: Order");

        items = MainActivity.items;

        ivItem = (ImageView) findViewById(R.id.iv_item);
        tvItemName = (TextView) findViewById(R.id.tv_item_name);
        tvItemPrice = (TextView) findViewById(R.id.tv_item_price);
        etQty = (EditText) findViewById(R.id.et_qty);

        Bundle bundle = getIntent().getExtras();
        idx = bundle.getInt("idx");
        onUsedItem();
    }

    public void onUsedItem() {
        tvItemName.setText(items.get(idx).getName());
        tvItemPrice.setText(items.get(idx).getPriceTag());
        etQty.setText(String.valueOf(items.get(idx).getQty()));
        ivItem.setBackground(getDrawable(items.get(idx).getThumbnail()));
    }

    public void set_qty(View view) {
        if(view == findViewById(R.id.btn_increment)) {
            items.get(idx).setQtyIncrement();
        } else if(view == findViewById(R.id.btn_decrement)) {
            items.get(idx).setQtyDecrement();
        }
        etQty.setText(String.valueOf(items.get(idx).getQty()));
    }

    public void go_to_order_more(View view) {
        Intent intent = new Intent(OrderActivity.this, MenuActivity.class);
        int tempQty = Integer.parseInt(String.valueOf(etQty.getText()));
        items.get(idx).setQty(tempQty);
        startActivity(intent);
        finish();
    }

    public void go_to_my_order(View view) {
        Intent intent = new Intent(OrderActivity.this, MyOrderActivity.class);
        int tempQty = Integer.parseInt(String.valueOf(etQty.getText()));
        items.get(idx).setQty(tempQty);
        startActivity(intent);
        finish();
    }
}
