package com.example.shiwu.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.shiwu.MainActivity;
import com.example.shiwu.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private View view;
    private List<View> viewPagerlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        initViewPager_item();
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


}
