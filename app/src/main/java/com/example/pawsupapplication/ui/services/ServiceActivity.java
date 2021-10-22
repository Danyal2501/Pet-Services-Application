package com.example.pawsupapplication.ui.services;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.ServiceAdapter;
import com.example.pawsupapplication.data.model.service.Service;
import com.example.pawsupapplication.data.model.service.ServiceImpl;


import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for viewing all services in the database.
 * This class also contains the recycler that holds the services for viewing
 *
 * @author Lingfeng Yang
 */

public class ServiceActivity extends AppCompatActivity {

    RecyclerView servItemRecycler;
    ServiceAdapter serviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);


        List<Service> serviceList = new ArrayList<>();
        serviceList.add(new ServiceImpl(1, 1, "Service 1", "desc1", "addr1", "50.00", R.drawable.food1));
        serviceList.add(new ServiceImpl(2, 2, "Service 2", "desc2", "addr2", "60.00", R.drawable.food2));
        serviceList.add(new ServiceImpl(3, 3, "Service 3", "desc3", "addr3", "10.00", R.drawable.treat1));
        serviceList.add(new ServiceImpl(4, 4, "Service 4", "desc4", "addr4", "20.00", R.drawable.supply1));
        serviceList.add(new ServiceImpl(5, 5, "Service 5", "desc5", "addr5", "34.99", R.drawable.treat2));


        setServItemRecycler(serviceList);

    }


    private void setServItemRecycler(List<Service> serviceList){

        servItemRecycler = findViewById(R.id.service_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        servItemRecycler.setLayoutManager(layoutManager);
        serviceAdapter = new ServiceAdapter(this, serviceList);
        servItemRecycler.setAdapter(serviceAdapter);

    }
}
