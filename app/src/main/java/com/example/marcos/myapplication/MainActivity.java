package com.example.marcos.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String CATEGORIA = "livro";
    private static final int segundos = 5;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView)findViewById(R.id.texto_text_view);
        text.setText("Alarme agendado para daqui a "+segundos+" segundos.");
        //5 segundos
        agendar(5);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    //agenda pra daqui a X segundos
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

    public void clickButtonListar(View view) {
        Intent getNameScreenIntent = new Intent(this,ListActivity.class);
        final int result = 1;
        getNameScreenIntent.putExtra("callingActivity","MainActivity");
        startActivityForResult(getNameScreenIntent,result);
    }


   /* Minhas alterações apartir deste ponto*/
    public void getActivity(View view) {
        Button bt = (Button) view;
        Intent intent;

        if (bt.getText().toString().equalsIgnoreCase("Novo Medicamento")) {
            intent = new Intent(this, NewMedicamentoActivity.class);
        } else {
            intent = new Intent(this, ListMedicamentosActivity.class);
        }

        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://controlador/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://controlador/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
