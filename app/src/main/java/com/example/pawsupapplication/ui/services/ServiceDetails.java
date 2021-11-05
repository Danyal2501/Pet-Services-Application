package com.example.pawsupapplication.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;
/**
 * This class creates the activity for service details
 *
 * @author Lingfeng Yang
 */
public class ServiceDetails extends AppCompatActivity {
    ImageView img, back;
    TextView proName, proPrice, proDesc, proQty, proUnit;

    String name, price, desc, qty, unit;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.service_details);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.food1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");

        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);
        proQty = findViewById(R.id.qty);
        proUnit = findViewById(R.id.unit);
/*
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        popupWindow = new PopupWindow(popupView, width, height, focusable);

  */
        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);

        img.setImageResource(image);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ServiceDetails.this, ServiceActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
/*
    //Give toast and return to services if yes
    public void deleteService(View view){
        Toast.makeText(getApplicationContext(), "Service Deleted", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ServiceActivity.class);
        startActivity(i);
        finish();
    }
    //dismiss popup if user presses no
    public void noDeleteService(View view){
        popupWindow.dismiss();
    }*/
}
