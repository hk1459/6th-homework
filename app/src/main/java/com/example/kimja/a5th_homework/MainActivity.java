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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ArrayAdapter<String> adapter;
    ArrayList<String> data = new ArrayList<String>();
    ArrayList<information> saveddata = new ArrayList<information>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListview();
        tv = (TextView)findViewById(R.id.tv);
    }

    public void onClick(View v){ //두번째 메인액티비티 띄우기
        Intent intent = new Intent(this,Main2Activity.class);
        information s1 = new information();
        intent .putExtra("inputdata",s1);
        startActivityForResult(intent,0);

    }

    public void setListview(){
        listView = (ListView)findViewById(R.id.listview) ;

        //어댑터 만들기 (데이터와 화면을 연결)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {  //길게누를시 삭제
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("")
                        .setIcon(R.drawable.photo)
                        .setTitle("삭제확인")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("삭제", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "삭제되었습니다.",Toast.LENGTH_SHORT)
                                        .show();
                                        data.remove(position);
                                        saveddata.remove(position);
                                        adapter.notifyDataSetChanged();
                                tv.setText("맛집 리스트("+saveddata.size()+"개)");
                            }
                        })
                        .show();
                return true; // 다음이벤트 진행 X
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent .putExtra("saveddata",saveddata.get(position));
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            if(resultCode == RESULT_OK){  //
                information input = data.getParcelableExtra("remakemsg");
                this.saveddata.add(input);
                this.data.add(input.getName());
                adapter.notifyDataSetChanged();
                tv.setText("맛집 리스트("+saveddata.size()+"개)");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
