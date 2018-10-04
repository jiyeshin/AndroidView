package com.example.a503_12.androidview;

import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ResourceUseAni1004 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_use_ani1004);

        //레이아웃에서 뷰 찾아오기
        final Button btnanimationstart = (Button)findViewById(R.id.btnanimationstart);
        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        btnanimationstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //애니메이션 가져오기
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

                //뷰에 애니메이션 적용
                imageView.startAnimation(animation);
            }
        });
    }
}
