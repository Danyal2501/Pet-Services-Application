package com.example.pawsupapplication.data.model;

public class History {

    private int amount;
    private String price;
    private String name;
    private String date;
    private String image;

    public History(int amount, String price, String name, String date, String image) {
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public int getAmount() {
        return amount;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
