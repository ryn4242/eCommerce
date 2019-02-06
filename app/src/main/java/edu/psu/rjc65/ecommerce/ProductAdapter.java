package edu.psu.rjc65.ecommerce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productList;
    private int rowLayout;
    private Context mContext;
    private ItemClickListener clickListener;

    //Constructor
    ProductAdapter(List<Product> productList, int rowLayout, Context context) {
        this.productList = productList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    //Get layout of list items
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    //Put item information into list item layout
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.name.setText(product.getProductName());
        holder.price.setText(Double.toString(product.getPrice()));
        holder.image.setImageResource(product.getImage());
    }

    //Set click listener so user can click on RecyclerView
    void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    //Get number of items in RecyclerView
    @Override
    public int getItemCount() {
        return productList.size();
    }

    //Create RecyclerView
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, price;
        ImageView image;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            image = view.findViewById(R.id.image);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}