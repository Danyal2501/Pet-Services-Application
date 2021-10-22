package com.example.pawsupapplication.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.MainActivity;
import com.example.pawsupapplication.R;
//import com.example.pawsupapplication.SuccessActivity;

public class ChangePrice extends AppCompatActivity {

    PopupWindow message;

    /*
    Displays UI for changing price.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_price);
    }

    public void edit_price(View v) {
        EditText new_price = findViewById(R.id.editTextNumberDecimal);
        String price = new_price.getText().toString();

        int integerPlaces = price.indexOf('.');
        int decimalPlaces = price.length() - integerPlaces - 1;

        if(decimalPlaces > 2) {
            Toast.makeText(this, "Invalid Price", Toast.LENGTH_LONG).show();
        }else {
            Intent i = new Intent(this, ConfirmChange.class);
            startActivity(i);
            finish();
        }
    }

    public void back(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
