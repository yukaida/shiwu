package com.example.shiwu.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.Adapter.Adapter_recyclerView_home;
import com.example.shiwu.Adapter.Adapter_recyclerView_kind;
import com.example.shiwu.Adapter.Adapter_recyclerView_kindofthings;
import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.KindOfA_item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KindofThingsActivity extends AppCompatActivity {
    private List<KindOfA_item> list;
    @BindView(R.id.recyclerView_kindofthings)
    RecyclerView recyclerViewKindofthings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kindof_things);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        initList();

        recyclerViewKindofthings.setAdapter(new Adapter_recyclerView_kindofthings(getApplicationContext(),list));
        recyclerViewKindofthings.setLayoutManager(new LinearLayoutManager(this));

        //隐藏状态栏
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void initList(){
        KindOfA_item kindOfA_item = new KindOfA_item();
        kindOfA_item.setId(R.drawable.lost);
        kindOfA_item.setDescribe("11月12日下午在操场找到的，失主点击下方qq号与我联系");
        kindOfA_item.setQq("15216043611");
        list.add(kindOfA_item);


        KindOfA_item kindOfA_item1 = new KindOfA_item();
        kindOfA_item1.setId(R.drawable.lost);
        kindOfA_item1.setDescribe("11月10日上午在三食堂捡到的校园卡");
        kindOfA_item1.setQq("1204977167");
        list.add(kindOfA_item1);

        KindOfA_item kindOfA_item2 = new KindOfA_item();
        kindOfA_item2.setId(R.drawable.lost);
        kindOfA_item2.setDescribe("11月11日早上在C场捡到钱包一个");
        kindOfA_item2.setQq("1124211");
        list.add(kindOfA_item2);

        KindOfA_item kindOfA_item3 = new KindOfA_item();
        kindOfA_item3.setId(R.drawable.lost);
        kindOfA_item3.setDescribe("11月12日下午在操场找到的，失主点击下方qq号与我联系");
        kindOfA_item3.setQq("65213311");
        list.add(kindOfA_item3);

        KindOfA_item kindOfA_item4 = new KindOfA_item();
        kindOfA_item4.setId(R.drawable.lost);
        kindOfA_item4.setDescribe("11月8日晚上在先骕楼捡到身份证一张");
        kindOfA_item4.setQq("2421611");
        list.add(kindOfA_item4);

    }
}
