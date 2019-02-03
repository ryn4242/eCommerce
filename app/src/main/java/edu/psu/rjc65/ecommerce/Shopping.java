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

public class Shopping extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    public ProductAdapter adapter;
    private List<Product> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        recyclerView = findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new ProductAdapter(items, R.layout.product_list_row, this);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        addItems();
    }

    @Override
    public void onClick(View view, int position){
        final Product product = items.get(position);
        Intent i = new Intent(this, ItemView.class);
        i.putExtra("productName", product.getProductName());
        i.putExtra("price", product.getPrice());
        i.putExtra("description", product.getDescription());
        startActivity(i);
    }

    private void addItems(){
        Product item = new Product("Laptop Computer", "$199.99", "Our" +
                                   " Laptop Computer is a high-quality product for your computing" +
                                   " needs on the go.");
        items.add(item);

        item = new Product("Desktop Computer", "$499.99", "Our" +
                           " Desktop Computer will bring satisfaction to your dull, dull life.");
        items.add(item);

        item = new Product("Tablet", "$129.99", "Please buy our" +
                           " Tablet? Pretty please?");
        items.add(item);

        item = new Product("Smartphone", "$189.99", "Our Smartphone" +
                           " comes with all the latest features, including 256GB storage," +
                           " ultra-fast Wi-Fi, a 4K camera with 2x optical zoom, and a potato" +
                           " peeler.");
        items.add(item);
    }
}
