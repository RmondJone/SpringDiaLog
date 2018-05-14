package com.newland.springdialogTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.newland.springdialog.SpringDiaLog;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Button mCustomButton;

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

        mCustomButton = (Button) findViewById(R.id.showcustomdialog);
        mCustomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNoticMessage();
            }
        });
    }


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


        final SpringDiaLog diaLog = new SpringDiaLog(this, view);
        diaLog.setShowCloseButton(false)
                .setCanceledOnTouchOutside(false)
                .setContentViewWidth(280)
                .setContentViewHeight(400)
                .setStartAnimAngle(30)
                .setBackGroudImg(R.drawable.dialog_backimg)
                .show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaLog.close();
            }
        });
    }
}
