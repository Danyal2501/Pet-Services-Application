package com.example.features_dream_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_mail);
    }

    public void saveMail(View v){
        EditText t1 = findViewById(R.id.current_email);
        String p1 = t1.getText().toString();

        EditText t2 = findViewById(R.id.new_email);
        String p2 = t2.getText().toString();

        if (p1.equals("") || p2.equals("")) {
            Toast.makeText(this, "Please fill in all boxes", Toast.LENGTH_LONG).show();
        } else if(!p1.equals(ProfileActivity.u.getEmail())) {
            Toast.makeText(this, "Please enter the correct email.", Toast.LENGTH_LONG)
                    .show();
        } else if (p1.equals(p2)) {
            Toast.makeText(this, "Please enter a new email.", Toast.LENGTH_LONG).show();
        } else if(p1.equals(ProfileActivity.u.getEmail())){
            ProfileActivity.u.setEmail(p2);
            Intent i = new Intent(this, SuccessActivity.class);
            startActivity(i);
        }
    }

    public void back1(View v){
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}