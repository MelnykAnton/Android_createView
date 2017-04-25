package com.melnykanton.dynamicaddview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup gravity_group;
    private EditText btn_name_text;
    private Button btn_create;
    private Button btn_clear;
    private LinearLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (LinearLayout) findViewById(R.id.layout_table);
        gravity_group = (RadioGroup) findViewById(R.id.Gravity_group);
        btn_name_text = (EditText) findViewById(R.id.editText);
        btn_create = (Button) findViewById(R.id.btn_create);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        btn_create.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_create:
                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
               int btn_Gravity = Gravity.LEFT;
                switch (gravity_group.getCheckedRadioButtonId()){
                    case R.id.rb_left:
                        btn_Gravity = Gravity.LEFT;
                        break;
                    case R.id.rb_center:
                        btn_Gravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rb_right:
                        btn_Gravity = Gravity.RIGHT;
                        break;
                }
                lparams.gravity = btn_Gravity;

                Button  btnNew = new Button(this);
                btnNew.setText(btn_name_text.getText().toString());
                table.addView(btnNew, lparams);
                break;
            case R.id.btn_clear:
                table.removeAllViews();
                Toast.makeText(MainActivity.this,"DELETE",Toast.LENGTH_SHORT).show();
        }
    }
}
