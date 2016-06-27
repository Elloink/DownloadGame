package com.happybirthday.downloadgame;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.*;
import android.widget.*;
import android.view.View.*;

public class code_act extends Activity {
    private EditText person_text;
    private EditText password_text;
    private Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);
        Button button = (Button) findViewById(R.id.button);   //声明按钮
        person_text = (EditText) findViewById(R.id.person_text);        //声明文本框
        password_text = (EditText) findViewById(R.id.password_text);
        TextView nocode = (TextView) findViewById(R.id.nocode);//声明文本
        builder = new Builder(this);              //声明对话框权限
        button.setOnClickListener(new OnClickListener() {
            private Intent intent;

            @Override
            public void onClick(View arg0) {
                //String number = text.getText().toString();
                //char ch[] = number.toCharArray();
                String number = person_text.getText().toString();
                char ch1[] = number.toCharArray();
                String password = password_text.getText().toString();
                char ch2[] = password.toCharArray();
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < ch1.length; i++) {
                    sum1 += Integer.parseInt(ch1[i] + "");
                }
                for (int i = 0; i < ch2.length; i++) {
                    sum2 += Integer.parseInt(ch2[i] + "");
                }
                if (sum1 != 36) {
                    builder.setTitle("输入错误");
                    builder.setMessage("您所输入的身份码有误，请检查您输入的身份码，然后再试一次。");
                    builder.create().show();
                } else {
                    if (sum2 == 45) {
                        Intent intent = new Intent();
                        intent.setClass(code_act.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        builder.setTitle("输入错误");
                        builder.setMessage("您所输入的密码有误。请注意大小写。");
                        builder.create().show();
                    }
                }
            }
        });
        nocode.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("获取身份码");
                builder.setMessage("本软件的验证码封装于您从实体商店购买的软件存储介质(例如光盘、USB存储盘等)的外包装上，它由11位以内的阿拉伯数字组成。如果您是从其他地方获得的本软件，您应该立即卸载本软件。");
                builder.create().show();
            }
        });
    }

}