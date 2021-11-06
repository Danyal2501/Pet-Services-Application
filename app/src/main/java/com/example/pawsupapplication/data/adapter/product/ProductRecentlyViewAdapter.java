package com.example.pawsupapplication.data.adapter.product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.model.product.Product;
import com.example.pawsupapplication.ui.products.ProductDetails;

import java.util.List;

public class ProductRecentlyViewAdapter extends RecyclerView.Adapter<ProductRecentlyViewAdapter.RecentlyViewedViewHolder>{
    Context context;
    List<Product> recentlyViewedList;

    public ProductRecentlyViewAdapter(Context context, List<Product> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public ProductRecentlyViewAdapter.RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_recently_viewed_items, parent, false);

        return new ProductRecentlyViewAdapter.RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecentlyViewAdapter.RecentlyViewedViewHolder holder, final int position) {

        holder.name.setText(recentlyViewedList.get(position).getProductName());
        holder.quantity.setText(recentlyViewedList.get(position).getProductQty());
        holder.price.setText(recentlyViewedList.get(position).getProductPrice());
        holder.rating.setText(recentlyViewedList.get(position).getProductRating());
        holder.bg.setBackgroundResource(recentlyViewedList.get(position).getProductPicture());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetails.class);
                i.putExtra("name", recentlyViewedList.get(position).getProductName());
                i.putExtra("image", recentlyViewedList.get(position).getProductPicture());
                i.putExtra("price",recentlyViewedList.get(position).getProductPrice());
                i.putExtra("qty",recentlyViewedList.get(position).getProductQty());
                i.putExtra("rating",recentlyViewedList.get(position).getProductRating());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public  static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{

        TextView name, quantity, price, rating;
        ConstraintLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            quantity = itemView.findViewById(R.id.qty);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
            bg = itemView.findViewById(R.id.recently_layout);

        }
    }
}
