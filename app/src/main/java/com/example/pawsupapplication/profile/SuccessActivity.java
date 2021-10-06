package com.example.features_dream_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changes_successful);
    }

    public void done(View v){
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}