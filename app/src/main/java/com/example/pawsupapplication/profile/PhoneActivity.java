package com.example.features_dream_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_phone);
    }

    public void savePhone(View v){
        EditText t1 = findViewById(R.id.Old_number);
        String p1 = t1.getText().toString();

        EditText t2 = findViewById(R.id.new_number);
        String p2 = t2.getText().toString();

        if(p1.equals(ProfileActivity.u.getPhone()) && !p1.equals(p2)){
            ProfileActivity.u.setPhone(p2);
            Intent i = new Intent(this, SuccessActivity.class);
            startActivity(i);
        } else if (p1.equals("") || p2.equals("")){
            Toast.makeText(this, "Please fill in all boxes", Toast.LENGTH_LONG).show();
        } else if(!p1.equals(ProfileActivity.u.getPhone())) {
            Toast.makeText(this, "Please enter the correct phone number.",
                    Toast.LENGTH_LONG).show();
        } else if (p1.equals(p2)) {
            Toast.makeText(this, "Phone numbers do not match.", Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void back3(View v){
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}