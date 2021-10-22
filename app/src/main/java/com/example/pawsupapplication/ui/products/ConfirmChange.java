package com.example.pawsupapplication.ui.products;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawsupapplication.R;

public class ConfirmChange extends AppCompatActivity {
    /*
    Displays UI for confirming a change.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_change);
    }

    public void confirm(View v) {
        Toast.makeText(this, "Price Changed!", Toast.LENGTH_LONG).show();
        finish();
    }

    public void cancel(View v) {
        Toast.makeText(this, "Changes are canceled.", Toast.LENGTH_LONG).show();
        finish();
    }
}
