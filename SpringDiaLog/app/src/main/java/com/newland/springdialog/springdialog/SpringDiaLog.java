package com.newland.springdialog.springdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.rebound.Spring;
import com.newland.springdialog.R;

/**
 * 说明
 * 作者 郭翰林
 * 创建时间 2017/1/15.
 */

public class SpringDiaLog {
    private Activity mContext;
    private View mContentView; //弹框内容视图布局ID
    private ViewType mViewType; //视图类型

    public enum ViewType {
        TEXT  //纯文本
        , IMG  //单图片
        , BLEND //图文混排
    }

    private int mBackGroudImg = -1; //弹框背景图片
    private int mCloseButtonImg = -1;//关闭按钮资源
    private View.OnClickListener mCloseButtonListener;//关闭按钮点击事件
    private boolean isOverScreen = true;    // 是否覆盖全屏幕
    private int mContentView_Margin_Left = 8;//内容视图左边距
    private int mContentView_Margin_Top = 8;//内容视图上边距
    private int mContentView_Margin_Right = 8;//内容视图右边距
    private int mContentView_Margin_Bottom = 8;//内容视图底边距
    private int mContentView_Margin = -1;//内容视图边距

    private ImageView mCloseButton;//关闭按钮
    private ViewGroup androidContentView;//屏幕根视图
    private View mRootView;//根视图
    private RelativeLayout mContainerView; //内容视图背景视图
    private RelativeLayout mAnimationView;//动画View;
    private FrameLayout mContentView_FrameLayout;
    private boolean isShowing;//弹框是否显示


    public SpringDiaLog(Activity mContext, View mContentView) {
        this.mContext = mContext;
        this.mContentView = mContentView;
        this.mViewType = ViewType.BLEND;
        initView();
    }

    public SpringDiaLog(Activity mContext, View mContentView, ViewType mViewType) {
        this.mContext = mContext;
        this.mContentView = mContentView;
        this.mViewType = mViewType;
        initView();
    }

    /**
     * 说明 初始化控件
     * 作者 郭翰林
     * 创建时间 2017/1/15 上午11:20
     */
    private void initView() {
        if (isOverScreen) {
            androidContentView = (ViewGroup) mContext.getWindow().getDecorView();
        } else {
            androidContentView = (ViewGroup) mContext.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        }
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.spring_dialog_layout, null);
        if (mRootView != null) {
            mCloseButton = (ImageView) mRootView.findViewById(R.id.iv_close);
            mCloseButton.setImageDrawable(mContext.getResources().getDrawable(R.drawable.closebutton));

            mContainerView = (RelativeLayout) mRootView.findViewById(R.id.contentView);
            if (mViewType != ViewType.TEXT) {
                mContainerView.setBackground(mContext.getResources().getDrawable(R.drawable.dialog_backimg));
            } else {
                mContainerView.setBackground(mContext.getResources().getDrawable(R.drawable.springdialog_backimg));
            }

            mAnimationView = (RelativeLayout) mRootView.findViewById(R.id.anim_container);

            mContentView_FrameLayout = (FrameLayout) mRootView.findViewById(R.id.fl_content_container);

        } else {
            Log.e("控件初始化失败", "LayoutInflater获取根视图失败！");
        }
    }

    /**
     * 说明 显示弹框
     * 作者 郭翰林
     * 创建时间 2017/1/15 上午11:33
     */
    public void show() {
        isShowing = true;
        double radius = Math.sqrt(DisplayUtil.screenhightPx * DisplayUtil.screenhightPx + DisplayUtil.screenWidthPx * DisplayUtil.screenWidthPx);
        final double heightY = -Math.sin(Math.toRadians(270)) * radius;
        final double widthX = Math.cos(Math.toRadians(270)) * radius;

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCloseButtonListener != null) {
                    mCloseButtonListener.onClick(view);
                }
                AnimSpring.getInstance(mAnimationView).startTranslationAnim(0, 0, widthX, -heightY);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        androidContentView.removeView(mRootView);
                    }
                }, 400);
            }
        });

        if (mCloseButtonImg != -1) {
            mCloseButton.setImageDrawable(mContext.getResources().getDrawable(mCloseButtonImg));
        }
        if (mBackGroudImg != -1) {
            mContainerView.setBackground(mContext.getResources().getDrawable(mBackGroudImg));
        }

        //加入视图操作
        FrameLayout.LayoutParams contentParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (mContentView_Margin != -1) {
            contentParams.setMargins(mContentView_Margin, mContentView_Margin, mContentView_Margin, mContentView_Margin);
        } else {
            contentParams.setMargins(mContentView_Margin_Left, mContentView_Margin_Top, mContentView_Margin_Right, mContentView_Margin_Bottom);
        }
        mContentView_FrameLayout.addView(mContentView, contentParams);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        androidContentView.addView(mRootView, params);

        //加入视图动画
        AnimSpring.getInstance(mAnimationView).startTranslationAnim(widthX, heightY, 0, 0);
    }


    //属性初始化

    public SpringDiaLog setBackGroudImg(int mBackGroudImg) {
        this.mBackGroudImg = mBackGroudImg;
        return this;
    }

    public SpringDiaLog setCloseButtonImg(int mCloseButtonImg) {
        this.mCloseButtonImg = mCloseButtonImg;
        return this;
    }

    public SpringDiaLog setCloseButtonListener(View.OnClickListener mCloseButtonListener) {
        this.mCloseButtonListener = mCloseButtonListener;
        return this;
    }

    public boolean isOverScreen() {
        return isOverScreen;
    }

    public SpringDiaLog setOverScreen(boolean overScreen) {
        isOverScreen = overScreen;
        return this;
    }

    public SpringDiaLog setContentView_Margin_Left(int mContentView_Margin_Left) {
        this.mContentView_Margin_Left = mContentView_Margin_Left;
        return this;
    }

    public SpringDiaLog setContentView_Margin_Top(int mContentView_Margin_Top) {
        this.mContentView_Margin_Top = mContentView_Margin_Top;
        return this;
    }

    public SpringDiaLog setContentView_Margin_Right(int mContentView_Margin_Right) {
        this.mContentView_Margin_Right = mContentView_Margin_Right;
        return this;
    }

    public SpringDiaLog setContentView_Margin_Bottom(int mContentView_Margin_Bottom) {
        this.mContentView_Margin_Bottom = mContentView_Margin_Bottom;
        return this;
    }

    public SpringDiaLog setContentView_Margin(int mContentView_Margin) {
        this.mContentView_Margin = mContentView_Margin;
        return this;
    }
}
