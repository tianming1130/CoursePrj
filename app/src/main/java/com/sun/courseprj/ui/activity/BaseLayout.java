package com.sun.courseprj.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sun.courseprj.R;

public class BaseLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_linear);
        
//        LinearLayout ll = new LinearLayout(this);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        TextView tv=new TextView(this);
//        tv.setText("你好，16软工！");
//        ll.addView(tv,lp);
//        setContentView(ll);
    }
}
