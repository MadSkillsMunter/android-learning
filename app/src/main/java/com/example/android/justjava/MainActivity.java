package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
        This method is called when the + button is clicked
     */
    int nCoffee = 0;
    int coffeePrice = 5;
    int finalPrice = 0;

    public void increment(View view) {
        nCoffee++;
        finalPrice = (nCoffee * coffeePrice);
        display(nCoffee);
        displayPrice(finalPrice);
    }

    /*
        This method is called when the - button is clicked
     */
    public void decrement(View view) {
        if (nCoffee > 0) {
            nCoffee--;
            finalPrice = (nCoffee * coffeePrice);
            display(nCoffee);
            displayPrice(finalPrice);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        String msg = "Your order of " + nCoffee + " coffee(s) have been sent!\nThank you!";
        displayMessage(msg);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String msg) {
        TextView orderSentTextView = (TextView) findViewById(R.id.order_sent_text);
        orderSentTextView.setText(msg);
    }
    /*
      This method displays the price of the products
      */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}