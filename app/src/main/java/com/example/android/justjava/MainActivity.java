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

    TextView textViewQuantityLate;
    TextView textViewQuantityMoca;
    TextView textViewQuantityCappuccino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuantityLate = findViewById(R.id.quantity_text_view_late);
        textViewQuantityMoca = findViewById(R.id.quantity_text_view_moca);
        textViewQuantityCappuccino = findViewById(R.id.quantity_text_view_cappuccino);
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

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String stringQuantityLate = textViewQuantityLate.getText().toString();
        String stringQuantityMoca = textViewQuantityMoca.getText().toString();
        String stringQuantityCappuccino = textViewQuantityCappuccino.getText().toString();
        int quantityLate = Integer.parseInt(stringQuantityLate);
        int quantityMoca = Integer.parseInt(stringQuantityMoca);
        int quantityCapuccino = Integer.parseInt(stringQuantityCappuccino);
        displayPrice(quantityLate * 5 + quantityMoca * 5 + quantityCapuccino * 5);
        String priceMessage = "Thank you for buying ";
        if (quantityLate == 0 && quantityMoca == 0 && quantityCapuccino == 0) {
            priceMessage = priceMessage + "nothing cheap fuck!";
            displayMessage(priceMessage);
        }
        if (quantityLate != 0) {
            priceMessage = priceMessage + quantityLate + " cups of Late. ";
        }
        if (quantityLate != 0) {
            priceMessage = priceMessage + quantityMoca + " cups of Moca. ";
        }
        if (quantityLate != 0) {
            priceMessage = priceMessage + quantityCapuccino + " cups of Cappuccino. ";
        }
        displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number, int id) {
        TextView quantityTextView = (TextView) findViewById(id);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.message_text_view);
        priceTextView.setText(message);
    }

}