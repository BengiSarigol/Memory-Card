package com.example.bengi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tv = (TextView) findViewById(R.id.textView4);
        Intent i = getIntent();
        String isim =  i.getStringExtra("isim");  //aynı olmalılar main2 deki kısımla
        int skor = i.getIntExtra("puan",0);
        tv.setText("Tebrikler" +isim+ "\n" +skor+ "hata ile kazandınız" );

    }
}
