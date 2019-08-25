package com.example.shiwu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shiwu.Fragment.EmptyFragment;
import com.example.shiwu.Fragment.HomeFragment;
import com.example.shiwu.Fragment.KindFragment;
import com.example.shiwu.Fragment.MesFragment;
import com.example.shiwu.Fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        replaceFragment(new HomeFragment());
        bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(0).getItemId());
    }

    public void initView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.tab_two);
        bottomNavigationView.setItemIconTintList(null);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        switch (itemId) {
            case R.id.tab_one:
                replaceFragment(new HomeFragment());
                menuItem.setChecked(true);
                break;
            case R.id.tab_two:
                replaceFragment(new KindFragment());
                menuItem.setChecked(true);
                break;
            case R.id.tab_three:
                replaceFragment(new MesFragment());
                menuItem.setChecked(true);
                break;
            case R.id.tab_four:
                replaceFragment(new MyFragment());
                menuItem.setChecked(true);
                break;
        }
        return false;
    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_empty, fragment);
        transaction.commit();
    }
}
