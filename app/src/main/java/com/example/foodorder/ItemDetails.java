package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        String name=getIntent().getStringExtra("name");
        int img=getIntent().getIntExtra("image",0);
        TextView txt=findViewById(R.id.tit);
        ImageView imageView =findViewById(R.id.ima);
        //imageView.setImageResource(img);
        ImageView imgs =findViewById(R.id.sbackbtn);
        imgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ItemDetails.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txt.setText(name);
    }
}