package com.example.android.justjava;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuantity = findViewById(R.id.quantity_text_view);
    }


    public void increment(View view) {
        String stringQuantity = textViewQuantity.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        String stringQuantity = textViewQuantity.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        if (quantity != 0) {
            quantity--;
            display(quantity);
        }
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String stringQuantity = textViewQuantity.getText().toString();
        int quantity = Integer.parseInt(stringQuantity);
        display(quantity);
        displayPrice(quantity * 5);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}