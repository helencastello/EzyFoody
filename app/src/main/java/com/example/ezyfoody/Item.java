package com.example.ezyfoody;

class Item {
    private String name;
    private String priceTag;
    private int qty;
    private int price;
    private int thumbnail;

    public Item(String name, String priceTag, int qty, int price, int thumbnail) {
        this.name = name;
        this.priceTag = priceTag;
        this.qty = qty;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public int getThumbnail() {
        return thumbnail;
    }


    public void setQtyIncrement() {
        this.qty+=1;
    }

    public void setQtyDecrement() {
        if(this.qty > 0) this.qty-=1;
    }
}
