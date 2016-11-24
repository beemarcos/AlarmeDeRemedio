package com.example.marcos.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ReceberAlarme extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        NotificationManager notificationManager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeating_intent = new Intent(context,Repeating_activity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //pegando de uma intent e colocando em outra, com a mesma chave
        repeating_intent.putExtra("nomemedicamento",intent.getExtras().getString("nomemedicamento"));
        //repeating_intent.putExtra("dosemedicamento",intent.getExtras().getString("dosemedicamento"));


        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentTitle("Hora Do Remedio.")
                .setContentText("Medicamento "+intent.getExtras().getString("nomemedicamento")+" !")
                .setAutoCancel(true);
        notificationManager.notify(100,builder.build());


    }
}
