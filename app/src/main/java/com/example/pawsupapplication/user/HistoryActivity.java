package com.example.pawsupapplication.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;

/**
 * Class responsible for the display and function of the user interface for transaction history.
 * @author Wader
 * @version 1.0
 * @since Nov 4th 2021
 */

public class HistoryActivity extends AppCompatActivity {
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_of_transaction);
        userEmail = getIntent().getStringExtra("userEmail");
    }
}
