package edu.psu.rjc65.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemView extends AppCompatActivity {
    private TextView itemQuantity;

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        itemQuantity = findViewById(R.id.quantity);
    }

    public void incrementQuantity(View view){
        if (quantity < 5){
            quantity++;
            itemQuantity.setText("Quantity: " + Integer.toString(quantity));
        }
    }

    public void decrementQuantity(View view){
        if (quantity > 1){
            quantity--;
            itemQuantity.setText("Quantity: " + Integer.toString(quantity));
        }
    }

    public void addToCart(View view){

    }
}
