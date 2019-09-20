package com.example.shiwu.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.shiwu.Adapter.Adapter_recyclerView_kind;
import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.KindF_item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class KindFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<KindF_item> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind, container, false);
        initList();
        recyclerView = view.findViewById(R.id.kindF_recyclerView);
        recyclerView.setAdapter(new Adapter_recyclerView_kind(list));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        return view;
    }

    void initList() {
        for (int i = 0; i < 10; i++) {
            KindF_item item = new KindF_item();
            item.setImage(R.drawable.ic_launcher_background);
            item.setName("测试" + i);
            list.add(item);
        }
    }
}
