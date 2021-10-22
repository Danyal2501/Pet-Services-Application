package com.example.pawsupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.ui.login.LoginActivity;
import com.example.pawsupapplication.ui.products.ChangePrice;
import com.example.pawsupapplication.ui.products.ProductsActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void goToLogin(View v) {
        Intent startIntent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(startIntent);
    }

    public void goToProducts(View v) {
        Intent startIntent = new Intent(getApplicationContext(), ProductsActivity.class);
        startActivity(startIntent);
    }

    public void goToPriceChange(View v) {
        Intent startIntent = new Intent(getApplicationContext(), ChangePrice.class);
        startActivity(startIntent);
    }

}
