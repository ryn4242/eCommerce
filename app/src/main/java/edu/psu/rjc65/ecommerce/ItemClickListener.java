package edu.psu.rjc65.ecommerce;

import android.view.View;

//Allows RecyclerView items to be clicked
public interface ItemClickListener {
    void onClick(View view, int position);
}
