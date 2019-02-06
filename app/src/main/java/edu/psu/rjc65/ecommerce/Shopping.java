package edu.psu.rjc65.ecommerce;

import android.content.Intent;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//This activity is displayed after the user logs in

public class Shopping extends AppCompatActivity implements ItemClickListener {

    static final int GET_CART_ITEM = 1;

    public ProductAdapter adapter;
    private ArrayList<Product> items = new ArrayList<>();
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private TextView totalTextView;
    double runningTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //Create RecyclerView
        RecyclerView recyclerView = findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new ProductAdapter(items, R.layout.product_list_row, this);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        addItems();
    }

    //Go to ItemView when a RecyclerView item is clicked
    @Override
    public void onClick(View view, int position){
        final Product product = items.get(position);
        Intent i = new Intent(this, ItemView.class);

        //Pass item information to ItemView
        i.putExtra("name", product.getProductName());
        i.putExtra("price", product.getPrice());
        i.putExtra("description", product.getDescription());
        i.putExtra("image", product.getImage());

        startActivityForResult(i,GET_CART_ITEM);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == GET_CART_ITEM){
            if (resultCode == RESULT_OK){
                double total = data.getDoubleExtra("price", 0.00) *
                        data.getIntExtra("quantity", 0);

                cartItems.add(new CartItem(data.getStringExtra("name"),
                        total, data.getIntExtra("quantity", 0),
                        data.getIntExtra("image", R.drawable.credenza)));

                runningTotal += total;
            }
        } else if (resultCode == 2){
            if(requestCode == RESULT_OK){
                cartItems = data.getParcelableArrayListExtra("array_list");
            }
        }
    }
    //Add items to item list
    private void addItems(){
        Product item = new Product("Laptop Computer", 199.99, "Our" +
                                   " Laptop Computer is a high-quality product for your computing" +
                                   " needs on the go.", R.drawable.laptop);
        items.add(item);


        item = new Product("Desktop Computer", 499.99, "Our" +
                           " Desktop Computer will bring satisfaction to your dull, dull life.",
                           R.drawable.desktop);
        items.add(item);


        item = new Product("Tablet", 129.99, "Please buy our" +
                           " Tablet? Pretty please?", R.drawable.tablet);
        items.add(item);

        item = new Product("Smartphone", 189.99, "Our Smartphone" +
                           " comes with all the latest features, including 256GB storage," +
                           " ultra-fast Wi-Fi, a 4K camera with 2x optical zoom, and a potato" +
                           " peeler.", R.drawable.smartphone);
        items.add(item);
    }

    public void goToCart(View view){
        /*for(int i = 0; i < cartItems.size(); i++){
            Log.d("Cart " + i, cartItems.get(i).getName());
            Log.d("Cart " + i, Double.toString(cartItems.get(i).getPrice()));
            Log.d("Cart " + i, Integer.toString(cartItems.get(i).getQuantity()));
        }*/

        //Bundle bundle = new Bundle();
        //bundle.putSerializable("Cart Array", (Serializable)cartItems);
        Intent intent = new Intent(Shopping.this, Cart.class);
        intent.putParcelableArrayListExtra("array_list", cartItems);
        startActivityForResult(intent, 2);
    }
}
