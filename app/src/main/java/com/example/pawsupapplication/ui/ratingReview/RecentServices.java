package com.example.pawsupapplication.ui.ratingReview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pawsupapplication.data.model.Review;
import com.example.pawsupapplication.R;

import java.util.HashMap;
import java.util.Map;

public class RecentServices extends AppCompatActivity {

    public static Map<String, Review> reviewMap= new HashMap<String, Review>();
    //public static Review r = new Review();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_services);
    }

    public void addAReview(View v){
        Intent i = new Intent(this, ReviewActivity.class);
        startActivity(i);
    }

}