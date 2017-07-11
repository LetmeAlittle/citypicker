package com.zaaach.citypicker;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zaaach.citypicker.utils.SystemUtils;

/**
 * Created by zhaozhipeng on 17/6/5.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /**
             * Android 5.0以上，全透明状态栏
             */
            SystemUtils.setTranslucentStatus(this);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            /**
             * Android 4.4以上，半透明状态栏
             */
            SystemUtils.setTranslucentStatus(this, true);
        }
    }

    /**
     * 初始化自定义的状态栏
     * 4.4以下，系统自带状态栏，隐藏自定义状态栏
     * 4.4以上，设置系统状态栏透明，显示自定义状态栏，并设置状态栏高度
     *
     * @param mStatusBar
     */
    public void initStatusBar(View mStatusBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mStatusBar.setVisibility(View.VISIBLE);
            mStatusBar.getLayoutParams().height = SystemUtils.getStatusHeight(this);
            mStatusBar.setLayoutParams(mStatusBar.getLayoutParams());
        } else {
            mStatusBar.setVisibility(View.GONE);
        }
    }

}
