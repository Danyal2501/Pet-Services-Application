package com.example.pawsupapplication.ui.services;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.service.ServiceCategoryAdapter;
import com.example.pawsupapplication.data.adapter.service.ServiceRecentlyViewAdapter;
import com.example.pawsupapplication.data.model.service.ServiceCategory;
import com.example.pawsupapplication.data.model.service.ServiceImpl;

import static com.example.pawsupapplication.R.drawable.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for viewing all services in the database.
 * This class also contains the recycler that holds the services for viewing
 *
 * @author Lingfeng Yang
 */

public class ServiceActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView, recentlyViewedRecycler;

    ServiceCategoryAdapter categoryAdapter;
    List<ServiceCategory> categoryList;

    ServiceRecentlyViewAdapter recentlyViewedAdapter;
    List<ServiceImpl> recentlyViewedList;

    TextView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity);

        categoryRecyclerView = findViewById(R.id.categoryRecycler_service);
        recentlyViewedRecycler = findViewById(R.id.recently_item_service);
        allCategory = findViewById(R.id.allServiceCategoryImage);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ServiceActivity.this, ServiceAllCategory.class);
                startActivity(i);
            }
        });

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new ServiceCategory(1, ic_home_fish));
        categoryList.add(new ServiceCategory(2, ic_home_fish));
        categoryList.add(new ServiceCategory(3, ic_home_fish));
        categoryList.add(new ServiceCategory(4, ic_home_fish));
        categoryList.add(new ServiceCategory(5, ic_home_fish));
        categoryList.add(new ServiceCategory(6, ic_home_fish));
        categoryList.add(new ServiceCategory(7, ic_home_fish));
        categoryList.add(new ServiceCategory(8, ic_home_fish));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new ServiceImpl(1, 1, "Service 1", "Service Description 1", "Service Address 1", "19.99", food1));
        recentlyViewedList.add(new ServiceImpl(2, 2, "Service 2", "Service Description 2", "Service Address 2", "25.99", food2));
        recentlyViewedList.add(new ServiceImpl(3, 3, "Service 3", "Service Description 3", "Service Address 3", "10.99", treat1));
        recentlyViewedList.add(new ServiceImpl(4, 4, "Service 4", "Service Description 4", "Service Address 4", "30.99", treat2));


        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }


    private void setCategoryRecycler(List<ServiceCategory> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new ServiceCategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<ServiceImpl> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new ServiceRecentlyViewAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}
