package com.example.a503_12.androidview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class DialogPopup1002 extends AppCompatActivity {

    private EditText editid, editpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_popup1002);
        Button customdialog = (Button) findViewById(R.id.customdialog);


        customdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //레이아웃 파일의 내용 불러오기
                //Anonymous 클래스에서 사용하기 위해 final 변수로 만들어 줌.
                final LinearLayout login = (LinearLayout) View.inflate(DialogPopup1002.this, R.layout.login1002, null);
                new AlertDialog.Builder(DialogPopup1002.this).setIcon(android.R.drawable.sym_def_app_icon)
                        .setTitle("로그인")
                        .setView(login)
                        .setNegativeButton("취소", null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editid = (EditText) login.findViewById(R.id.editid);
                                editpw = (EditText) login.findViewById(R.id.editpw);
                                String result = "id: " + editid.getText().toString() + "\t\t" + "pw: " + editpw.getText().toString();
                                Toast.makeText(DialogPopup1002.this, result, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        //popup1002.xml 내용을 가지는 뷰를 생성
        final LinearLayout popup = (LinearLayout) View.inflate(DialogPopup1002.this, R.layout.popup1002, null);
        final Button popupwindow = (Button) findViewById(R.id.popupwindow);

        popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //팝업 윈도우
                final PopupWindow popupwin = new PopupWindow(popup, 300, 300, true);

                //화면 출력: 첫번째 매개변수는 기준뷰, 두번째와 세번쨰는 좌표, 네번쨰는 포커스 여부
                popupwin.showAtLocation(popupwindow, Gravity.CENTER, 200, 300);

                Button close = (Button) popup.findViewById(R.id.btnclose);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupwin.dismiss();
                    }
                });

            }
        });


    }
}
