package com.sun.courseprj.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sun.courseprj.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnBaseLayout,btnBaseUI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBaseLayout=(Button)findViewById(R.id.base_layout);
        btnBaseUI=(Button)findViewById(R.id.base_ui);

        btnBaseLayout.setOnClickListener(this);
        btnBaseUI.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.base_layout:
                startActivity(new Intent(MainActivity.this,BaseLayout.class));
                break;
            case R.id.base_ui:
                startActivity(new Intent(MainActivity.this,BaseUI.class));
                break;
        }
    }
}
