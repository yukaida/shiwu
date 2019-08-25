package com.example.shiwu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.tab_two);
        bottomNavigationView.setItemIconTintList(null);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        switch (itemId){
            case R.id.tab_one:
                menuItem.setChecked(true);
                break;
            case R.id.tab_two:
                menuItem.setChecked(true);
                break;
            case R.id.tab_three:
                menuItem.setChecked(true);
                break;
            case R.id.tab_four:
                menuItem.setChecked(true);
                break;
        }
        return false;
    }




}
