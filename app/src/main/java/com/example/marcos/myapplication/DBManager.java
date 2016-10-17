package com.example.marcos.myapplication;

import android.content.Context;

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
}
