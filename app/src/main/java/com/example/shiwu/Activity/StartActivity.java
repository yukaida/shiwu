package com.example.shiwu.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiwu.MainActivity;
import com.example.shiwu.R;
import com.moos.library.CircleProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {


    @BindView(R.id.button_signin2)
    Button buttonSignin2;
    @BindView(R.id.editText_account2)
    EditText editTextAccount2;
    @BindView(R.id.editText_password2)
    EditText editTextPassword2;
    private CircleProgressView circleProgressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        //隐藏状态栏
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @OnClick({R.id.button_signin2, R.id.editText_account2, R.id.editText_password2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_signin2:

                circleProgressView =findViewById(R.id.progressView_circle);
                circleProgressView.setVisibility(View.VISIBLE);
                circleProgressView.setStartProgress(0);
                circleProgressView.setEndProgress(100);
                circleProgressView.setCircleBroken(true);
                circleProgressView.setTrackWidth(20);
                circleProgressView.setProgressDuration(2000);
                circleProgressView.setTrackEnabled(true);
                circleProgressView.setFillEnabled(false);
                circleProgressView.startProgressAnimation();
                circleProgressView.setProgressTextVisibility(false);

                //todo  旋转加载框 延迟两秒关闭
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         *要执行的操作
                         */
                        Toast.makeText(StartActivity.this, "注册成功啦", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(StartActivity.this, MainActivity.class);
                        intent.putExtra("qq", editTextAccount2.getText().toString().trim());
                        startActivity(intent);

                        finish();
                    }
                }, 3000);//3秒后执行Runnable中的run方法



                break;
            case R.id.editText_account2:
                break;
            case R.id.editText_password2:
                break;
        }
    }
}
