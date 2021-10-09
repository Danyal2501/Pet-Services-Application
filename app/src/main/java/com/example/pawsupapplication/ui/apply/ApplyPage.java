package com.example.pawsupapplication.ui.apply;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.ui.login.*;
import com.example.pawsupapplication.user.*;
import com.example.pawsupapplication.service.*;

import java.math.BigDecimal;
import java.util.HashMap;
public class ApplyPage extends AppCompatActivity {
    protected EditText sername;
    protected EditText address;
    protected EditText description;
    protected EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_page);
        sername =  findViewById(R.id.sername);
        address =  findViewById(R.id.serads);
        description =  findViewById(R.id.description);
        price = findViewById(R.id.price);
        TextView Apply = findViewById(R.id.apply);
        Apply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    double d;
                    d = Double.parseDouble(price.getText().toString());
                    BigDecimal bigDecimal = new BigDecimal(price.getText().toString());
                    Service s = new ServiceImpl();
                    s.setName(sername.getText().toString());
                    s.setAddress(address.getText().toString());
                    s.setDesc(description.getText().toString());
                    s.setPrice(bigDecimal);
                    startActivity(new Intent(ApplyPage.this, LoginActivity.class));
                }catch (NumberFormatException nfe) {
                    startActivity(new Intent(ApplyPage.this, LoginActivity.class));
                }
            }
        });
    }
}
