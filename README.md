# SpringDiaLog
自定义回弹公告栏，可以自定义内容视图。<br>
##效果展示

![image](https://github.com/RmondJone/SpringDiaLog/blob/master/SpringDiaLog/app/src/main/res/drawable/ScreenRecord_2017-02-04-09-18-47.gif)

##更新日志
* 更新时间2017年02月04日09:56:17----------SpringDiaLog V1.0.0

##API使用说明

```java
    /**
     * 说明 显示普通公告弹框
     * 作者 郭翰林
     * 创建时间 2017/2/4 上午9:59
     */
    private void showDialog() {
        SpringDiaLog diaLog = new SpringDiaLog(MainActivity.this,
                LayoutInflater.from(this).inflate(R.layout.contentview, null), SpringDiaLog.ViewType.TEXT);
        diaLog.setContentView_Margin_Top(8)  //设置外边距
                .setContentView_Margin_Bottom(8)
                .setContentView_Margin_Left(8)
                .setContentView_Margin_Right(8)
                .setOverScreen(true) //设置是否全屏,覆盖状态栏
                .setCloseButtonImg(R.drawable.closebutton) //设置关闭按钮图片
                .setCloseButtonListener(new View.OnClickListener() { //设置关闭按钮监听事件
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "关闭按钮点击事件", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    /**
     * 说明 显示自定义视图公告弹框
     * 作者 郭翰林
     * 创建时间 2017/1/17 下午3:21
     */
    private void showNoticMessage() {
        View view = LayoutInflater.from(this).inflate(R.layout.notice_layout, null);
        LinearLayout head_layout = (LinearLayout) view.findViewById(R.id.head_layout);
        TextView textView = (TextView) view.findViewById(R.id.notic_text);
        Button button = (Button) view.findViewById(R.id.closebutton);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.notic_img);

        head_layout.setVisibility(View.VISIBLE);


        //设值
        textView.setText(Html.fromHtml("<div class=\"lemma-summary\" label-module=\"lemmaSummary\">\n" +
                "<div class=\"para\" label-module=\"para\"><a target=\"_blank\" href=\"/subview/118581/6299428.htm\" data-lemmaid=\"16479\">阿尔卑斯</a><a target=\"_blank\" href=\"/subview/22361/22361.htm\" data-lemmaid=\"429007\">山脉</a>（<a target=\"_blank\" href=\"/subview/1458/1458.htm\" data-lemmaid=\"109997\">英语</a>Alps）位于欧洲中南部，覆盖了意大利北部、法国东南部、<a target=\"_blank\" href=\"/view/2773.htm\">瑞士</a>、<a target=\"_blank\" href=\"/view/21949.htm\">列支敦士登</a>、<a target=\"_blank\" href=\"/view/3836.htm\">奥地利</a>、德国南部及<a target=\"_blank\" href=\"/view/21925.htm\">斯洛文尼亚</a>。阿尔卑斯山脉自亚热带<a target=\"_blank\" href=\"/view/15817.htm\">地中海</a>海岸法国的<a target=\"_blank\" href=\"/subview/68134/5135885.htm\" data-lemmaid=\"4665\">尼斯</a>附近向北延伸至<a target=\"_blank\" href=\"/view/9421.htm\">日内瓦湖</a>，然后再向东北伸展至<a target=\"_blank\" href=\"/view/5894.htm\">多瑙河</a>上的<a target=\"_blank\" href=\"/view/10074.htm\">维也纳</a>。</div><div class=\"para\" label-module=\"para\">阿尔卑斯山脉呈<a target=\"_blank\" href=\"/view/4369590.htm\">弧形</a>，长1200千米，宽130千米--260千米，平均海拔约3000米，总面积大约为22万平方公里。其中有82座山峰超过4000米的海拔，最高峰是<a target=\"_blank\" href=\"/view/7423.htm\">勃朗峰</a>，海拔4810米，位于<a target=\"_blank\" href=\"/subview/64741/14766784.htm\" data-lemmaid=\"1173384\">法国</a>、<a target=\"_blank\" href=\"/subview/3784/14774423.htm\" data-lemmaid=\"148336\">意大利</a>和<a target=\"_blank\" href=\"/subview/2773/2773.htm\" data-lemmaid=\"131482\">瑞士</a>的交界处。</div><div class=\"para\" label-module=\"para\">阿尔卑斯山脉地处温带和亚热带纬度之间，成为中欧温带大陆性湿润气候和南欧亚热带夏干气候的<a target=\"_blank\" href=\"/view/948516.htm\">分界线</a>。高峰全年寒冷，在海拔2000米处年平均气温为O℃。山地年降水量一般为1200～2000毫米，但因地而异。海拔3000米左右为最大降水带。高山区年降水量超过2500毫米，<a target=\"_blank\" href=\"/view/3035219.htm\">背风坡</a>山间谷地只有750毫米。</div><div class=\"para\" label-module=\"para\">阿尔卑斯山脉是欧洲最大的山脉，同时也是是个巨大的<a target=\"_blank\" href=\"/view/146890.htm\">分水岭</a>，欧洲许多大河如<a target=\"_blank\" href=\"/view/5894.htm\">多瑙河</a>、<a target=\"_blank\" href=\"/subview/24634/10891783.htm\" data-lemmaid=\"20481\">莱茵河</a>、<a target=\"_blank\" href=\"/view/209546.htm\">波河</a>、<a target=\"_blank\" href=\"/view/163100.htm\">罗讷河</a>等均发源于此。各河上游都具有典型山地河流特点，水流湍急，水力资源丰富。</div>\n" +
                "</div>"));
        simpleDraweeView.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1486180317065&di=edece4fd1d570e6fa6380b16c05d9696&imgtype=0&src=http%3A%2F%2Fwww.33lc.com%2Farticle%2FUploadPic%2F2012-7%2F20127291061564636.jpg");


        final SpringDiaLog diaLog = new SpringDiaLog(this, view, SpringDiaLog.ViewType.BLEND);
        diaLog.setShowCloseButton(false)
                .setCanceledOnTouchOutside(false)
                .setContentViewWidth(280)
                .setContentViewHeight(400)
                .setStartAnimAngle(30)
                .show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaLog.close();
            }
        });
    }
    
    notice_layout.xml为自定义视图，具体的请下载Demo查看详细代码。
```
##目前支持可自定义属性
```java
    private int mBackGroudImg = -1; //弹框背景图片
    private int mCloseButtonImg = -1;//关闭按钮资源
    private View.OnClickListener mCloseButtonListener;//关闭按钮点击事件
    private boolean isOverScreen = true;    // 是否覆盖全屏幕
    private int mContentView_Margin_Left = 8;//内容视图左边距
    private int mContentView_Margin_Top = 8;//内容视图上边距
    private int mContentView_Margin_Right = 8;//内容视图右边距
    private int mContentView_Margin_Bottom = 8;//内容视图底边距
    private int mContentView_Margin = -1;//内容视图边距
    private boolean isShowCloseButton = true;//是否显示关闭按钮
    private boolean isCanceledOnTouchOutside = true; //是否点击外围触发关闭事件
    private int mStartAnimAngle = 270;//开始动画角度,0代表从右往左,逆时针算
    private int mContentViewWidth = 280;//内容视图宽度
    private int mContentViewHeight = 350;//内容视图高度
```

##问题反馈
* 联系方式：QQ(2318560278）
* 技术交流群：QQ(264587303)
* Demo作者：郭翰林
    
    
    
