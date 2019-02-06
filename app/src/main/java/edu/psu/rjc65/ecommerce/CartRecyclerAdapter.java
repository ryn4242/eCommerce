package edu.psu.rjc65.ecommerce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder>{

    private List<CartItem> cartItemList;
    private Context mContext;

    public CartRecyclerAdapter(List<CartItem> cartItemList, Context mContext) {
        this.cartItemList = cartItemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CartItem cartItem = cartItemList.get(i);
        viewHolder.image.setImageResource(cartItem.getImage());
        viewHolder.imageName.setText(cartItem.getName());
        viewHolder.price.setText("$" + cartItem.getPrice());
        viewHolder.quantity.setText(Integer.toString(cartItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageView image;
        TextView imageName;
        TextView quantity;
        TextView price;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.imageName);
            quantity = itemView.findViewById(R.id.quantity);
            price = itemView.findViewById(R.id.price);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}

