package com.sun.courseprj.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.sun.courseprj.R;

public class Register extends AppCompatActivity implements CompoundButton
        .OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener ,AdapterView.OnItemSelectedListener{

    private CheckBox cbSwim, cbMusic, cbBook;
    private RadioGroup rgSex;
    private Button btnConfirm;
    private Spinner spnAcademic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init() {
        cbSwim = (CheckBox) findViewById(R.id.cb_swim);
        cbMusic = (CheckBox) findViewById(R.id.cb_music);
        cbBook = (CheckBox) findViewById(R.id.cb_book);
        rgSex = (RadioGroup) findViewById(R.id.rg_sex);
        spnAcademic = (Spinner) findViewById(R.id.spn_academic);
        btnConfirm = (Button) findViewById(R.id.btn_confirm);


        cbSwim.setOnCheckedChangeListener(this);
        cbMusic.setOnCheckedChangeListener(this);
        cbBook.setOnCheckedChangeListener(this);

        rgSex.setOnCheckedChangeListener(this);

        spnAcademic.setOnItemSelectedListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, buttonView.getText().toString() + ":" + String.valueOf(isChecked),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        Toast.makeText(this, ((RadioButton) findViewById(checkedId)).getText().toString(), Toast
                .LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String strHobby = "";
        if (cbBook.isChecked())
            strHobby += cbBook.getText().toString();
        if (cbMusic.isChecked())
            strHobby += cbMusic.getText().toString();
        if (cbSwim.isChecked())
            strHobby += cbSwim.getText().toString();

        String strSex = ((RadioButton) findViewById(rgSex.getCheckedRadioButtonId())).getText()
                .toString();

        String strAcademicSelected=spnAcademic.getSelectedItem().toString();

        Toast.makeText(this, "爱好：" + strHobby + "\n" + "性别:" + strSex+"\n"+"学历:"+strAcademicSelected, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] academicItem=getResources().getStringArray(R.array.academic);
        Toast.makeText(this,academicItem[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
