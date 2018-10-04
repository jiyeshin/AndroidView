package com.example.a503_12.androidview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ResourceUseTheme1004 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_use_theme1004);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);

        //애니메이션 찾아오기
        Animation ani1 = AnimationUtils.loadAnimation(ResourceUseTheme1004.this, R.anim.in);


        //애니메이션의 리스너 설정
        ani1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation ani2 = AnimationUtils.loadAnimation(ResourceUseTheme1004.this, R.anim.move);
                ani2.setFillAfter(true);
                imageView.startAnimation(ani2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(ani1);
    }
}
