package com.example.ezyfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<Item> items;
    private Context context;
    private String menu;
    private OnItemDeletedListener onItemDeletedListener;

    public void setOnItemDeletedListener(Object object) {
        onItemDeletedListener = (OnItemDeletedListener) object;
    }

    public CustomAdapter(ArrayList<Item> items, String menu, Context context) {
        this.menu = menu;
        this.items = items;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImageRv;
        TextView tvItemNameRv, tvItemQtyRv, tvItemPriceRv;
        Button btnDelete;
        View layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivImageRv = (ImageView) itemView.findViewById(R.id.iv_image_rv);
            this.tvItemNameRv = (TextView) itemView.findViewById(R.id.tv_item_name_rv);
            this.tvItemQtyRv = (TextView) itemView.findViewById(R.id.tv_item_qty_rv);
            this.tvItemPriceRv = (TextView) itemView.findViewById(R.id.tv_item_price_rv);
            this.btnDelete = (Button) itemView.findViewById(R.id.btn_delete);
            this.layout = (View) itemView.findViewById(R.id.ly_rv);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater linearLayout = LayoutInflater.from(parent.getContext());
        View view = linearLayout.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Item item = items.get(position);
        holder.ivImageRv.setImageResource(item.getThumbnail());
        holder.tvItemNameRv.setText(item.getName());
        String qty = item.getQty()+"";
        holder.tvItemQtyRv.setText(qty);
        holder.tvItemPriceRv.setText(item.getPriceTag());
        if(menu.equals("Complete Order")) {
            holder.btnDelete.setVisibility(View.GONE);
        } else {
            holder.btnDelete.setVisibility(View.VISIBLE);
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (Item item: MainActivity.items
                    ) {
                        if(item.getName().equals(items.get(position).getName())) {
                            item.setQty(0);
                        }
                    }
                    items.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, items.size());
                    holder.itemView.setVisibility(View.GONE);
                    onItemDeletedListener.onItemDeleted();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
