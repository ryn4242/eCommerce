package edu.psu.rjc65.ecommerce;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
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
    private TextView itemName;
    private TextView itemDescription;
    private TextView itemPrice;
    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        itemName = findViewById(R.id.name);
        itemDescription = findViewById(R.id.productDescription);
        itemPrice = findViewById(R.id.priceDisplay);
        itemQuantity = findViewById(R.id.quantity);
        itemImage = findViewById(R.id.image);

        //Receive item details from Shopping activity and display them
        Intent intent = getIntent();
        itemName.setText(intent.getStringExtra("name"));
        itemDescription.setText(intent.getStringExtra("description"));
        itemPrice.setText("$" + Double.toString(intent.getDoubleExtra("price", 0.00)));
        itemImage.setImageResource(intent.getIntExtra("image", R.drawable.credenza));
    }

    //Increment item quantity
    public void incrementQuantity(View view){
        if (quantity < 5){
            quantity++;
            itemQuantity.setText("Quantity: " + quantity);
        }
    }

    //Decrement item quantity
    public void decrementQuantity(View view){
        if (quantity > 1){
            quantity--;
            itemQuantity.setText("Quantity: " + quantity);
        }
    }

    //Add an item to the cart
    public void addToCart(View view){
        Intent originalIntent = getIntent();
        Intent intent = new Intent(this, Shopping.class);
        intent.putExtra("name", itemName.getText().toString());
        intent.putExtra("price", originalIntent.getDoubleExtra("price", 0.00));
        intent.putExtra("quantity", quantity);
        intent.putExtra("image", originalIntent.getIntExtra("image", R.drawable.credenza));

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
