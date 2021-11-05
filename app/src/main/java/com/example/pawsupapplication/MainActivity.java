package com.example.pawsupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.ui.login.LoginActivity;
import com.example.pawsupapplication.ui.products.ChangePrice;
import com.example.pawsupapplication.ui.products.ProductsActivity;
import com.example.pawsupapplication.ui.services.ServiceActivity;
import com.example.pawsupapplication.ui.ratingReview.RecentServices;

/**
 * Class responsible for the main interface of the app, and contains paths to all functionality.
 * @author Dream Team
 * @version 1.0
 * @since Nov 2nd 2021
 */

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
  
    public void goToServices(View v) {
        Intent startIntent = new Intent(getApplicationContext(), ServiceActivity.class);
        startActivity(startIntent);
    }

    public void goToReview(View v) {
        Intent startIntent = new Intent(getApplicationContext(), RecentServices.class);
        startActivity(startIntent);
    }

    public void goToPriceChange(View v) {
        Intent startIntent = new Intent(getApplicationContext(), ChangePrice.class);
        startActivity(startIntent);
    }
}
