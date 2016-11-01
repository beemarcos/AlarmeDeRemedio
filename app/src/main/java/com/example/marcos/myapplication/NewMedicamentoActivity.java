package com.example.marcos.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_medicamento);

        nomeEt = (EditText) findViewById(R.id.nome);
        tipo_dosagemEt = (EditText) findViewById(R.id.tipo_dosagem);
        tempo_tratamentoEt = (EditText) findViewById(R.id.tempo_tratamento);
        doseEt = (EditText) findViewById(R.id.dose);
        intervaloEt = (EditText) findViewById(R.id.intervalo);
        quantidadeEt = (EditText) findViewById(R.id.quantidade);

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
                //doseEt.setText(Integer.parseInt(String.valueOf(medicamento.getDose())));
                //intervaloEt.setText(Integer.parseInt(String.valueOf(medicamento.getIntervalo())));
                //quantidadeEt.setText(Integer.parseInt(String.valueOf(medicamento.getQuantidade())));

                //senhaEt.setVisibility(View.GONE);
                //salvarBt.setVisibility(View.GONE);
                editarBt.setVisibility(View.VISIBLE);
            }
        }

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
    }


    public void editarMedicamento(View view){
        medicamento.setNome(nomeEt.getText().toString());
        medicamento.setTipo_dosagem(tipo_dosagemEt.getText().toString());
        medicamento.setTempo_tratamento(tempo_tratamentoEt.getText().toString());
       // medicamento.setDose(Integer.parseInt(doseEt.getText().toString()));
        //medicamento.setIntervalo(Integer.parseInt(intervaloEt.getText().toString()));
        //medicamento.setQuantidade(Integer.parseInt(quantidadeEt.getText().toString()));

        BD bd = new BD(this);
        bd.atualizarMedicamento(medicamento);

        Toast.makeText(this, "Medicamento \""+medicamento.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }
    }

