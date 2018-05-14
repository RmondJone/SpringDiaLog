# SpringDiaLog
自定义回弹广告弹窗，可以自定义内容视图。<br>

## 效果展示

![image](https://github.com/RmondJone/SpringDiaLog/blob/master/GIF.gif)

## 工程集成说明
* 第一步
```java
//在工程gradle文件里
allprojects {
    repositories {
        .......
        maven { url 'https://jitpack.io' }
        ......
    }
}
```

```java
//如果不在工程gradle文件里加入，也可以加入模块gradle文件中
repositories {
    maven {
        url  "https://jitpack.io"
    }
}
```
* 第二步
```java
  dependencies {
		compile 'com.github.RmondJone:SpringDiaLog:1.0.2'
	}
```

## API使用说明

```java
    /**
     * 说明 显示广告弹框
     * 作者 郭翰林
     * 创建时间 2017/2/4 上午9:59
     */
    private void showDialog() {
        View view=LayoutInflater.from(this).inflate(R.layout.contentview,null);
        SimpleDraweeView imageView=(SimpleDraweeView) view.findViewById(R.id.advterImg);
        imageView.setImageURI("http://img.zcool.cn/community/01284e57a199450000018c1bfa91c8.jpg@1280w_1l_2o_100sh.webp");
        SpringDiaLog springDiaLog=new SpringDiaLog(this,view);
        springDiaLog.show();
    }
```
## 目前支持可自定义属性
```java
    private int mBackGroudImg = -1; //弹框背景图片
    private int mCloseButtonImg = -1;//关闭按钮资源
    private View.OnClickListener mCloseButtonListener;//关闭按钮点击事件
    private boolean isOverScreen = true;    // 是否覆盖全屏幕
    private boolean isShowCloseButton = true;//是否显示关闭按钮
    private boolean isCanceledOnTouchOutside = true; //是否点击外围触发关闭事件
    private int mStartAnimAngle = 270;//开始动画角度,0代表从右往左,逆时针算
    private int mContentViewWidth = 280;//内容视图宽度
    private int mContentViewHeight = 350;//内容视图高度
```

## 问题反馈
* 有问题请先更新在Issues里
* 技术交流群：QQ(264587303)
* Demo作者：郭翰林
