package com.example.a503_12.androidview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Practice1001 extends AppCompatActivity {
private TextView tv, page2;
private EditText et;
private Button btnnextpage, btntoast, btnalert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice1001);

        tv = (TextView)findViewById(R.id.tv);
        et = (EditText)findViewById(R.id.et);
        page2 = (TextView)findViewById(R.id.page2);

        tv.setVisibility(View.VISIBLE);
        et.setVisibility(View.VISIBLE);
        page2.setVisibility(View.INVISIBLE);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv.setText(et.getText());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //xml파일에 만든 뷰를 가져오기
        TextView textview = (TextView)findViewById(R.id.tv);
        String msg = textview.getText().toString();

        btnalert = (Button)findViewById(R.id.btnalert);
        btnalert.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(Practice1001.this, "토스트입니다.", Toast.LENGTH_LONG).show();
            }
        });

        btnalert = (Button)findViewById(R.id.btnalert);
        btnalert.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Practice1001.this).setMessage("대화상자입니다.").setTitle("알").setPositiveButton("종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
            }
        });

        btnnextpage = (Button)findViewById(R.id.btnnextpage);


        btnnextpage.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                page2.setVisibility(View.VISIBLE);
                tv.setVisibility(View.INVISIBLE);
                et.setVisibility(View.INVISIBLE);
            }
        });
    }
}
