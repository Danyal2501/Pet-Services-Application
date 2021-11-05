package com.example.pawsupapplication.data.model;

/**
 * Class responsible for creating a "History" object, containing all the necessary raw data for
 * a transaction.
 * @author Annas, Wader
 * @version 1.0
 * @since Nov 4th 2021
 */

public class History {

    // Variables
    private int amount;
    private String price;
    private String name;
    private String date;
    private String image;

    // Constructor
    public History(int amount, String price, String name, String date, String image) {
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    // Getters
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

    // Setters
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
