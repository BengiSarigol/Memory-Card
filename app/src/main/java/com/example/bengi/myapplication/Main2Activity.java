package com.example.bengi.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
int sonkart = 0;  //çevirilen son kartı tutar eger çevrilmediyse zaten 0dır bunu kontrol ederek2 sayacı yaparız
int skor =0;
int hata =0;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
       final String s = i.getStringExtra("mesaj");
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText(s);
        GridLayout gl = (GridLayout) findViewById(R.id.grid);
        Kart kartlar[] = new Kart[16];
        for(int j=1 ; j<=16; j++ ) { //16 buton olucak hepsini ekliycek eklerken de  numara veriyo j ile j idsi yani buton kendi idsini bilicek yani
            kartlar[j-1] = new Kart(this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {  //her buton için listener tanımlıyorum.
                @Override
                //herhangi şekilde butona tuıklarsam cevire gidicek
                public void onClick(View v) {
                final    Kart k = (Kart) v; //kart buttondu yani buttonlar view zaten buradada da bu viewi karta çeviriyorum
                    k.cevir();
                    //aşagıdaki if blogu ilede eşleşen2 karta bakılır
                    if(sonkart > 0){ //mantık şöyle eşleşenler kapanmıycak eşleşmediyse geri çevrilicek
                       final Kart k2 =(Kart) findViewById(sonkart);

                        if (k2.onplanid == k.onplanid && k2.getId() != k.getId()){//eşleştiler //onplandaki resimler aynı olsun yani resimid
                            //veee bu butonlar aynı olmamalı yanı farklı buton olmalılar buton idler eşit olmmamlı
                            k2.cevrilebilir = false;
                            k.cevrilebilir =false;
                             skor++;
                             TextView tv = (TextView) findViewById(R.id.textView);
                             tv.setText("skorunuzz" + skor);
                             if (skor == 8){
                                 //oyun bitti
                                 Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                                 i.putExtra("puan",hata);
                                 i.putExtra("isim",s); //içten erişebilmek için final olmalı s
                                 startActivity(i);

                             }

                        }

                        else { //eşleşmediler geri çevir
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();
                                }
                            },500);  //500ms lık bir delay yani erteleme ile geri çevrilsinler
                            hata++;

                            TextView t = (TextView) findViewById(R.id.textView3);
                            t.setText("Hata sayısı" +hata);
                            sonkart =0;

                        }

                    }

                    else{
                        sonkart = k.getId();
                    }

                }
            });


        }
            for(int j=0 ; j<16 ;j++) {
            int random = (int)(Math.random()*16);
             Kart k = kartlar[random];
             kartlar[random]= kartlar[j];
             kartlar[j] = k;
            }
            for(int j=0 ; j<16; j++ ) {
           gl.addView(kartlar[j]);

        }

    }
}
