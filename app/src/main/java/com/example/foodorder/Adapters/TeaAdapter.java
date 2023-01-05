package com.example.foodorder.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.ItemDetails;
import com.example.foodorder.Models.TeaModel;
import com.example.foodorder.R;

import java.util.ArrayList;

public class TeaAdapter extends RecyclerView.Adapter<TeaAdapter.viewHolder>{
    ArrayList<TeaModel> list;
    Context context;

    public TeaAdapter(ArrayList<TeaModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TeaAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_tea,parent,false);
        return new TeaAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TeaModel tea= list.get(position);
        holder.book.setVisibility(View.GONE);
        holder.img.setImageResource(tea.getImg());
        holder.txt.setText(tea.getName());
        if(tea.getName().toString().equals("Lemon Tea")){
            holder.book.setVisibility(View.VISIBLE);
        }else holder.book.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, ItemDetails.class);
                intent.putExtra("image",tea.getImg());
                intent.putExtra("name",tea.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView img,book;
        TextView txt;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.teaImg);
            txt=itemView.findViewById(R.id.teaName);
            book=itemView.findViewById(R.id.Bookmark);
        }
    }
}