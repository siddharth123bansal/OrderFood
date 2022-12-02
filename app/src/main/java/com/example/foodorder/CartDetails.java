package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodorder.Adapters.CartAdapter;
import com.example.foodorder.Adapters.WillBuyAdapter;
import com.example.foodorder.Models.CartModel;

import java.util.ArrayList;

public class CartDetails extends AppCompatActivity {
    RecyclerView rec;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);
        rec=findViewById(R.id.CartRecyclerView);
        img=findViewById(R.id.Homes);
        ArrayList<CartModel> list=new ArrayList<>();
        list.add(new CartModel(R.drawable.will1,"Bubble Tea","$56.99"));
        list.add(new CartModel(R.drawable.will2,"Bubble Tea","$26.99"));
        list.add(new CartModel(R.drawable.will1,"Bubble Tea","$12.99"));
        CartAdapter adapter =new CartAdapter(this,list);
        LinearLayoutManager lManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rec.setLayoutManager(lManager);
        rec.setAdapter(adapter);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(CartDetails.this,MainActivity.class);
               startActivity(intent);
               finish();
            }
        });
    }
}