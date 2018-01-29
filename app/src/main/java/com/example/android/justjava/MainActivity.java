package com.example.android.justjava;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    TextView textViewQuantityLate;
    TextView textViewQuantityMoca;
    TextView textViewQuantityCappuccino;
    CheckBox checkBoxwhippedCream;
    CheckBox checkBoxChocolate;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuantityLate = findViewById(R.id.quantity_text_view_late);
        textViewQuantityMoca = findViewById(R.id.quantity_text_view_moca);
        textViewQuantityCappuccino = findViewById(R.id.quantity_text_view_cappuccino);
        checkBoxwhippedCream = findViewById(R.id.whipped_cream_checkbox);
        checkBoxChocolate = findViewById(R.id.chocolate_checkbox);
        editTextName = findViewById(R.id.name_edit_text);

    }

    public void submitOrder(View view) {
        String stringQuantityLate = textViewQuantityLate.getText().toString();
        String stringQuantityMoca = textViewQuantityMoca.getText().toString();
        String stringQuantityCappuccino = textViewQuantityCappuccino.getText().toString();
        String name = editTextName.getText().toString();
        boolean hasChocolate = checkBoxChocolate.isChecked();
        boolean hasWhippedCream = checkBoxwhippedCream.isChecked();
        int quantityLate = Integer.parseInt(stringQuantityLate);
        int quantityMoca = Integer.parseInt(stringQuantityMoca);
        int quantityCapuccino = Integer.parseInt(stringQuantityCappuccino);
        int price = calculatePrice(quantityLate, quantityMoca, quantityCapuccino, hasChocolate, hasWhippedCream);
        String message = createOrderSummary(name, hasChocolate, hasWhippedCream, quantityLate, quantityMoca, quantityCapuccino, price);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT, "Coffee Order for " + name);
        intent.putExtra(intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void incrementLate(View view) {
        String stringQuantity = textViewQuantityLate.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        quantity++;
        display(quantity, R.id.quantity_text_view_late);
    }

    public void decrementLate(View view) {
        String stringQuantity = textViewQuantityLate.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        if (quantity != 0) {
            quantity--;
            display(quantity, R.id.quantity_text_view_late);
        }
        display(quantity, R.id.quantity_text_view_late);
    }

    public void incrementMoca(View view) {
        String stringQuantity = textViewQuantityMoca.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        quantity++;
        display(quantity, R.id.quantity_text_view_moca);
    }

    public void decrementMoca(View view) {
        String stringQuantity = textViewQuantityMoca.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        if (quantity != 0) {
            quantity--;
            display(quantity, R.id.quantity_text_view_moca);
        }
        display(quantity, R.id.quantity_text_view_moca);
    }

    public void incrementCappuccino(View view) {
        String stringQuantity = textViewQuantityCappuccino.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        quantity++;
        display(quantity, R.id.quantity_text_view_cappuccino);
    }

    public void decrementCappuccino(View view) {
        String stringQuantity = textViewQuantityCappuccino.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        if (quantity != 0) {
            quantity--;
            display(quantity, R.id.quantity_text_view_cappuccino);
        }
        display(quantity, R.id.quantity_text_view_cappuccino);
    }

    private void display(int number, int id) {
        TextView quantityTextView = findViewById(id);
        quantityTextView.setText("" + number);
    }

    private String createOrderSummary(String name, boolean hasChocolate, boolean hasWhippedCream, int quantityLate, int quantityMoca, int quantityCapuccino, int price) {

        String message = "";
        return message = getResources().getString(R.string.order_summary_name, name) + "\n" +
                getResources().getString(R.string.whippedCream) + ": " + hasWhippedCream + "\n" +
                getResources().getString(R.string.chocolate) + ": " + hasChocolate + "\n" +
                getResources().getString(R.string.quantity) + ": " + (quantityCapuccino + quantityLate + quantityMoca) + "\n" +
                getResources().getString(R.string.total) + ": " + DecimalFormat.getCurrencyInstance().format(price) + "\n" +
                getString(R.string.thankYou);
    }

    private int calculatePrice(int quantityLate, int quantityMoca, int quantityCapuccino, boolean hasChocolate, boolean hasWhippedCream) {
        int chocolatePrice = 0;
        int creamPrice = 0;
        if (hasChocolate) {
            chocolatePrice = 1;
        }
        if (hasWhippedCream) {
            creamPrice = 1;
        }
        return (quantityLate * 5 + quantityMoca * 5 + quantityCapuccino * 5 + chocolatePrice * 2 + creamPrice * 1);
    }


}