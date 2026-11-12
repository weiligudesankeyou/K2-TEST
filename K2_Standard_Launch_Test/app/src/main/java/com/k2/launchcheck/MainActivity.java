package com.k2.launchcheck;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Minimal old-Android compatible TV launcher test.
 * Uses Android framework APIs available on API 19, no libraries or permissions.
 */
public final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView content = new TextView(this);
        content.setTextColor(Color.WHITE);
        content.setTextSize(26f);
        content.setGravity(Gravity.CENTER_VERTICAL);
        content.setPadding(34, 24, 34, 24);
        content.setFocusable(true);
        content.setText(
                "K2 启动测试成功！\n\n" +
                "K2 LAUNCH OK\n\n" +
                "API Level: " + Build.VERSION.SDK_INT + "\n" +
                "Android Release: " + Build.VERSION.RELEASE + "\n" +
                "CPU ABI: " + Build.CPU_ABI + "\n" +
                "Model: " + Build.MODEL + "\n" +
                "Device: " + Build.DEVICE + "\n\n" +
                "遥控器返回键可以退出。"
        );

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(Color.rgb(22, 30, 44));
        scroll.addView(content);
        setContentView(scroll);
    }
}
