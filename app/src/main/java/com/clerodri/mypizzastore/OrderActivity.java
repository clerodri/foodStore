package com.clerodri.mypizzastore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class OrderActivity extends AppCompatActivity {
    private TextView quantityText, totalLabel;
    private Button buttonIncrease, buttonDecrease;
    Comida comidaSelected;
    Bebida bebidaSelected;
    private int quantity = 1;
    double price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        quantityText = findViewById(R.id.quantity_text);
        totalLabel = findViewById(R.id.total_label);
        buttonIncrease = findViewById(R.id.button_increase);
        buttonDecrease = findViewById(R.id.button_decrease);
        TextView tvName =  findViewById(R.id.product_name);
        ImageView tvImg =  findViewById(R.id.product_image);
        TextView tvPrice =  findViewById(R.id.product_price);
        Button add = findViewById(R.id.button_add_to_cart);

        String type = (String) getIntent().getSerializableExtra("type");
        assert type != null;
        if(type.equals("FOOD")){
            comidaSelected = (Comida) getIntent().getSerializableExtra("productSelected");
            assert comidaSelected != null;
            tvName.setText(comidaSelected.getName());
            tvImg.setImageResource(comidaSelected.getImgId());
            price = comidaSelected.getPrice();
        }
        if(type.equals("DRINK")){
             bebidaSelected = (Bebida) getIntent().getSerializableExtra("productSelected");
            assert bebidaSelected != null;
            tvName.setText(bebidaSelected.getName());
            tvImg.setImageResource(bebidaSelected.getImgId());
            price = bebidaSelected.getPrice();
        }

        tvPrice.setText(getString(R.string.price_format, price));
        updateTotalLabel(type);


        buttonIncrease.setOnClickListener(v -> {
            quantity++;
            updateQuantityAndTotal(type);
        });

        buttonDecrease.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                updateQuantityAndTotal(type);
            }
        });
        add.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
    private void updateQuantityAndTotal(String type) {

        quantityText.setText(String.valueOf(quantity));
        updateTotalLabel(type);
    }
    private void updateTotalLabel(String type) {

        float totalPrice = 0;
        if(type.equals("FOOD")){
             totalPrice = (float) (quantity * comidaSelected.getPrice());
            
        }
        if(type.equals("DRINK")){
             totalPrice = (float) (quantity *bebidaSelected.getPrice() );
        }

        totalLabel.setText(getString(R.string.total_format, totalPrice));
    }

}
