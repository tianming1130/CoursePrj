package com.sun.courseprj.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.courseprj.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class BaseUI extends AppCompatActivity implements View.OnClickListener{

    private EditText etUserName,etPassword;
    private Button btnLogin,btnCancel;
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_ui);

        etUserName=(EditText)findViewById(R.id.et_user_name);
        etPassword=(EditText)findViewById(R.id.et_password);

        btnLogin=(Button)findViewById(R.id.btn_login);
        btnCancel=(Button)findViewById(R.id.btn_cancel);

        tvRegister=(TextView)findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.tv_register:
                Register();
                break;
        }
    }
    private void login(){
        String strUserName=etUserName.getText().toString();
        String strPassword=etPassword.getText().toString();
//        if (strUserName.equals("abc") && strPassword.equals("123456")){
//            Toast.makeText(this,"登录成功！",Toast.LENGTH_LONG).show();
//        }else {
//            Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_LONG).show();
//        }
        BmobUser bu = new BmobUser();
        bu.setUsername(strUserName);
        bu.setPassword(strPassword);
        bu.login(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(BaseUI.this,"登录成功:",Toast.LENGTH_LONG).show();

                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                }else{
                    Toast.makeText(BaseUI.this,"登录失败:"+e.getMessage(),Toast.LENGTH_LONG).show();;
                }
            }
        });
    }
    private void Register(){
        startActivity(new Intent(BaseUI.this,Register.class));
    }
}
