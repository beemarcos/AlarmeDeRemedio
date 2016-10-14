package com.example.marcos.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String CATEGORIA = "livro";
    private static final int segundos = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("Alarme agendado para daqui a "+segundos+" segundos.");
        setContentView(text);
        //5 segundos
        agendar(5);
    }



    //agenda pra daqui a X segundos teste de commit hehe
    private void agendar(int segundos) {
        //Itent para disparar o Broadcast
        Intent  it= new Intent("EXECUTAR_ALARME");
        PendingIntent p = PendingIntent.getBroadcast(MainActivity.this,0,it,0);
        //para executar o alarme depois de x segundos a partir de agora
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND,segundos);
        //Agenda o alarme
        AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
        long time = c.getTimeInMillis();
        alarme.set(AlarmManager.RTC_WAKEUP,time,p);
        Log.i(CATEGORIA,"Alarme agendado para daqui "+segundos+" segundos.");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(CATEGORIA,"onDestroy() - alarme cancelado.");
        Intent it = new Intent("EXECUTAR_ALARME");
        PendingIntent p = PendingIntent.getBroadcast(MainActivity.this,0,it,0);
        //cancela o alarme
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(p);
    }
}
