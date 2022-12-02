package com.example.foodorder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Models.TeaModel;
import com.example.foodorder.Models.WillBuyModel;
import com.example.foodorder.R;

import java.util.ArrayList;
public class WillBuyAdapter extends RecyclerView.Adapter<WillBuyAdapter.viewHolder>{
    Context context;
    ArrayList<WillBuyModel> list;
    public WillBuyAdapter(Context context, ArrayList<WillBuyModel> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_willbuy,parent,false);
        return new WillBuyAdapter.viewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        WillBuyModel buy=list.get(position);
        holder.img.setImageResource(buy.getImg());
        holder.title.setText(buy.getTitle());
        holder.des.setText(buy.getDes());
        holder.price.setText(buy.getPrice());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title,des,price;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.willImg);
            title=itemView.findViewById(R.id.Tiltle);
            des=itemView.findViewById(R.id.Description);
            price= itemView.findViewById(R.id.Price);
        }
    }
}