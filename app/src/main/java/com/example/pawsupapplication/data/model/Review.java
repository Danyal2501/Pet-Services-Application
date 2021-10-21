package com.example.pawsupapplication.data.model;

public class Review {
    private float rating;
    private String date;
    private String title;
    private String reviewText;


    public Review(float r, String d, String t, String rt){
        rating = r;
        date = d;
        title = t;
        reviewText = rt;
    }

    public void setRating(float i){
        rating = i;
    }

    public float getRating(){
        return rating;
    }

    public void setTitle(String s){
        title = s;
    }

    public String getTitle(){
        return title;
    }

    public void setReview(String s){
        reviewText = s;
    }

    public String getReview(){
        return reviewText;
    }

    public void setDate(String s){
        date = s;
    }

    public String getDate(){
        return date;
    }
}
