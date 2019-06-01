package com.example.bengi.myapplication;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;


import android.widget.Button;

public class Kart extends android.support.v7.widget.AppCompatButton {
    boolean acikmi = false;
    boolean cevrilebilir = true; //
    int resimid;
    int arkaplanid;
    Drawable arka;
    Drawable on;
    int onplanid = 0; //hata verdiği için ilk degerverdik ilk deger pek önemli değil çünkü alttaaki iflerden kesin birne düşücek

    public Kart(Context context, int id) {  //Böylece kart  buton özelliği taşıdı(yani tıklama özelliği)
        super(context);
        setId(id);  //önemli çünkü altta verdiğim idleri buttona set eder yani biz main activityde buton onclick yapınca ıd ye ulaşabiliriz bu sayede
        arkaplanid = R.drawable.ters;   //arkaplanıd ye resimin yerini atıyorum

        if(id%8==1)  //8 karttan 2 ser kere koyuyoruz.eşi olabilmesi için
            onplanid = R.drawable.yuz1;
        if(id%8==2)
            onplanid = R.drawable.yuz2;
        if(id%8==3)
            onplanid = R.drawable.yuz3;
        if(id%8==4)
            onplanid = R.drawable.yuz4;
        if(id%8==5)
            onplanid = R.drawable.yuz5;
        if(id%8==6)
            onplanid = R.drawable.yuz6;
        if(id%8==7)
            onplanid = R.drawable.yuz7;
        if(id%8==0)
            onplanid = R.drawable.yuz8;

        arka  = AppCompatDrawableManager.get().getDrawable(context,arkaplanid);//
        //kartın arka yüzünde bu resimin olmasını istediğimiz için setbackground dememiz
        //  yetiyo çünkü kartın setbackgroundı yani arkası oluyor direk
        on  = AppCompatDrawableManager.get().getDrawable(context,onplanid);
        setBackground(arka);
    }

    public void cevir(){
      if(cevrilebilir){ //eşleştiyse çevrilemez ondan bakmamız gerek
        if(!acikmi){ //false tanımladık basta bunu yani if değişken false ise girsin bu da açıkdeğilse yani arka yüzü açıksa demek
           setBackground(on); //önünü cevir
            acikmi =true;

        }
        else{
            setBackground(arka);
        acikmi = false;
       }
    //else kısmı bos yanı bişey yapma cevrilemiyorsa
}}
}
