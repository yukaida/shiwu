package com.example.shiwu.Fragment;

import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shiwu.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends Fragment {
    private static final String TAG = "MyFragment";

    @BindView(R.id.MyF_imageView_icon)
    ImageView MyFImageViewIcon;
    @BindView(R.id.MyF_switch_msgsound)
    Switch MyFSwitchMsgsound;
    @BindView(R.id.MyF_switch_)
    Switch MyFSwitch;
    @BindView(R.id.MyF_switch_showQQ)
    Switch MyFSwitchShowQQ;
    @BindView(R.id.MyF_textView_qq)
    TextView MyFTextViewQq;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.textView)
    TextView textView;
    private SoundPool soundPool;
    private int soundID;

    private String qq = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initSound();
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        Bundle bundle = getArguments();
         qq = bundle.getString("qq");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyFTextViewQq = view.findViewById(R.id.MyF_textView_qq);
        MyFTextViewQq.setText(qq);
        button3 = view.findViewById(R.id.button3);

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(getActivity(), R.raw.messagesent, 1);
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

    @OnClick({R.id.MyF_imageView_icon, R.id.MyF_switch_msgsound, R.id.MyF_switch_, R.id.MyF_switch_showQQ, R.id.MyF_textView_qq, R.id.button3, R.id.textView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.MyF_imageView_icon:
                break;
            case R.id.MyF_switch_msgsound:
                playSound();
                break;
            case R.id.MyF_switch_://消息提示音
                break;
            case R.id.MyF_switch_showQQ:


                break;
            case R.id.MyF_textView_qq:
                break;
            case R.id.button3:
                break;
            case R.id.textView:
                break;
        }
    }
}
