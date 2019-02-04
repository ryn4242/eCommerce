package edu.psu.rjc65.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemView extends AppCompatActivity {
    private TextView itemQuantity;
    private TextView itemName;
    private TextView itemDescription;
    private TextView itemPrice;
    private ImageView itemImage;

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        itemName = findViewById(R.id.name);
        itemDescription = findViewById(R.id.productDescription);
        itemPrice = findViewById(R.id.priceDisplay);
        itemQuantity = findViewById(R.id.quantity);
        itemImage = findViewById(R.id.image);

        Intent intent = getIntent();
        itemName.setText(intent.getStringExtra("name"));
        itemDescription.setText(intent.getStringExtra("description"));
        itemPrice.setText("Price: " + intent.getStringExtra("price"));
        itemImage.setImageResource(intent.getIntExtra("image", R.drawable.credenza));
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
