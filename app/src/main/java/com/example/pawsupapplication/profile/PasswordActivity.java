package com.example.features_dream_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
    }

    public void savePassword(View v){
        EditText t1 = findViewById(R.id.current_password);
        String p1 = t1.getText().toString();

        EditText t2 = findViewById(R.id.new_password);
        String p2 = t2.getText().toString();

        EditText t3 = findViewById(R.id.confirm_password);
        String p3 = t3.getText().toString();

        if (p1.equals("") || p2.equals("") || p3.equals("")){
            Toast.makeText(this, "Please fill in all boxes", Toast.LENGTH_LONG).show();
        } else if (!p1.equals(ProfileActivity.u.getPassword())) {
            Toast.makeText(this, "Please enter the correct password.",
                    Toast.LENGTH_LONG).show();
        } else if (p1.equals(p2)) {
            Toast.makeText(this, "Please enter a different password.",
                    Toast.LENGTH_LONG).show();
        } else if (!p2.equals(p3)) {
            Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_LONG).show();
        } else if(p1.equals(ProfileActivity.u.getPassword()) && !p1.equals(p2) && p2.equals(p3)) {
            ProfileActivity.u.setPassword(p2);
            Intent i = new Intent(this, SuccessActivity.class);
            startActivity(i);
        }
    }

    public void back2(View v){
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}