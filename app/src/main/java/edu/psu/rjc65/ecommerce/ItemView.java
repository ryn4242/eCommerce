package edu.psu.rjc65.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//This activity is displayed when the user taps on an item

public class ItemView extends AppCompatActivity {
    private TextView itemQuantity;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        TextView itemName = findViewById(R.id.name);
        TextView itemDescription = findViewById(R.id.productDescription);
        TextView itemPrice = findViewById(R.id.priceDisplay);
        itemQuantity = findViewById(R.id.quantity);
        ImageView itemImage = findViewById(R.id.image);

        //Receive item details from Shopping activity and display them
        Intent intent = getIntent();
        itemName.setText(intent.getStringExtra("name"));
        itemDescription.setText(intent.getStringExtra("description"));
        itemPrice.setText(String.format("Price: %s", intent.getStringExtra("price")));
        itemImage.setImageResource(intent.getIntExtra("image", R.drawable.credenza));
    }

    //Increment item quantity
    public void incrementQuantity(View view){
        if (quantity < 5){
            quantity++;
            itemQuantity.setText(String.format("Quantity: %s", Integer.toString(quantity)));
        }
    }

    //Decrement item quantity
    public void decrementQuantity(View view){
        if (quantity > 1){
            quantity--;
            itemQuantity.setText(String.format("Quantity: %s", Integer.toString(quantity)));
        }
    }

    //Add an item to the cart
    public void addToCart(View view){

    }
}
