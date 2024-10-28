package com.clerodri.mypizzastore;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class FormActivity extends AppCompatActivity {

    private TextInputLayout nameLayout, emailLayout, idNumberLayout, dateLayout, ageLayout;
    private TextInputEditText nameInput, emailInput, idNumberInput, dateInput, ageInput;
    private Button submitButton;

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize views
        nameLayout = findViewById(R.id.name_layout);
        emailLayout = findViewById(R.id.email_layout);
        idNumberLayout = findViewById(R.id.id_number_layout);
        dateLayout = findViewById(R.id.date_layout);
        ageLayout = findViewById(R.id.age_layout);

        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        idNumberInput = findViewById(R.id.id_number_input);
        dateInput = findViewById(R.id.date_input);
        ageInput = findViewById(R.id.age_input);
        submitButton = findViewById(R.id.submit_button);

        // Set up submit button click listener
        submitButton.setOnClickListener(v -> validateForm());
    }

    private void validateForm() {
        boolean isValid = true;

        // Validate Name
        if (TextUtils.isEmpty(nameInput.getText())) {
            nameLayout.setError("Name is required");
            isValid = false;
        } else {
            nameLayout.setError(null);
        }

        // Validate Email
        if (TextUtils.isEmpty(emailInput.getText()) || !Patterns.EMAIL_ADDRESS.matcher(emailInput.getText()).matches()) {
            emailLayout.setError("Valid email is required");
            isValid = false;
        } else {
            emailLayout.setError(null);
        }

        // Validate ID Number (10 digits)
        String idNumber = String.valueOf(idNumberInput.getText());
        if (TextUtils.isEmpty(idNumber) || idNumber.length() != 10) {
            idNumberLayout.setError("ID number must be 10 digits");
            isValid = false;
        } else {
            idNumberLayout.setError(null);
        }

        // Validate Date (format DD/MM/YYYY)
        String date = String.valueOf(dateInput.getText());
        if (TextUtils.isEmpty(date) || !DATE_PATTERN.matcher(date).matches()) {
            dateLayout.setError("Date must be in DD/MM/YYYY format");
            isValid = false;
        } else {
            dateLayout.setError(null);
        }

        // Validate Age (e.g., Age must be positive)
        String age = String.valueOf(ageInput.getText());
        if (TextUtils.isEmpty(age) || Integer.parseInt(age) <= 0) {
            ageLayout.setError("Valid age is required");
            isValid = false;
        } else {
            ageLayout.setError(null);
        }

        // Perform action if form is valid
        if (isValid) {
            // Code to handle successful validation (e.g., submit form)
        }
    }
}
