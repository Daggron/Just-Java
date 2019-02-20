package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int c=0;
    /**
     * This method is called when the order button is clicked.
     */
    public void incrementValue(View view){
        c++;
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText(""+c);
    }

    public void decrementValue(View view){
        c--;
        TextView sc = (TextView) findViewById(R.id.quantity_text_view);
        sc.setText(""+c);
    }

    public void submitOrder(View view)
    {
        displayPrice((c*5));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int Number){
        TextView obj = (TextView) findViewById(R.id.quantity_text_view);
        obj.setText(""+Number);
    }

    private void displayPrice(int Number){
        TextView pricetextview = (TextView) findViewById(R.id.price_text_view);
        pricetextview.setText(NumberFormat.getCurrencyInstance().format(Number));
    }
}