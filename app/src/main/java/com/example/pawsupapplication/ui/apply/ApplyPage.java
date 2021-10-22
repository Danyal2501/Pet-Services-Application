package com.example.pawsupapplication.ui.apply;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.ui.login.*;
import com.example.pawsupapplication.data.model.service.*;

import java.math.BigDecimal;

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
                    new ServiceImpl(1,1,
                            sername.getText().toString(),
                            description.getText().toString(),
                            address.getText().toString(),
                            price.getText().toString(),
                            R.drawable.food1);
                    startActivity(new Intent(ApplyPage.this, LoginActivity.class));
                }catch (NumberFormatException nfe) {
                    startActivity(new Intent(ApplyPage.this, LoginActivity.class));
                }
            }
        });
    }
}
