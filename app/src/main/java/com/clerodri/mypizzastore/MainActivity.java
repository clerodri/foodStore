package com.clerodri.mypizzastore;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CardView drinks = findViewById(R.id.drink);
        CardView pizzas = findViewById(R.id.pizza);
        CardView store = findViewById(R.id.store);

        pizzas.setOnClickListener(v -> {
           Intent intent = new Intent(this, ComidaActivity.class);
           startActivity(intent);
       });
        drinks.setOnClickListener(v -> {
            Intent intent = new Intent(this, BebidaActivity.class);
            startActivity(intent);

        });
        store.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormActivity.class);
            startActivity(intent);

        });


    }
}