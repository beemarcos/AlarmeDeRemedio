package com.example.marcos.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pantufa on 18/10/2016.
 */
public class BD  {
    private SQLiteDatabase db;
    /* Classe de Banco de dadosh hh*/

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        db = auxBd.getWritableDatabase();
    }

    public void inserirMedicamento(Medicamento medicamento){
        ContentValues valores = new ContentValues();
        valores.put("nome", medicamento.getNome());
        valores.put("tipo_dosagem", medicamento.getTipo_dosagem());
        valores.put("tempo_tratamento", medicamento.getTempo_tratamento());
        valores.put("dose", medicamento.getDose());
        valores.put("intervalo", medicamento.getIntervalo());
        valores.put("quantidade", medicamento.getQuantidade());

        db.insert("medicamento", null, valores);
    }

    public void atualizarMedicamento(Medicamento medicamento){
        ContentValues valores = new ContentValues();
        valores.put("nome", medicamento.getNome());
        valores.put("tipo_dosagem", medicamento.getTipo_dosagem());
        valores.put("tempo_tratamento", medicamento.getTempo_tratamento());
        valores.put("dose", medicamento.getDose());
        valores.put("intervalo", medicamento.getIntervalo());
        valores.put("quantidade", medicamento.getQuantidade());

        db.update("medicamento", valores, "_id = ?", new String[]{""+medicamento.getId()});
    }

    public void deletarMedicamento(Medicamento medicamento){
        db.delete("medicamento", "_id = "+medicamento.getId(), null);
    }

    public Medicamento pesquisarMedicamento(String nome){

        String[] colunas = new String[]{"_id", "nome", "tipo_dosagem", "tempo_tratamento", "dose","intervalo", "quantidade"};
        Cursor cursor = db.query("medicamento", colunas, null, null, null, null, "nome");
        Medicamento m = new Medicamento();

        if(cursor.getCount() > 0){
            do {
                m.setId(cursor.getLong(0));
                m.setNome(cursor.getString(1));
                m.setTipo_dosagem(cursor.getString(2));
                m.setTempo_tratamento(cursor.getString(3));
                m.setDose(cursor.getInt(4));
                m.setIntervalo(cursor.getInt(5));
                m.setQuantidade(cursor.getInt(6));
            }while(cursor.moveToNext());
        }

        return m;
    }

    public List<Medicamento> buscarMedicamento(){
        List<Medicamento> list = new ArrayList<Medicamento>();
        String[] colunas = new String[]{"_id", "nome", "tipo_dosagem", "tempo_tratamento", "dose","intervalo", "quantidade"};

        Cursor cursor = db.query("medicamento", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                Medicamento m = new Medicamento();
                m.setId(cursor.getLong(0));
                m.setNome(cursor.getString(1));
                m.setTipo_dosagem(cursor.getString(2));
                m.setTempo_tratamento(cursor.getString(3));
                m.setDose(cursor.getInt(4));
                m.setIntervalo(cursor.getInt(5));
                m.setQuantidade(cursor.getInt(6));
                list.add(m);
            }while(cursor.moveToNext());
        }

        return (list);
    }

}
