package com.example.marcos.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class Repeating_activity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent = getIntent();

        TextView textNome = (TextView)findViewById(R.id.textViewNome);
        TextView textDose = (TextView)findViewById(R.id.textViewDose);
        TextView textDosagem = (TextView)findViewById(R.id.textViewDosagem);


        textNome.setText("Medicamento: "+intent.getExtras().getString("nomemedicamento")+" !");
        textDose.setText("Tipo dose: "+intent.getExtras().getString("tipodosemedicamento")+" !");
        textDosagem.setText("Quantidade: "+intent.getExtras().getString("dosemedicamento")+" !");

    }

    public void onClickTomei(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void onClickDepois(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
