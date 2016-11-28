package com.example.marcos.myapplication;


import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;

/**
 * Created by Pantufa on 27/10/2016.
 */
public class ListMedicamentosActivity extends ListActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_medicamento); // Qualquer coisa remover

        BD db = new BD(this);

        List<Medicamento> list = db.buscarMedicamento();
        setListAdapter(new MedicamentoAdapter(this, list));
    }
    /*
    public void onClickVoltar(View view) {
        Intent intent=new Intent(this,ListMedicamentosActivity.class);
        startActivity(intent);
    }
    */
}
