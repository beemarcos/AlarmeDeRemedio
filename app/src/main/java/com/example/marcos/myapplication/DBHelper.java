package com.example.marcos.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Marcos on 10/16/2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static String DB_NAME = "BancoDeDroga";
    private static int DV_VERSION= 1;
    private static String TABLE_ITENS = "CREATE TABLE itens("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nome TEXT"+
            ");";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DV_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_ITENS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
