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

        KindF_item item = new KindF_item();
        item.setImage(R.drawable.kind_xiaoyuanka);
        item.setName("校园卡");
        list.add(item);

        KindF_item item1 = new KindF_item();
        item1.setImage(R.drawable.kind_shuika);
        item1.setName("水卡");
        list.add(item1);

        KindF_item item2 = new KindF_item();
        item2.setImage(R.drawable.kind_shenfenzhen);
        item2.setName("身份证");
        list.add(item2);

        KindF_item item3 = new KindF_item();
        item3.setImage(R.drawable.kind_shouji);
        item3.setName("手机");
        list.add(item3);

        KindF_item item4 = new KindF_item();
        item4.setImage(R.drawable.kind_xiaoyugan);
        item4.setName("小鱼干");
        list.add(item4);

        KindF_item item5 = new KindF_item();
        item5.setImage(R.drawable.kind_qita);
        item5.setName("其他");
        list.add(item5);

    }
}
