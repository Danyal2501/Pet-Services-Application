package com.example.pawsupapplication.ui.purchase;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;

public class addCart extends AppCompatActivity {

    private String userEmail;
    private String itemID;
    private String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cart_confirm);
        userEmail = getIntent().getStringExtra("userEmail");
        itemID = getIntent().getStringExtra("itemID");
        amount = getIntent().getStringExtra("amount");
    }

}
