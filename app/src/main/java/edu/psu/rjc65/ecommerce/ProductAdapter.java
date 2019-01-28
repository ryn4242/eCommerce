package edu.psu.rjc65.ecommerce;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
        }
    }


    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.name.setText(product.getProductName());
        holder.price.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}