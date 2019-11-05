package com.example.shiwu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.shiwu.Fragment.HomeFragment;
import com.example.shiwu.Fragment.KindFragment;
import com.example.shiwu.Fragment.MesFragment;
import com.example.shiwu.Fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager manager=getSupportFragmentManager();
    private long firstTime;// 记录点击返回时第一次的时间毫秒值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏状态栏
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initView();
        replaceFragment(new HomeFragment()); //启动时用HomeFragment替换掉空Fragment
    }

    public void initView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);//设置导航栏监听器
        bottomNavigationView.setSelectedItemId(R.id.tab_one);//设置默认选择的导航栏子项tab_one即首页
        bottomNavigationView.setItemIconTintList(null);//取消导航栏子项图片的颜色覆盖
    }

    @Override
    //处理导航栏子项的点击事件
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();//获取点击的位置以及对应的id
        switch (itemId) {
            case R.id.tab_one:
                replaceFragment(new HomeFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
                menuItem.setChecked(true);
                break;
            case R.id.tab_two:
                replaceFragment(new KindFragment());
                menuItem.setChecked(true);
                break;
            case R.id.tab_three:
                replaceFragment(new MesFragment());
                menuItem.setChecked(true);
                break;
            case R.id.tab_four:
                replaceFragment(new MyFragment());
                menuItem.setChecked(true);
                break;
        }
        return false;
    }

//替换Fragment的方法
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_empty, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){// 点击了返回按键
            if(manager.getBackStackEntryCount() != 0){
                manager.popBackStack();
            }else {
                exitApp(2000);// 退出应用
            }
            return true;// 返回true，防止该事件继续向下传播
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出应用
     * @param timeInterval 设置第二次点击退出的时间间隔
     */
    private void exitApp(long timeInterval) {
        // 第一次肯定会进入到if判断里面，然后把firstTime重新赋值当前的系统时间
        // 然后点击第二次的时候，当点击间隔时间小于2s，那么退出应用；反之不退出应用
        if(System.currentTimeMillis() - firstTime >= timeInterval){
            Toast.makeText(this, "再按一次 退出程序", Toast.LENGTH_SHORT).show();
            firstTime = System.currentTimeMillis();
        }else {
            finish();// 销毁当前activity
            System.exit(0);// 完全退出应用
        }
    }

}
