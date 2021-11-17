package com.example.pawsupapplication.ui.purchase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.DAO;
import com.example.pawsupapplication.user.AfterLoginActivity;

public class PlaceOrder extends AppCompatActivity {

    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order_confirm);
        userEmail = getIntent().getStringExtra("userEmail");
    }

    public void confirmPlaceOrder() {
        DAO database = new DAO(PlaceOrder.this);

        /** *****************************************************************

        // TODO @Annas
         This is where you will add all the transaction info to history
         as well as delete the rows in PURCHASE_TABLE related to this transaction.

         *********************************************************************** */
        // This clears all activities and returns the user to the home page
        Intent intent = new Intent(getApplicationContext(), AfterLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
