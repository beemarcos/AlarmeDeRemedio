package com.example.marcos.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ReceberAlarme extends BroadcastReceiver{
    private static final String CATEGORIA = "livro";
    @Override
    public void onReceive(Context context, Intent intent){
        Log.i(CATEGORIA,"Alarme Disparado!");
        //podemos iniciar uma activity, servico ou exibir uma notificacao ao usuario aqui
        Toast.makeText(context,"Alarme Disparado!",Toast.LENGTH_SHORT).show();
    }
}
