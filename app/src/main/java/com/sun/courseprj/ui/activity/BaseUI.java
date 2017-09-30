package com.sun.courseprj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sun.courseprj.R;

public class BaseUI extends AppCompatActivity implements View.OnClickListener{

    private EditText etUserName,etPassword;
    private Button btnLogin,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_ui);

        etUserName=(EditText)findViewById(R.id.et_user_name);
        etPassword=(EditText)findViewById(R.id.et_password);

        btnLogin=(Button)findViewById(R.id.btn_login);
        btnCancel=(Button)findViewById(R.id.btn_cancel);

        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

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
        }
    }
    private void login(){
        String strUserName=etUserName.getText().toString();
        String strPassword=etPassword.getText().toString();
        if (strUserName.equals("abc") && strPassword.equals("123456")){
            Toast.makeText(this,"登录成功！",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_LONG).show();
        }
    }
}
