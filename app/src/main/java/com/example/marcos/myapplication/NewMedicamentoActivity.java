package com.example.marcos.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by Pantufa on 22/10/2016.
 */
public class NewMedicamentoActivity extends Activity {
    private Medicamento medicamento = new Medicamento();
    private EditText nomeEt;
    private EditText tipo_dosagemEt;
    private EditText tempo_tratamentoEt;
    private EditText doseEt;
    private EditText intervaloEt;
    private EditText quantidadeEt;
    private Button salvarBt;
    private Button editarBt;
    private Button voltarMainBt;
    private Button voltarListBt;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_medicamento);

        nomeEt = (EditText) findViewById(R.id.nome);
        tipo_dosagemEt = (EditText) findViewById(R.id.tipo_dosagem);
        tempo_tratamentoEt = (EditText) findViewById(R.id.tempo_tratamento);
        doseEt = (EditText) findViewById(R.id.dose);
        intervaloEt = (EditText) findViewById(R.id.intervalo);
        quantidadeEt = (EditText) findViewById(R.id.quantidade);

        salvarBt = (Button) findViewById(R.id.button1);
        editarBt = (Button) findViewById(R.id.button2);
        voltarListBt = (Button) findViewById(R.id.button4);
        voltarMainBt = (Button) findViewById(R.id.button3);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                medicamento.setId(bundle.getLong("id"));
                medicamento.setNome(bundle.getString("nome"));
                medicamento.setTipo_dosagem(bundle.getString("tipo_dosagem"));
                medicamento.setTempo_tratamento(bundle.getString("tempo_tratamento"));
                medicamento.setDose(bundle.getInt("dose"));
                medicamento.setIntervalo(bundle.getInt("intervalo"));
                medicamento.setQuantidade(bundle.getInt("quantidade"));

                nomeEt.setText(medicamento.getNome());
                tipo_dosagemEt.setText(medicamento.getTipo_dosagem());
                tempo_tratamentoEt.setText(medicamento.getTempo_tratamento());
                doseEt.setText(Integer.toString(medicamento.getDose()));
                intervaloEt.setText(Integer.toString(medicamento.getIntervalo()));
                quantidadeEt.setText(Integer.toString(medicamento.getQuantidade()));


                salvarBt.setVisibility(View.GONE);
                editarBt.setVisibility(View.VISIBLE);
                voltarListBt.setVisibility(View.VISIBLE);
            }
        }

        }

    public void voltarMain(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void voltarLista(View view){
        Intent intent=new Intent(this,ListMedicamentosActivity.class);
        startActivity(intent);

    }

    public void salvarMedicamento(View view){
        medicamento.setNome(nomeEt.getText().toString());
        medicamento.setTipo_dosagem(tipo_dosagemEt.getText().toString());
        medicamento.setTempo_tratamento(tempo_tratamentoEt.getText().toString());
        medicamento.setDose(Integer.parseInt(doseEt.getText().toString()));
        medicamento.setIntervalo(Integer.parseInt(intervaloEt.getText().toString()));
        medicamento.setQuantidade(Integer.parseInt(quantidadeEt.getText().toString()));

        BD bd = new BD(this);
        bd.inserirMedicamento(medicamento);

        Toast.makeText(this, "Medicamento inserido com sucesso!", Toast.LENGTH_SHORT).show();

        // alteracoes do marcos
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE,00);
        //calendar.set(Calendar.SECOND,00);

        Intent intent = new Intent(getApplicationContext(),ReceberAlarme.class);
        intent.putExtra("nomemedicamento",medicamento.getNome());
        intent.putExtra("tipodosemedicamento",medicamento.getTipo_dosagem());
        intent.putExtra("tempomedicamento",medicamento.getTempo_tratamento());
        intent.putExtra("dosemedicamento",String.valueOf(medicamento.getDose()));
        intent.putExtra("quantidademedicamento",String.valueOf(medicamento.getQuantidade()));

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),1000*60*60*medicamento.getIntervalo(),pendingIntent);



        //voltando a main
        Intent intent2=new Intent(this,MainActivity.class);
        startActivity(intent2);

    }


    public void editarMedicamento(View view){
        medicamento.setNome(nomeEt.getText().toString());
        medicamento.setTipo_dosagem(tipo_dosagemEt.getText().toString());
        medicamento.setTempo_tratamento(tempo_tratamentoEt.getText().toString());
        medicamento.setDose(Integer.parseInt(doseEt.getText().toString()));
        medicamento.setIntervalo(Integer.parseInt(intervaloEt.getText().toString()));
        medicamento.setQuantidade(Integer.parseInt(quantidadeEt.getText().toString()));

        BD bd = new BD(this);
        bd.atualizarMedicamento(medicamento);

        Toast.makeText(this, "Medicamento \""+medicamento.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,ListMedicamentosActivity.class);
        startActivity(intent);


    }
    }

