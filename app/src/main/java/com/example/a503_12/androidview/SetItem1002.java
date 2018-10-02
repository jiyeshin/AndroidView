package com.example.a503_12.androidview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SetItem1002 extends AppCompatActivity {

    private Button multiselect;
    //선택 여부를 판단하기 위한 배열
    boolean[] selected = {false, false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_item1002);
        multiselect = (Button) findViewById(R.id.multiselect);
        multiselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SetItem1002.this).setTitle("한글놀이").setIcon(android.R.drawable.btn_star)
                        .setMultiChoiceItems(R.array.kralphabet, selected, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                selected[which] = isChecked;
                            }
                        }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //arrays.xml 파일에 만든 문자열 배열 가져오기
                        String[] kralphabet = getResources().getStringArray(R.array.kralphabet);

                        //선택 여부가 저장되어 있는 배열을 순회하면서 true일 때 kralphabet 의 데이터를 문자열에 추가
                        String result = "";
                        for (int i = 0; i < selected.length; i = i + 1) {
                            if (selected[i]) {
                                result = result + kralphabet[i] + "\t";
                            }
                        }
                        Toast.makeText(SetItem1002.this, result, Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("취소", null).show();
            }
        });
    }
}
