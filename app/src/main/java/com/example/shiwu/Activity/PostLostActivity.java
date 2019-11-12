package com.example.shiwu.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiwu.R;
import com.google.android.material.snackbar.Snackbar;
import com.moos.library.HorizontalProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostLostActivity extends AppCompatActivity {

    @BindView(R.id.imageView_post)
    ImageView imageViewPost;
    @BindView(R.id.editText_post)
    EditText editTextPost;
    @BindView(R.id.button_post)
    Button buttonPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_lost);
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

    @OnClick({R.id.imageView_post, R.id.button_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_post:
                imageViewPost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_PICK, null);
                        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                "image/*");
                        startActivityForResult(intent, 0x1);
                    }
                });

                break;
            case R.id.button_post:

                HorizontalProgressView horizontalProgressView = findViewById(R.id.progressView_horizontal);
                horizontalProgressView.setStartProgress(0);
                horizontalProgressView.setEndProgress(100);
//                horizontalProgressView.setStartColor(Color.parseColor("#FF8F5D"));
//                horizontalProgressView.setEndColor(Color.parseColor("#F54EA2"));
                horizontalProgressView.setTrackWidth(30);
                horizontalProgressView.setProgressDuration(2000);
                horizontalProgressView.setTrackEnabled(true);
                horizontalProgressView.setProgressCornerRadius(20);
                horizontalProgressView.setProgressTextPaddingBottom(12);
                horizontalProgressView.startProgressAnimation();

                Snackbar.make(view, "正在发布 请稍候", Snackbar.LENGTH_SHORT)
                        .show();

                //todo  旋转加载框 延迟两秒关闭
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         *要执行的操作
                         */
                        Toast.makeText(PostLostActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, 3000);//3秒后执行Runnable中的run方法
                
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == 0x1 && resultCode == RESULT_OK) {
            if (data != null) {
                imageViewPost.setImageURI(data.getData());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
