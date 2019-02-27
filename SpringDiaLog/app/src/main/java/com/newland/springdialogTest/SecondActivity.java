package com.newland.springdialogTest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;
import com.newland.springdialog.SpringDiaLog;

/**
 * @author 郭翰林
 * @date 2019/2/27 0027 16:49
 * 注释:
 */
public class SecondActivity extends Activity {
    private Button mButton;
    private SpringDiaLog springDiaLog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);
        mButton = (Button) findViewById(R.id.showdialog2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    /**
     * 说明 显示广告弹框
     * 作者 郭翰林
     * 创建时间 2017/2/4 上午9:59
     */
    private void showDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.contentview, null);
        SimpleDraweeView imageView = (SimpleDraweeView) view.findViewById(R.id.advterImg);
        imageView.setImageURI("http://img.zcool.cn/community/01284e57a199450000018c1bfa91c8.jpg@1280w_1l_2o_100sh.webp");
        if (springDiaLog == null) {
            springDiaLog = new SpringDiaLog(this, view);
            springDiaLog.setShowCloseButton(true)//是否显示关闭按钮
                    .setCanceledOnTouchOutside(false)//触碰外围是否可关闭弹窗
                    .setContentViewWidth(280)//设置内容视图宽度
                    .setContentViewHeight(400)//设置内容视图高度
                    .setStartAnimAngle(0)//设置进场角度,0是3点钟方向从右往左，然后逆时针类推
                    .setUseAnimation(true)//是否使用进场动画
                    .show();
        } else {
            springDiaLog.show();
        }
    }
}
