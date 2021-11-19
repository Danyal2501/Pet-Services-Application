package com.example.pawsupapplication.ui.purchase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.DAO;
import com.example.pawsupapplication.data.adapter.PetCardAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PurchaseDetail extends AppCompatActivity {

    private String userEmail;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_service_order_details);
        userEmail = getIntent().getStringExtra("userEmail");
        TextView email = (TextView)findViewById(R.id.order_detail_email);
        email.setText(String.valueOf(email));
        DAO database = new DAO(PurchaseDetail.this);
        ArrayList<String> arr3 = database.getPetsInfo(userEmail);
        ArrayList<String> arr4 = database.getPetsPic(userEmail);
        PetCardAdapter a = new PetCardAdapter(this, arr3.toArray(), arr4.toArray());
        ListView cardList = (ListView)findViewById(R.id.your_stuff);
        cardList.setAdapter(a);
    }

    public void toPayments() {
        Intent startIntent = new Intent(getApplicationContext(), PurchaseDetail.class);
        startIntent.putExtra("userEmail", userEmail);
        startActivity(startIntent);
    }

}
