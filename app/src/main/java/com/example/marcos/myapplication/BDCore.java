package com.example.marcos.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pantufa on 18/10/2016.
 */
public class BDCore extends SQLiteOpenHelper{
    private static final String NOME_DB = "medicamento";
    private static final int VERSAO_DB = 1;

    public BDCore(Context ctx){

        super(ctx, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table medicamento(_id integer primary key autoincrement, nome text not null, tipo_dosagem text not null, tempo_tratamento text not null, " +
                "dose integer not null, intervalo integer not null, quantidade integer not null);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("drop table medicamento;");
        onCreate(db);
    }
}
