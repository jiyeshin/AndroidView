package com.example.a503_12.androidview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventRouting1004 extends AppCompatActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        String message = String.format("x:%f y:%f 터치", x, y);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event); //추상 메소드가 아니면 오버라이딩 할 때 상위 클래스를 불러야 함.
        // 왜냐하면 내 기능 + 상위 클래스 기능 모두 사용하기 위해
        //참고로 onClick 메소드가 추상메소드임.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_routing1004);

        //버튼 찾아오는 코드
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
/*
        //버튼의 클릭: View.onClickListener
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //매개변수 View v는 이벤트가 발생한 객체의 주소. 여기서는 btn1. 다른 것은 자료형
                Toast.makeText(EventRouting1004.this, "버튼1을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                //context:EventRouting1004.this 가 아닌 this를 쓰면 View.OnclickListener 를 가리킨다.
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(EventRouting1004.this, "버튼2를 눌렀습닛다.", Toast.LENGTH_SHORT).show();
            }
        });
        */


        View.OnClickListener eventHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                String msg = "";
                if (btn == btn1) {
                    msg = "첫번째 버튼 클릭";
                } else if (btn == btn2) {
                    msg = "두번째 버튼 클릭";
                }
                Toast.makeText(EventRouting1004.this, msg, Toast.LENGTH_SHORT).show();

            }
        };

        //이벤트 처리 객체 연결
        btn1.setOnClickListener(eventHandler);
        btn2.setOnClickListener(eventHandler);
    }



}
