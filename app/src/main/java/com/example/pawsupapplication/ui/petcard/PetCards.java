package com.example.pawsupapplication.ui.petcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.adapter.PetCardAdapter;

import java.util.ArrayList;

/**
 * This class is responsible for viewing all petcards has saved in the database.
 *
 * @author Annas Rahuma
 */

public class PetCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_cards);
        Intent i = getIntent();
        ArrayList<String> arr =  getIntent().getStringArrayListExtra("map");
        ArrayList<String> arr2 =  getIntent().getStringArrayListExtra("map1");
        PetCardAdapter a = new PetCardAdapter(this, arr.toArray(), arr2.toArray());
        ListView cardList = (ListView)findViewById(R.id.petLister);
        cardList.setAdapter(a);




    }
}