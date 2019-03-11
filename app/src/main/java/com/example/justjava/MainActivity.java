package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.EditText;
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
    boolean isChoclate=false;
    String username;


    public void addtoppings(View view){
        if(isCream){
            isCream=false;
        }
        else{
            isCream=true;
        }
    }
    public void addChoclate(View view){
        if(isChoclate){
            isChoclate=false;
        }
        else{
            isChoclate=true;
        }
    }

    public void addname(){
        EditText name = (EditText) findViewById(R.id.Name);
        username=name.getText().toString();
    }


    public void incrementValue(View view){
        c++;
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText(String.valueOf(c));
    }

    public void decrementValue(View view){
        if(c>0) {
            c--;
        }
        TextView sc = (TextView) findViewById(R.id.quantity_text_view);
        sc.setText(String.valueOf(c));
    }

    private String calculateprice(int x){

        int cost;
        if(isCream&&isChoclate)
            cost=x*20;
        else if(isChoclate){
            cost=x*15;
        }
        else if(isCream){
            cost=x*10;
        }

        else
            cost=x*5;

        return ("Name:"+username+" \nAdded whipped cream?"+isCream+"\nAdded Choclate?"+isChoclate+"\nTotal :$"+cost+"\nQuantity: "+c+"\nThank You");
    }

    public void submitOrder(View view)
    {
        addname();
        String message=calculateprice(c);
        displayPrice(message);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Orders from just java for "+username);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


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

        isChoclate=false;
        CheckBox chocolate = (CheckBox) findViewById(R.id.Chocolate);
        chocolate.setChecked(false);

        username="";
        EditText editText  = (EditText) findViewById(R.id.Name);
        editText.getText().clear();
        displayPrice("Your Order is Cancelled");
    }

}