package com.example.a503_12.androidview;

import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ThreeButtonViewChange extends AppCompatActivity {
    private Button btn1, btn2, btn3, btntoast, btnbasicalert, btnsync;
    private LinearLayout page1, page2, page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_button_view_change);

        //layout에 만든 뷰 찾아오기
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        page1 = (LinearLayout)findViewById(R.id.page1);
        page2 = (LinearLayout)findViewById(R.id.page2);
        page3 = (LinearLayout)findViewById(R.id.page3);

        //btn1을 클릭했을 때 처리
        btn1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.VISIBLE);
                page2.setVisibility(View.INVISIBLE);
                page3.setVisibility(View.INVISIBLE);
            }
        });

        //btn2을 클릭했을 때 처리
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.VISIBLE);
                page3.setVisibility(View.INVISIBLE);
            }
        });

        //btn3을 클릭했을 때 처리
        btn3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.INVISIBLE);
                page3.setVisibility(View.VISIBLE);
            }
        });

        //btntoast을 클릭했을 때 처리
        btntoast = (Button)findViewById(R.id.btntoast);
        btntoast.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ThreeButtonViewChange.this, "안녕하세요 토스트입니다", Toast.LENGTH_LONG).show();
            }
        });

        //btnbasicalert을 클릭했을 때 처리
        btnbasicalert = (Button)findViewById(R.id.btnbasicalert);
        btnbasicalert.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //메소드 채이닝을 이용한 생성과 출력
                new AlertDialog.Builder(ThreeButtonViewChange.this).setMessage("기본 대화상자").setTitle("대화상자").setIcon(R.drawable.star).setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ThreeButtonViewChange.this, "긍정을 눌렀습니다.", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("진동", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                        vib.vibrate(3000);
                    }
                }).setNeutralButton("사운드", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri system = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), system);
                        ringtone.play();
                    }
                }).setCancelable(false).show();
            }
        });

        //btnsync을 클릭했을 때 처리
        btnsync = (Button)findViewById(R.id.btnsync);
        //new View.OnClickListener()로 써도 됨. 어차피 Button이 View로부터 상속 받기 때문.
        btnsync.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //대화상자 출력
                new AlertDialog.Builder(ThreeButtonViewChange.this).setMessage("액티비티 종료").setTitle("대화상자").setIcon(R.drawable.star).setPositiveButton("프로그램 종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();

                //토스트 출력
                Toast.makeText(ThreeButtonViewChange.this,"토스트 출력",Toast.LENGTH_LONG).show();

                //액티비티 종료
                //finish();
            }
        });
    }
}
