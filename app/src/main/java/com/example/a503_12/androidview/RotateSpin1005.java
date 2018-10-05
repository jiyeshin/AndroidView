package com.example.a503_12.androidview;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class RotateSpin1005 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_spin1005);
    }

    //기기의 방향이나 키보드가 숨는 등의 환경이 변경될 때 호출되는 메소드
    @Override
    public void onConfigurationChanged(
            Configuration newConfig) {
        setContentView(R.layout.activity_rotate_spin1005);

        super.onConfigurationChanged(newConfig);
    }
}
