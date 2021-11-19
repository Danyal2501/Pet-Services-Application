package com.example.pawsupapplication.ui.purchase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.DAO;


public class Payment extends AppCompatActivity {

    private String userEmail;
    int paymentMethod = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_service_payment);
        userEmail = getIntent().getStringExtra("userEmail");
        DAO database = new DAO(Payment.this);
        RadioButton cash = findViewById(R.id.cashButton);
        RadioButton credit = findViewById(R.id.creditButton);
        if(cash.isChecked() && !credit.isChecked()) {
            paymentMethod = 1;
        }else if(!cash.isChecked() && credit.isChecked()) {
            paymentMethod = 2;
        }
    }

    public void toSummary(View view) {
        EditText cardNumber = findViewById(R.id.cardNumber);
        EditText cardPassword = findViewById(R.id.cardPassword);
        EditText cvv = findViewById(R.id.CVV);

        String cardNum = cardNumber.getText().toString();
        String cardPass = cardPassword.getText().toString();
        String cardSpec = cvv.getText().toString();

        if(paymentMethod == 1) {
            if(!cardNum.isEmpty() || !cardPass.isEmpty() || !cardSpec.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please leave the credit card fields empty.", Toast.LENGTH_SHORT).show();
            }else {
                Intent startIntent = new Intent(getApplicationContext(), PurchaseSummary.class);
                startIntent.putExtra("userEmail", userEmail);
                startIntent.putExtra("payMethod", paymentMethod);
                startActivity(startIntent);
            }
        }else if(paymentMethod == 2) {
            if(cardNum.isEmpty() || cardPass.isEmpty() || cardSpec.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please fill out all the fields above.", Toast.LENGTH_SHORT).show();
            }else {
                if (cardNum.matches("[0-9]+") && cardNum.length() == 16 && cardSpec.matches("[0-9]+") && cardSpec.length() == 3) {
                    Intent startIntent = new Intent(getApplicationContext(), PurchaseSummary.class);
                    startIntent.putExtra("payMethod", paymentMethod);
                    startIntent.putExtra("userEmail", userEmail);
                    startIntent.putExtra("cardNum", cardNum);
                    startIntent.putExtra("cardPass", cardPass);
                    startIntent.putExtra("cvv", cardSpec);
                    startActivity(startIntent);
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Card.", Toast.LENGTH_SHORT).show();
                }
            }
        }else {
            Toast.makeText(getApplicationContext(), "Please select a payment method.", Toast.LENGTH_SHORT).show();
        }
    }



}
