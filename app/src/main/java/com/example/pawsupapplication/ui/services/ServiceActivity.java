package com.example.pawsupapplication.ui.services;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.ServiceAdapter;
import com.example.pawsupapplication.data.adapter.service.ServiceAllCategoryAdapter;
import com.example.pawsupapplication.data.adapter.service.ServiceCategoryAdapter;
import com.example.pawsupapplication.data.adapter.service.ServiceRecentlyViewAdapter;
import com.example.pawsupapplication.data.model.service.Service;
import com.example.pawsupapplication.data.model.service.ServiceCategory;
import com.example.pawsupapplication.data.model.service.ServiceImpl;
import com.example.pawsupapplication.data.model.service.ServiceRecentlyViewed;

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
    List<ServiceRecentlyViewed> recentlyViewedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        recentlyViewedRecycler = findViewById(R.id.recently_item);


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
        recentlyViewedList.add(new ServiceRecentlyViewed("Food 1", "Food 1 description.", "$ 50.00", "10", "KG", food1, food1));
        recentlyViewedList.add(new ServiceRecentlyViewed("Food 2", "Food 2 Description.", "$35.99", "7", "KG", food2, food2));
        recentlyViewedList.add(new ServiceRecentlyViewed("Treat 1", "Treat 1 Description.", "$19.99", "200", "G", treat1, treat1));
        recentlyViewedList.add(new ServiceRecentlyViewed("Treat 2", "Treat 2 Description.", "$9.99", "100", "G", treat2, treat2));


        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }


    private void setCategoryRecycler(List<ServiceCategory> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new ServiceCategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<ServiceRecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new ServiceRecentlyViewAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}
