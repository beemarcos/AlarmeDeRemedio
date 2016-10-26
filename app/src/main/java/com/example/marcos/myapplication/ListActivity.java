package com.example.marcos.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Marcos on 10/15/2016.
 */
public class ListActivity extends Activity{

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        //////////////////////  INTENT DE VOLTA  /////////////////////////////////////////////////
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        TextView callingActivityMessage = (TextView)findViewById(R.id.text_view_quem_chamou);
        callingActivityMessage.append(" "+previousActivity);
        //////////////////////  LISTA  ///////////////////////////////////////////////////////////
        String[] drogas = new String[]{"Heroína","Cocaina","Crack","Anfetamina","Lsd","Maconha","Ecstasy"};
        listView = (ListView)findViewById(R.id.list_drogas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,drogas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_Position = position;
                String itemValue = (String)listView.getItemAtPosition(position);
                //mostra um alerta por enquanto
                Toast.makeText(getApplicationContext(),"Position: "+position+" List Item:"+itemValue,Toast.LENGTH_LONG).show();

            }
        });


    }

    public void voltatButton(View view) {
        Intent goingBack = new Intent();
        String voltaqualqecoisa = ";)";
        goingBack.putExtra("chaveDeNada",voltaqualqecoisa);
        setResult(RESULT_OK,goingBack);
        finish();
    }

    public void listaBanco(View view) {
        ////////Banco de dados//////
        ArrayList<String> itens = null;
        DBManager dbManager = new DBManager(this);
        for (int i=0;i<10;i++)
            dbManager.addItem("Item numero "+i);//preenche a lista com os valores

        itens = dbManager.getAllItens();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        ListView listView = (ListView)findViewById(R.id.list_database);
        listView.setAdapter(adapter);
    }
}
