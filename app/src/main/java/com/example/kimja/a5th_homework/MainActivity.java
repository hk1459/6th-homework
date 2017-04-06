package com.example.kimja.a5th_homework;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    final ArrayList<String> data = new ArrayList<String>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setListview();
    }

    public void onClick(View v){ //두번째 메인액티비티 띄우기
        Intent intent = new Intent(this,Main2Activity.class); //객체 전달?
        information info = new information();
        intent.putExtra("info",info);
        startActivityForResult(intent,0);
    }

    public void setListview(){
        listView = (ListView)findViewById(R.id.listview) ;

        data.add("asdf"); //예제데이터
        //어댑터 만들기 (데이터와 화면을 연결)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {  //길게누를시 삭제
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("")  //일반적인 대화상자
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("삭제", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "삭제되었습니다.",Toast.LENGTH_SHORT)
                                        .show();
                                        data.remove(position);
                                        adapter.notifyDataSetChanged();
                            }
                        })
                        .show();
                return false;
            }
        });
    }
}
