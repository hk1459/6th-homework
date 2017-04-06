package com.example.kimja.a5th_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText etname,ettel,etmenu1,etmenu2,etmenu3,etaddr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        init();
    }
    void init(){
        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etmenu1 = (EditText)findViewById(R.id.etmenu1);
        etmenu2 = (EditText)findViewById(R.id.etmenu2);
        etmenu3 = (EditText)findViewById(R.id.etmenu3);
        etaddr = (EditText)findViewById(R.id.etaddr);

    }
    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){ //객체 저장 및 객체 전달
            information information = new information();

        } else if ( v.getId() == R.id.btnCancel){ //에딧텍스트 초기화 및 액티비티 돌아가기
            etname.setText("");
            ettel.setText("");
            etmenu1.setText("");
            etmenu2.setText("");
            etmenu3.setText("");
            etaddr.setText("");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}
