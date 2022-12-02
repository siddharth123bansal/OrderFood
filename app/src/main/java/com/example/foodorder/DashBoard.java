package com.example.foodorder;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodorder.Adapters.TeaAdapter;
import com.example.foodorder.Adapters.WillBuyAdapter;
import com.example.foodorder.Models.TeaModel;
import com.example.foodorder.Models.WillBuyModel;

import java.util.ArrayList;


public class DashBoard extends Fragment {
    TextView rec,gt,bt;
    RecyclerView recyclerView,willbuy;
    public DashBoard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rec=(TextView) getView().findViewById(R.id.Recommended);
        bt =(TextView) getView().findViewById(R.id.BT);
        gt =(TextView) getView().findViewById(R.id.GT);
        recyclerView=getView().findViewById(R.id.RecycleView);
        willbuy=getView().findViewById(R.id.WillbuyView);

        ArrayList<TeaModel> list=new ArrayList<>();
        list.add(new TeaModel("Lemon Tea",R.drawable.tea1));
        list.add(new TeaModel("Black Tea",R.drawable.tea2));
        list.add(new TeaModel("Green Tea",R.drawable.tea2));
        list.add(new TeaModel("Orange Tea",R.drawable.tea2));
        list.add(new TeaModel("Yellow Tea",R.drawable.tea2));
        TeaAdapter adapter=new TeaAdapter(list,view.getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<WillBuyModel> lst=new ArrayList<>();
        lst.add(new WillBuyModel(R.drawable.will1,"Bubble Tea","Good Morning","$56.99"));
        lst.add(new WillBuyModel(R.drawable.will1,"Bubble Tea","Good Morning","$56.99"));
        WillBuyAdapter adapter1 =new WillBuyAdapter(view.getContext(),lst);
        LinearLayoutManager lManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        willbuy.setLayoutManager(lManager);
        willbuy.setAdapter(adapter1);

        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rec.setBackgroundDrawable(getResources().getDrawable(R.drawable.item_selector));
                //#000000
                rec.setTextColor(Color.parseColor("#647039"));
                gt.setTextColor(Color.parseColor("#000000"));
                bt.setTextColor(Color.parseColor("#000000"));
                gt.setBackground(getResources().getDrawable(R.drawable.remove_bg));
                bt.setBackground(getResources().getDrawable(R.drawable.remove_bg));
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.item_selector));
                bt.setTextColor(Color.parseColor("#647039"));
                gt.setTextColor(Color.parseColor("#000000"));
                rec.setTextColor(Color.parseColor("#000000"));
                rec.setBackground(getResources().getDrawable(R.drawable.remove_bg));
                gt.setBackground(getResources().getDrawable(R.drawable.remove_bg));
            }
        });
        gt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gt.setBackground(getResources().getDrawable(R.drawable.item_selector));
                gt.setTextColor(Color.parseColor("#647039"));
                rec.setTextColor(Color.parseColor("#000000"));
                bt.setTextColor(Color.parseColor("#000000"));
                bt.setBackground(getResources().getDrawable(R.drawable.remove_bg));
                rec.setBackground(getResources().getDrawable(R.drawable.remove_bg));
            }
        });
    }
}