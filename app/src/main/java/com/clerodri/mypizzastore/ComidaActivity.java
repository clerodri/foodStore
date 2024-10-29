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

public class ComidaActivity extends AppCompatActivity {
    private List<Comida> productList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fillProducts();
        ListView lvProducts = findViewById(R.id.products);

        ComidaAdapter adapter = new ComidaAdapter( productList,this);
        lvProducts.setAdapter(adapter);


    }


    private void fillProducts(){

            Comida comida1 = new Comida("Margherita", "Classic pizza with cheese and tomato", R.drawable.alfajor, 8.99);
            Comida comida2 = new Comida("Choco", "Strong and rich espresso shot", R.drawable.choco, 2.50);
            Comida comida3 = new Comida("Peperony", "Strong and rich espresso shot", R.drawable.pchoco, 4.50);
            productList.addAll(List.of(comida1, comida2, comida3));



    }



}