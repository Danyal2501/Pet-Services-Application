package com.example.pawsupapplication.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
    TextView proName, proPrice, proDesc, proAddress;

    String name, price, desc, address;
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
        address = i.getStringExtra("address");

        proName = findViewById(R.id.serviceName);
        proDesc = findViewById(R.id.servDesc);
        proPrice = findViewById(R.id.servPrice);
        img = findViewById(R.id.big_image_service);
        back = findViewById(R.id.back_service2);
        proAddress = findViewById(R.id.address_serviceDetail);
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
        proAddress.setText(address);

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
