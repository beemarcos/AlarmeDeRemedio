package com.example.marcos.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Marcos on 10/16/2016.
 */
public class DBManager {
    private static DBHelper dbhelper = null;

    public DBManager(Context context){
        if(dbhelper==null){
            dbhelper = new DBHelper(context);
        }

    }
    //funcao que add item
    public void addItem(String nome){
        String sql = "INSERT INTO itens(nome) VALUES('"+nome+"');";
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        db.execSQL(sql);
    }
    //funcao que lista todos os itens
    public ArrayList<String> getAllItens(){
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String sql = "SELECT nome FROM itens";
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<String> itens=null;
        if (cursor!=null && cursor.moveToFirst()){
            itens = new ArrayList<String>();
            do {
                itens.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        return itens;
    }

}
