package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.view.View;
import android.widget.CheckBox;
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
    int c=0;
    boolean isCream=false;

    public void addtoppings(View view){
        if(isCream){
            isCream=false;
        }
        else{
            isCream=true;
        }
    }

    public void incrementValue(View view){
        c++;
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText(String.valueOf(c));
    }

    public void decrementValue(View view){
        c--;
        TextView sc = (TextView) findViewById(R.id.quantity_text_view);
        sc.setText(String.valueOf(c));
    }

    private String calculateprice(int x){

        if(isCream)
            return ("Total: $"+x*10+"\nQuantity: "+x+"\nThank you");
        else
            return ("Total: $"+x*5+"\nQuantity: "+x+"\nThank you");
    }

    public void submitOrder(View view)
    {
        String message=calculateprice(c);
        displayPrice(message);
    }

    /*
     * This method displays the given quantity value on the screen.
     */

    private void displayPrice(String message){
        TextView pricetextview = (TextView) findViewById(R.id.price_text_view);
        pricetextview.setText(message);

    }

    public void CancelOrder(View view){
        c=0;
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText(String.valueOf(c));

        isCream=false;
        CheckBox checkBox =(CheckBox) findViewById(R.id.checkbox);
        checkBox.setChecked(false);

        displayPrice("Your Order is Cancelled");
    }

}