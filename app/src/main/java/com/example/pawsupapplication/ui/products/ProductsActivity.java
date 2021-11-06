package com.example.pawsupapplication.ui.products;


import static com.example.pawsupapplication.R.drawable.food1;
import static com.example.pawsupapplication.R.drawable.food2;
import static com.example.pawsupapplication.R.drawable.ic_home_fish;
import static com.example.pawsupapplication.R.drawable.treat1;
import static com.example.pawsupapplication.R.drawable.treat2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.product.ProductCategoryAdapter;
import com.example.pawsupapplication.data.adapter.product.ProductRecentlyViewAdapter;
import com.example.pawsupapplication.data.model.product.Product;
import com.example.pawsupapplication.data.model.product.ProductCategory;


import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for viewing all products in the database.
 * This class also contains the recycler that holds the products for viewing
 *
 * @author Lingfeng Yang
 */

public class ProductsActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView, recentlyViewedRecycler;

    ProductCategoryAdapter categoryAdapter;
    List<ProductCategory> categoryList;

    ProductRecentlyViewAdapter recentlyViewedAdapter;
    List<Product> recentlyViewedList;

    TextView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        categoryRecyclerView = findViewById(R.id.categoryRecycler_product);
        recentlyViewedRecycler = findViewById(R.id.recently_item_product);
        allCategory = findViewById(R.id.allProductCategoryImage);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductsActivity.this, ProductAllCategory.class);
                startActivity(i);
            }
        });

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new ProductCategory(1, ic_home_fish));
        categoryList.add(new ProductCategory(2, ic_home_fish));
        categoryList.add(new ProductCategory(3, ic_home_fish));
        categoryList.add(new ProductCategory(4, ic_home_fish));
        categoryList.add(new ProductCategory(5, ic_home_fish));
        categoryList.add(new ProductCategory(6, ic_home_fish));
        categoryList.add(new ProductCategory(7, ic_home_fish));
        categoryList.add(new ProductCategory(8, ic_home_fish));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new Product(1, "Food 1", "10kg", "20.99", "5", food1));
        recentlyViewedList.add(new Product(2, "Food 2", "15kg", "30.99", "4.5", food2));
        recentlyViewedList.add(new Product(3, "Treat 1", "30g", "10.99", "3.5", treat1));
        recentlyViewedList.add(new Product(4, "Treat 2", "40g", "15.99", "3.5", treat2));


        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }


    private void setCategoryRecycler(List<ProductCategory> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new ProductCategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<Product> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new ProductRecentlyViewAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}
