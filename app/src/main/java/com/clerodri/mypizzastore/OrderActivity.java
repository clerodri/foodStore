package com.clerodri.mypizzastore;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.clerodri.mypizzastore.comida.Comida;

public class OrderActivity extends AppCompatActivity {
    private TextView quantityText, totalLabel;
    private Button buttonIncrease, buttonDecrease;
    private Comida comidaSelected;
    private int quantity = 1; // Initial quantity


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Closes the current activity and returns to the previous one
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize views
        quantityText = findViewById(R.id.quantity_text);
        totalLabel = findViewById(R.id.total_label);
        buttonIncrease = findViewById(R.id.button_increase);
        buttonDecrease = findViewById(R.id.button_decrease);


        comidaSelected = (Comida) getIntent().getSerializableExtra("comidaSelected");
        TextView tvName =  findViewById(R.id.product_name);
        ImageView tvImg =  findViewById(R.id.product_image);
        TextView tvPrice =  findViewById(R.id.product_price);
        assert comidaSelected != null;
        tvName.setText(comidaSelected.getNombre());
        tvImg.setImageResource(comidaSelected.getImagenId());
        double price = comidaSelected.getPrice();
        tvPrice.setText(getString(R.string.price_format, price));
        updateTotalLabel();


        // Set up click listeners
        buttonIncrease.setOnClickListener(v -> {
            quantity++;
            updateQuantityAndTotal();
        });

        buttonDecrease.setOnClickListener(v -> {
            if (quantity > 1) { // Prevent quantity from going below 1
                quantity--;
                updateQuantityAndTotal();
            }
        });
    }
    private void updateQuantityAndTotal() {
        // Update quantity text
        quantityText.setText(String.valueOf(quantity));

        // Update total price
        updateTotalLabel();
    }
    private void updateTotalLabel() {
        // Calculate total and update label
        float totalPrice = (float) (quantity * comidaSelected.getPrice());
        totalLabel.setText(getString(R.string.total_format, totalPrice));
    }

}