package com.example.shiwu.Fragment;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.shiwu.MainActivity;
import com.example.shiwu.R;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import me.leefeng.promptlibrary.OnAdClickListener;
import me.leefeng.promptlibrary.PromptButton;
import me.leefeng.promptlibrary.PromptButtonListener;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.NOTIFICATION_SERVICE;
import static android.content.Context.VIBRATOR_SERVICE;

public class MyFragment extends Fragment {
    private static final String TAG = "MyFragment";
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    private NotificationManager manager;//通知渠道管理器

    @BindView(R.id.MyF_switch_msgsound)
    Switch MyFSwitchMsgsound;
    @BindView(R.id.MyF_switch_)
    Switch MyFSwitch;
    @BindView(R.id.MyF_switch_showQQ)
    Switch MyFSwitchShowQQ;
    @BindView(R.id.MyF_textView_qq)
    TextView MyFTextViewQq;
    @BindView(R.id.button3)
    Button button_out;
    @BindView(R.id.textView)
    TextView textView;
    private SoundPool soundPool;
    private int soundID;
    private Vibrator vibrator;
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
        button_out = view.findViewById(R.id.button3);//退出按钮
        button_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("确定要退出账号吗？喵喵喵？");
                dialog.setIcon(R.drawable.lost);

                dialog.setCancelable(false);
                dialog.setPositiveButton("喵", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyFTextViewQq.setText("  xxx  ");
                        profileImage.setImageResource(R.drawable.touxiang1);
                        Toast.makeText(getContext(), "已退出", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("汪", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "喵喵喵", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();

            }
        });

        MyFSwitchShowQQ = view.findViewById(R.id.MyF_switch_showQQ);//显示QQ号
        MyFSwitchShowQQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (MyFSwitchShowQQ.isChecked()) {
                    MyFTextViewQq.setText(qq);
                } else {

                    MyFTextViewQq.setText(" *** ");
                }
            }
        });

        MyFSwitchMsgsound = view.findViewById(R.id.MyF_switch_msgsound);
        MyFSwitchMsgsound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (MyFSwitchMsgsound.isChecked()) {
                    Notification notification = new NotificationCompat.Builder(getContext(), "chat")
                            .setAutoCancel(true)
                            .setContentTitle("收到系统消息")
                            .setContentText("您已打开系统通知")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            //设置红色
                            .setColor(Color.parseColor("#F00606"))
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                            .setContentIntent(pendingIntent)
                            .build();
                    manager.notify(1, notification);
                } else {


                }
            }
        });

        profileImage = view.findViewById(R.id.profile_image);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*");
                startActivityForResult(intent, 0x1);
            }
        });

        vibrator = (Vibrator)getActivity(). getSystemService(VIBRATOR_SERVICE);//震动器
        MyFSwitch = view.findViewById(R.id.MyF_switch_);//震动开关
        MyFSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //震动30毫秒
                vibrator.vibrate(30);
            }
        });

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "chat";
            String channelName = "聊天消息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);

            channelId = "subscribe";
            channelName = "订阅消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);
        }


    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
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

    @OnClick({R.id.MyF_switch_msgsound, R.id.MyF_switch_, R.id.MyF_switch_showQQ, R.id.MyF_textView_qq, R.id.button3, R.id.textView})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.MyF_switch_msgsound:
                playSound();
                break;
            case R.id.MyF_switch_://=震动

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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == 0x1 && resultCode == RESULT_OK) {
            if (data != null) {
                profileImage.setImageURI(data.getData());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
