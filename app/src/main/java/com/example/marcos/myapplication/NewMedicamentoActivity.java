package com.example.marcos.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;


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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_medicamento);

        nomeEt = (EditText) findViewById(R.id.nome);
        tipo_dosagemEt = (EditText) findViewById(R.id.tipo_dosagem);
        tempo_tratamentoEt = (EditText) findViewById(R.id.tempo_tratamento);
        doseEt = (EditText) findViewById(R.id.dose);
        intervaloEt = (EditText) findViewById(R.id.intervalo);
        quantidadeEt = (EditText) findViewById(R.id.quantidade);
        }
    }

