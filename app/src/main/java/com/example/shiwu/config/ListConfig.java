package com.example.shiwu.config;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.HomeF_item;

import java.util.ArrayList;
import java.util.List;

public class ListConfig {
    public List<HomeF_item> recyclerViewlist = new ArrayList<>();

    public ListConfig() {
        super();
        init();
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            HomeF_item homeF_item = new HomeF_item();
            homeF_item.setImage(R.drawable.home_item);
            homeF_item.setName("things" + i);
            homeF_item.setDescribe("这是一件丢失的物品");
            recyclerViewlist.add(homeF_item);
        }
    }
}
