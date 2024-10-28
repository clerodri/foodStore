package com.clerodri.mypizzastore;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.clerodri.mypizzastore.bebida.Bebida;
import com.clerodri.mypizzastore.comida.Comida;
import com.clerodri.mypizzastore.comida.ComidaAdapter;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    public static List<Comida> comidas = new ArrayList<>();
    public static List<Bebida> bebidas = new ArrayList<>();

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
        fillComidas();
        fillBebidas();
        // Comidas
        ListView listView = findViewById(R.id.opciones);
        ComidaAdapter adapter = new ComidaAdapter(this, comidas);
        listView.setAdapter(adapter);
    }

    public void fillComidas(){
        comidas.add(new Comida("Chocolate","Exquisto chocolate amargo 60% cacao",R.drawable.choco,10));
        comidas.add(new Comida("Cuchuflies","Deliciosa vaina rellena de manjar",R.drawable.pchoco,20));
        comidas.add( new Comida("Alfajor","Maravilloso oblea rellena de manjar",R.drawable.alfajor,30));
    }
    public void fillBebidas(){
        bebidas.add(new Bebida("Wisky","Exquisto chocolate amargo 60% cacao",R.drawable.choco));
        bebidas.add(new Bebida("Coca-cola","Deliciosa vaina rellena de manjar",R.drawable.pchoco));
        bebidas.add( new Bebida("Agua","Maravilloso oblea rellena de manjar",R.drawable.alfajor));
    }
}