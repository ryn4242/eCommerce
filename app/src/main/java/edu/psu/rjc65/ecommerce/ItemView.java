package edu.psu.rjc65.ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ItemView extends AppCompatActivity {
    private DatabaseReference mItemDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private TextView itemQuantity;

    int quantity = 1;
    String productName;
    String price;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mItemDatabase = FirebaseDatabase.getInstance().getReference().child("MItem");

        itemQuantity = findViewById(R.id.quantity);

        Intent intent = getIntent();

        productName = intent.getStringExtra("productName");
        price = intent.getStringExtra("price");
        description = intent.getStringExtra("description");
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
        Toast.makeText(this, "Adding to Cart", Toast.LENGTH_LONG).show();

        DatabaseReference newCartItem = mItemDatabase.push();

        Map<String, String> dataToSave = new HashMap<>();
        dataToSave.put("productName", productName);
        dataToSave.put("price", price);
        dataToSave.put("quantity", String.valueOf(quantity));

        newCartItem.setValue(dataToSave);

        finish();
    }
}
