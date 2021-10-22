package com.example.pawsupapplication.ui.products;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.ProductAdapter;
import com.example.pawsupapplication.data.model.ProductCategory;
import com.example.pawsupapplication.data.model.Product;


import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for viewing all products in the database.
 * This class also contains the recycler that holds the products for viewing
 *
 * @author Lingfeng Yang
 */

public class ProductsActivity extends AppCompatActivity {

    RecyclerView prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        List<ProductCategory>productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Supplies"));
        productCategoryList.add(new ProductCategory(2, "Food"));
        productCategoryList.add(new ProductCategory(3, "Treats"));


        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "Food 1", "30 kg", "$ 20.99", "5.0", R.drawable.food1));
        productsList.add(new Product(2, "Food 2", "25kg", "$ 40.00", " 3.5", R.drawable.food2));
        productsList.add(new Product(1, "Treat", "5 kg", "$ 10.00", "4.6", R.drawable.treat1));
        productsList.add(new Product(2, "Supply 1", "350 ml", "$ 25.00", "3.3", R.drawable.supply1));
        productsList.add(new Product(1, "Treat 2", "7 kg", "$ 12.99", "4.7", R.drawable.treat2));


        setProdItemRecycler(productsList);

    }


    private void setProdItemRecycler(List<Product> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
}