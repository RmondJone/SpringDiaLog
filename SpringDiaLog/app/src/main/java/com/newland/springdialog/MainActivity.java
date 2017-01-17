package com.newland.springdialog;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;
import com.newland.springdialog.springdialog.SpringDiaLog;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.showdialog);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    private void showDialog() {
        SpringDiaLog diaLog = new SpringDiaLog(MainActivity.this,
                LayoutInflater.from(this).inflate(R.layout.contentview, null), SpringDiaLog.ViewType.IMG);
        diaLog.setContentView_Margin_Top(8)  //设置外边距
                .setContentView_Margin_Bottom(8)
                .setContentView_Margin_Left(8)
                .setContentView_Margin_Right(8)
                .setOverScreen(true) //设置是否全屏,覆盖状态栏
                .setCloseButtonImg(R.drawable.closebutton) //设置关闭按钮图片
                .setCloseButtonListener(new View.OnClickListener() { //设置关闭按钮监听事件
                    @Override
                    public void onClick(View view) {
                        Log.e("关闭按钮", "被触发");
                    }
                })
                .show();
    }
}
