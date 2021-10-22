package com.example.pawsupapplication.ui.ratingReview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.ReviewAdapter;

import java.util.ArrayList;

public class DisplayReviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayreview_activity);
        ArrayList<String> arr =  getIntent().getStringArrayListExtra("map");
        ArrayList<String> arr2 =  getIntent().getStringArrayListExtra("map1");
        ReviewAdapter a = new ReviewAdapter(this, arr.toArray(), arr2.toArray());
        ListView ReviewList = (ListView)findViewById(R.id.reviewLister);
        ReviewList.setAdapter(a);
    }

    public void add(View v){
        Intent i = new Intent(this, ReviewActivity.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i = new Intent(this, RecentServices.class);
        startActivity(i);
    }
}