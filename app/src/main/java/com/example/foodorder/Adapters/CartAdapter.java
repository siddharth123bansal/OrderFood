package com.example.foodorder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Models.CartModel;
import com.example.foodorder.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder>{
    Context context;
    ArrayList<CartModel> list;
    int c=1;
    public CartAdapter(Context context, ArrayList<CartModel> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_cart,parent,false);
        return new CartAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CartModel cart=list.get(position);
        holder.image.setImageResource(cart.getImg());
        holder.title.setText(cart.getName());
        holder.price.setText(cart.getPrice());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                holder.am.setText(c);
            }
        });
        holder.subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c<=1){
                    Toast.makeText(context, "atleast one should be ordered", Toast.LENGTH_SHORT).show();
                }
                else{
                    c--;
                    holder.am.setText(c);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title,price,am;
        ImageView image,add,subs;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.cartImg);
            title=itemView.findViewById(R.id.carttitle);
            price=itemView.findViewById(R.id.cartPrice);
            am=itemView.findViewById(R.id.Amount);
            add=itemView.findViewById(R.id.addcart);
            subs=itemView.findViewById(R.id.sub);
        }
    }
}
