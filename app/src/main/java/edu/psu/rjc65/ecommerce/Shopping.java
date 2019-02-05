package edu.psu.rjc65.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

//This activity is displayed after the user logs in

public class Shopping extends AppCompatActivity implements ItemClickListener {
    public ProductAdapter adapter;
    private List<Product> items = new ArrayList<>();

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
        startActivity(i);
    }

    //Add items to item list
    private void addItems(){
        Product item = new Product("Laptop Computer", "$199.99", "Our" +
                                   " Laptop Computer is a high-quality product for your computing" +
                                   " needs on the go.", R.drawable.laptop);
        items.add(item);

        item = new Product("Desktop Computer", "$499.99", "Our" +
                           " Desktop Computer will bring satisfaction to your dull, dull life.",
                           R.drawable.desktop);
        items.add(item);

        item = new Product("Tablet", "$129.99", "Please buy our" +
                           " Tablet? Pretty please?", R.drawable.tablet);
        items.add(item);

        item = new Product("Smartphone", "$189.99", "Our Smartphone" +
                           " comes with all the latest features, including 256GB storage," +
                           " ultra-fast Wi-Fi, a 4K camera with 2x optical zoom, and a potato" +
                           " peeler.", R.drawable.smartphone);
        items.add(item);
    }
}
