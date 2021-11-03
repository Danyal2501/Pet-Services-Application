package com.example.pawsupapplication.ui.petcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.DAO;
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
        System.out.println("2");
        Intent i = getIntent();
        System.out.println("3");
       // ArrayList<String> arr =  getIntent().getStringArrayListExtra("map");
        DAO dbh = new DAO(PetCards.this);
        System.out.println("4");
        ArrayList<String> arr3 = dbh.getPetsInfo();
        ArrayList<String> arr4 = dbh.getPetsPic();
       // Toast.makeText(this, arr3.toString(), Toast.LENGTH_LONG).show();
        //ArrayList<String> arr2 =  getIntent().getStringArrayListExtra("map1");
        PetCardAdapter a = new PetCardAdapter(this, arr3.toArray(), arr4.toArray());
        ListView cardList = (ListView)findViewById(R.id.petLister);
        cardList.setAdapter(a);




    }
}