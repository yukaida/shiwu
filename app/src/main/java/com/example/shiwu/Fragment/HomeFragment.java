package com.example.shiwu.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.shiwu.Adapter.Adapter_recyclerView_home;
import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.HomeF_item;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private View view;
    private List<View> viewPagerlist = new ArrayList<>();
    private List<HomeF_item> recyclerViewlist = new ArrayList<>();
    private static final String TAG = "HomeFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        initViewPager_item();
        initRecyclerView_item();
        Log.d(TAG, "onCreateView: "+recyclerViewlist);//测试
        recyclerView.setAdapter(new Adapter_recyclerView_home(recyclerViewlist));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewPagerlist.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewPagerlist.get(position));
                return viewPagerlist.get(position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(viewPagerlist.get(position));

            }
        });

        return view;
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.recyclerView_homeF);
        viewPager = view.findViewById(R.id.viewPager_HomeF);
    }

    private void initViewPager_item() {
        {
            View view = View.inflate(getContext(), R.layout.fragment_home_viewpager_item, null);
            ImageView imageView = view.findViewById(R.id.imageView_homeF_viewpager);
            imageView.setBackgroundColor(Color.RED);
            viewPagerlist.add(view);
        }
        {
            View view = View.inflate(getContext(), R.layout.fragment_home_viewpager_item, null);
            ImageView imageView = view.findViewById(R.id.imageView_homeF_viewpager);
            imageView.setBackgroundColor(Color.GREEN);
            viewPagerlist.add(view);
        }
        {
            View view = View.inflate(getContext(), R.layout.fragment_home_viewpager_item, null);
            ImageView imageView = view.findViewById(R.id.imageView_homeF_viewpager);
            imageView.setBackgroundColor(Color.BLUE);
            viewPagerlist.add(view);
        }
    }

    private void initRecyclerView_item(){
        for (int i = 0; i < 10; i++) {
            HomeF_item homeF_item = new HomeF_item();
            homeF_item.setImage(R.drawable.ic_launcher_background);
            homeF_item.setName("things"+i);
            homeF_item.setDescribe("这是一件丢失的物品");
            recyclerViewlist.add(homeF_item);

        }
    }
}
