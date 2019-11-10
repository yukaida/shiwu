package com.example.shiwu.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiwu.MainActivity;
import com.example.shiwu.R;

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
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("qq", editTextAccount2.getText().toString().trim());
                startActivity(intent);
                finish();
                break;
            case R.id.editText_account2:
                break;
            case R.id.editText_password2:
                break;
        }
    }
}
