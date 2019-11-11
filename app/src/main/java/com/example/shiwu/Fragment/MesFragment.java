package com.example.shiwu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.Adapter.Adapter_recyclerView_Mes;
import com.example.shiwu.R;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MesFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> list = new ArrayList();
    private PtrClassicFrameLayout mPtrClassicFrameLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mes, container, false);
        initList();
        recyclerView = view.findViewById(R.id.MesF_recyclerView);
        recyclerView.setAdapter(new Adapter_recyclerView_Mes(list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mPtrClassicFrameLayout =  view.findViewById(R.id.store_house_ptr_frame);//下拉刷新
        mPtrClassicFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrClassicFrameLayout.refreshComplete();
                        Toast.makeText(getContext(), "还没有新消息哦", Toast.LENGTH_SHORT).show();
                        mPtrClassicFrameLayout.setLastUpdateTimeKey("2017-2-10");
                    }
                }, 2000);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });

        return view;
    }

    private void initList() {

            String s1 = "  新增物品招领 校园卡";
            list.add(s1);

            String s2 = "  新增物品招领 黑色书包";
            list.add(s2);

            String s3 = "  新增物品招领 数学课本";
            list.add(s3);

            String s4 = "  用户须知";
            list.add(s4);

            String s5 = "  注册成功啦 快来看看附近捡到了哪些东西吧";
            list.add(s5);

    }


}
