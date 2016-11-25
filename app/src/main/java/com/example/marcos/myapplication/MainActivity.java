package com.example.marcos.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


   /* Minhas alterações apartir deste ponto*/
    public void getActivity(View view) {
        Button bt = (Button) view;
        Intent intent = null;

        if (bt.getText().toString().equalsIgnoreCase("Novo Medicamento")) {
            intent = new Intent(this, NewMedicamentoActivity.class);
        } else if(bt.getText().toString().equalsIgnoreCase("Lista de Medicamentos")){
            intent = new Intent(this, ListMedicamentosActivity.class);
        } else if(bt.getText().toString().equalsIgnoreCase("Localizar")){
            intent = new Intent(this, PlacePickerActivity.class);
        }

        startActivity(intent);
    }


}
