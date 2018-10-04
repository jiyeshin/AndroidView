package com.example.a503_12.androidview;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Timer1004 extends AppCompatActivity {

    String [] textar = {"안드로이드", "드로이드안", "로이드안드", "이드안드로", "드안드로이드"};

    CountDownTimer timer;

    //버튼을 눌렀을 때 호출될 메소드: activity_timer1004.xml 파일에서 설정
    public void click(View v){
        timer.start();
        /*
        TextView txt = (TextView)findViewById(R.id.txt);
        try{
            for(int i=0;i<textar.length; i=i+1){
                txt.setText(textar[i%5]);
                Thread.sleep(1000);
            }
        }catch (Exception e){}
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer1004);


        timer = new CountDownTimer(10000,1000) {
            TextView txt = (TextView)findViewById(R.id.txt);
            int idx =0;

            //주기적으로 호출되는 메소드
            @Override
            public void onTick(long millisUntilFinished) {
                txt.setText(textar[idx%5]);
                idx=idx+1;
            }

            @Override
            public void onFinish() {
                txt.setText("타이머 종료");
            }
        };
    }
}
