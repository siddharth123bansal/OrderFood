package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout cont;
    TextView rec;
    TextView bt;
    TextView gt;
    Toolbar tool;
    ImageView s,h,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(tool);
        drawerLayout=findViewById(R.id.NaigationDrawer);
        navigationView=findViewById(R.id.navigationView);
        tool=findViewById(R.id.toolbar);
        cont=findViewById(R.id.Container);
        h=findViewById(R.id.home);
        s=findViewById(R.id.shop);
        c=findViewById(R.id.cart);
        ActionBarDrawerToggle tgl=new ActionBarDrawerToggle(this,drawerLayout,tool,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(tgl);
        tgl.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.categories:
                        Toast.makeText(MainActivity.this, "Categories", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Orders:
                        Toast.makeText(MainActivity.this, "Your Orders", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Wishlist:
                        Toast.makeText(MainActivity.this, "Wishlist", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.faqs:
                        Toast.makeText(MainActivity.this, "FAQs", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.LogOut:
                        Toast.makeText(MainActivity.this, "Log Out", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });
        loadFragement(new DashBoard());
//        ImageView btn=(ImageView) findViewById(R.id.backBtn);

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragement(new DashBoard());
                Toast.makeText(MainActivity.this, "Home Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Shop Perssed", Toast.LENGTH_SHORT).show();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,CartDetails.class);
                startActivity(intent);
            }
        });
    }
    public void loadFragement(Fragment fg) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        ft.add(cont.getId(),new DashBoard());
        ft.commit();
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}