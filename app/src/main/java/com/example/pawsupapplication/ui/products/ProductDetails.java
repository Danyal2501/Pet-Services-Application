package com.example.pawsupapplication.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;

/**
 * This class creates the activity for product details
 *
 * @author Lingfeng Yang
 */
public class ProductDetails extends AppCompatActivity {
    ImageView img, back;
    TextView proName, proPrice, proDesc, proQty, proRating;

    String name, price, desc, qty, rating;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.food1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("quantity");
        rating = i.getStringExtra("rating");

        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image_product);
        back = findViewById(R.id.back_product2);
        proQty = findViewById(R.id.qty);
        proRating = findViewById(R.id.rating);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);
        proRating.setText(rating);

        img.setImageResource(image);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, ProductsActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}
