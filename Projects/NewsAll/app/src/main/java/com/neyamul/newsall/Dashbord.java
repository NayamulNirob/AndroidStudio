package com.neyamul.newsall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashbord extends AppCompatActivity {

    private Button btnBdnews;

    private Button btnDhakatribune;

    private Button btndw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);


        btnBdnews=findViewById(R.id.btnBdnews);
        btnBdnews.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),BDNews24.class);
            startActivity(intent);
        });

        btnDhakatribune=findViewById(R.id.btnDhakatribune);
        btnDhakatribune.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),DhakaTribune.class);
            startActivity(intent);
        });

        btndw=findViewById(R.id.btndw);
        btndw.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),DW.class);
            startActivity(intent);
        });
    }
}