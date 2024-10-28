package com.clerodri.mypizzastore;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private List<Product> productList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProductType type = (ProductType) getIntent().getSerializableExtra("productType");
        assert type != null;
        fillProducts(type);
        ListView lvProducts = findViewById(R.id.products);

        ProductAdapter adapter = new ProductAdapter( productList,this);
        lvProducts.setAdapter(adapter);


    }


    private void fillProducts(ProductType type){
        if(type.equals(ProductType.PIZZA)){
            Product product1 = new Product("Margherita", "Classic pizza with cheese and tomato", R.drawable.alfajor, 8.99, ProductType.PIZZA);
            Product product2 = new Product("Choco", "Strong and rich espresso shot", R.drawable.choco, 2.50, ProductType.PIZZA);
            Product product3 = new Product("Peperony", "Strong and rich espresso shot", R.drawable.pchoco, 4.50, ProductType.PIZZA);
            productList.addAll(List.of(product1,product2,product3));

        }
        if(type.equals(ProductType.BEBIDA)){
            Product product1 = new Product("Coca-cola", "Classic pizza with cheese and tomato", R.drawable.ivcocacola, 8.99, ProductType.BEBIDA);
            Product product2 = new Product("Whisky", "Strong and rich espresso shot", R.drawable.ivwhisky, 2.50, ProductType.BEBIDA);
            Product product3 = new Product("Cafe", "Strong and rich espresso shot", R.drawable.ivcafe, 4.50, ProductType.BEBIDA);
            productList.addAll(List.of(product1,product2,product3));
        }
    }



}