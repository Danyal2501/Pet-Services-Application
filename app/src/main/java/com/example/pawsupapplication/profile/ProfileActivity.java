package com.example.features_dream_14;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;


import android.os.Bundle;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {
    public static User u = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        View t = findViewById(R.id.changefullname);
        ((TextView) t).setText(u.getName());

        View t1 = findViewById(R.id.changename);
        ((TextView) t1).setText(u.getUsername());

        View t2 = findViewById(R.id.changeBirthday);
        ((TextView) t2).setText(u.getBirthday());

        View t3 = findViewById(R.id.changelocation);
        ((TextView) t3).setText(u.getLocation());

        View t4 = findViewById(R.id.changeEmail);
        ((TextView) t4).setText(u.getEmail());

        View t5 = findViewById(R.id.changephone);
        ((TextView) t5).setText(u.getPhone());

        View t6 = findViewById(R.id.changepassword);
        ((TextView) t6).setText(u.getPassword());
    }

    public void saveProfile(View v){
        EditText t = findViewById(R.id.changefullname);
        String s = t.getText().toString();

        EditText t1 = findViewById(R.id.changename);
        String s1 = t1.getText().toString();

        EditText t2 = findViewById(R.id.changeBirthday);
        String s2 = t2.getText().toString();

        EditText t3 = findViewById(R.id.changelocation);
        String s3 = t3.getText().toString();

        if(s.equals("") || s1.equals("") || s2.equals("") || s3.equals("")){
            Toast.makeText(this, "One of the boxes is empty.", Toast.LENGTH_LONG).show();
        } else {
            ProfileActivity.u.setName(s);
            ProfileActivity.u.setUsername(s1);
            ProfileActivity.u.setBirthday(s2);
            ProfileActivity.u.setLocation(s3);

            Intent i = new Intent(this, SuccessActivity.class);
            startActivity(i);
        }
    }

    public void email(View v){
        Intent i = new Intent(this, EmailActivity.class);
        startActivity(i);
    }

    public void phone(View v){
        Intent i = new Intent(this, PhoneActivity.class);
        startActivity(i);
    }

    public void password(View v){
        Intent i = new Intent(this, PasswordActivity.class);
        startActivity(i);
    }
}