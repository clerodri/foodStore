package com.clerodri.mypizzastore;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class BebidaActivity extends AppCompatActivity {

    private List<Bebida> bebidaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ASFASFD");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drink);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fillBebidas();
        ListView lvProducts = findViewById(R.id.bebidas);
        BebidaAdapter adapter = new BebidaAdapter( bebidaList,this);
        lvProducts.setAdapter(adapter);


    }


    private void fillBebidas(){
            Bebida bebida1 = new Bebida("Coca-cola", "Classic pizza with cheese and tomato", R.drawable.ivcocacola, 8.99);
            Bebida bebida2 = new Bebida("Whisky", "Strong and rich espresso shot", R.drawable.ivwhisky, 2.50);
            Bebida bebida3 = new Bebida("Cafe", "Strong and rich espresso shot", R.drawable.ivcafe, 4.50);
            bebidaList.addAll(List.of(bebida1,bebida2,bebida3));

    }




}