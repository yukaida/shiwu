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

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.button_signin)
    Button buttonSignin;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.editText_account)
    EditText editTextAccount;
    @BindView(R.id.editText_password)
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    @OnClick({R.id.button_signin, R.id.button_login, R.id.editText_account, R.id.editText_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_signin:
                Intent intent2 = new Intent(LoginActivity.this, StartActivity.class);
                intent2.putExtra("qq", editTextAccount.getText().toString().trim());
                startActivity(intent2);

                break;
            case R.id.button_login:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("qq", editTextAccount.getText().toString().trim());
                startActivity(intent);
                finish();
                break;
            case R.id.editText_account:
                break;
            case R.id.editText_password:
                break;
        }
    }
}
