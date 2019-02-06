package edu.psu.rjc65.ecommerce;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseUser user;
    private FirebaseAuth auth;

    private RecyclerView recyclerView;
    private CartRecyclerAdapter cartRecyclerAdapter;
    private List<CartItem> cartItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItemsList = new ArrayList<CartItem>();
        cartItemsList.add(new CartItem("example1", 3.99, 1, R.drawable.desktop));
        cartItemsList.add(new CartItem("example2", 4.99, 2 , R.drawable.laptop));

        recyclerView = (RecyclerView) findViewById(R.id.cartRecyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cartRecyclerAdapter = new CartRecyclerAdapter(cartItemsList, this);
        recyclerView.setAdapter(cartRecyclerAdapter);
    }
}



