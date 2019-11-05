package com.example.shiwu.Fragment;

import android.annotation.SuppressLint;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiwu.R;
import com.example.shiwu.RecyclerView_item.MyF_Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyFragment extends Fragment {



    private SoundPool soundPool;
    private int soundID;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }



    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(getActivity(),R.raw.messagesent, 1);
    }


    private void playSound() {
        soundPool.play(
                soundID,
                0.1f,      //左耳道音量【0~1】
                0.5f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }

}
