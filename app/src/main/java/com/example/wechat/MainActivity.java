package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Fragment tab01=new weixinFragment();
    private Fragment tab02=new friendFragment();
    private Fragment tab03=new txlFragment();
    private Fragment tab04=new settingFragment();

    private LinearLayout weixin;
    private LinearLayout friend;
    private LinearLayout txl;
    private LinearLayout setting;

    private ImageButton ImgWeiXin;
    private ImageButton ImgFriend;
    private ImageButton ImgTxl;
    private ImageButton ImgSetting;


    private FragmentManager fm;


    //主活动事件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        connect();
        addFragment();
        Listen();
        SelectFragment(0);


    }

    //连接LinearLayout和imagebutton
    private void connect(){

        weixin = findViewById(R.id.td_tab_wexin);
        friend = findViewById(R.id.td_tab_friend);
        txl = findViewById(R.id.td_tab_txl);
        setting = findViewById(R.id.td_tab_setting);

        ImgWeiXin = findViewById(R.id.imageButton1);
        ImgFriend = findViewById(R.id.imageButton2);
        ImgTxl = findViewById(R.id.imageButton3);
        ImgSetting = findViewById(R.id.imageButton4);


    }

    //通讯，添加
    private void addFragment(){
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.td_content,tab01);
        fragmentTransaction.add(R.id.td_content,tab02);
        fragmentTransaction.add(R.id.td_content,tab03);
        fragmentTransaction.add(R.id.td_content,tab04);
        fragmentTransaction.commit();//提交
    }


    //将tab全部隐藏
    private void hideFragment(FragmentTransaction fragmentTransaction){
        fragmentTransaction.hide(tab01);
        fragmentTransaction.hide(tab02);
        fragmentTransaction.hide(tab03);
        fragmentTransaction.hide(tab04);
    }

    //将img全部变成灰色
    private void hideImg(){
        ImgWeiXin.setImageResource(R.drawable.message_close);
        ImgFriend.setImageResource(R.drawable.friend_close);
        ImgTxl.setImageResource(R.drawable.txl_close);
        ImgSetting.setImageResource(R.drawable.setting_close);
    }


    //监听
    private void Listen(){
        weixin.setOnClickListener(this);
        friend.setOnClickListener(this);
        txl.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    //用选择语句，将tab的内容选择显示出来
    private void SelectFragment(int i){
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (i){
            case 0:
                fragmentTransaction.show(tab01);
                ImgWeiXin.setImageResource(R.drawable.message_open);
                break;
            case 1:
                fragmentTransaction.show(tab02);
                ImgFriend.setImageResource(R.drawable.friend_open);
                break;
            case 2:
                fragmentTransaction.show(tab03);
                ImgTxl.setImageResource(R.drawable.txl_open);
                break;
            case 3:
                fragmentTransaction.show(tab04);
                ImgSetting.setImageResource(R.drawable.setting_open);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        hideImg();
        switch (v.getId()){
            case R.id.td_tab_wexin:
                Log.v("hzf","第1个tab被点击");
                SelectFragment(0);
                break;
            case R.id.td_tab_friend:
                Log.v("hzf","第2个tab被点击");
                SelectFragment(1);
                break;
            case R.id.td_tab_txl:
                Log.v("hzf","第3个tab被点击");
                SelectFragment(2);
                break;
            case R.id.td_tab_setting:
                Log.v("hzf","第4个tab被点击");
                SelectFragment(3);
                break;
            default:
                break;
        }

    }
}
