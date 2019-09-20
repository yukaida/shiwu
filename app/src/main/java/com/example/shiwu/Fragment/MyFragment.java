package com.example.shiwu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.Adapter.Adapter_recyclerView_My;
import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.MyF_Item;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<MyF_Item> list = new ArrayList<>();

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        recyclerView = view.findViewById(R.id.MyF_recyclerView);
        initList();
        recyclerView.setAdapter(new Adapter_recyclerView_My(list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private void initList() {
        for (int i = 0; i < 5; i++) {
            MyF_Item item = new MyF_Item();
            item.setImage(R.drawable.ic_launcher_background);
            item.setText("功能" + i);
            list.add(item);
        }
    }
}
