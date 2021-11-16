package com.example.pawsupapplication.ui.petcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.DAO;

public class DeleteCards extends AppCompatActivity {

    String ID = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cards);
        ID = getIntent().getStringExtra("userEmail");
    }

    public void deletePetCard(View v) {
    try {
        EditText t = findViewById(R.id.deletePetName);
        DAO dbHelp = new DAO(DeleteCards.this);
        boolean report = dbHelp.deletePet(t.getText().toString(), ID);
        /*
        if(report == true){
            Toast.makeText(this, "Pet has been deleted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "An error has occurred with Deletion", Toast.LENGTH_LONG).show();
        }
        */
    }catch(Exception e){
        Toast.makeText(this, "An error has occurred with Deletion", Toast.LENGTH_LONG).show();
    }

    }
}