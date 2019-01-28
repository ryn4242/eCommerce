package edu.psu.rjc65.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Shopping extends AppCompatActivity {
    private RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    private List<Product> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        recyclerView = findViewById(R.id.itemList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter(items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        addItems();
    }

    private void addItems(){
        Product item = new Product("Laptop Computer", "$199.99");
        items.add(item);

        item = new Product("Desktop Computer", "$499.99");
        items.add(item);

        item = new Product("Tablet", "$129.99");
        items.add(item);

        item = new Product("Smartphone", "$189.99");
        items.add(item);
    }
}
