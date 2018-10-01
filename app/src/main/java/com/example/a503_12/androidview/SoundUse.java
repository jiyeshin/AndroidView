package com.example.a503_12.androidview;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundUse extends AppCompatActivity {

    private Button btnvibrate, btnusersound, btnsystemsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_use);

        //버튼 찾아오기
        btnvibrate = (Button) findViewById(R.id.btnvibrate);
        btnusersound = (Button) findViewById(R.id.btnusersound);
        btnsystemsound = (Button) findViewById(R.id.btnsystemsound);

        btnvibrate.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //진동 만들기 - 1초 동안 진동
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(1000);
            }
        });
        btnsystemsound.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri system = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), system);
                ringtone.play();
            }
        });
        btnusersound.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(SoundUse.this, R.raw.pong);
                player.start();
            }
        });
    }
}