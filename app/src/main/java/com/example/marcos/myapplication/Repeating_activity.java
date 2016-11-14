package com.example.marcos.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Repeating_activity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Bundle extras = getIntent().getExtras();

        Intent intent = getIntent();

        TextView text = (TextView)findViewById(R.id.textViewNome);
        text.setText("Medicamento: "+intent.getExtras().getString("nomemedicamento")+" !");

    }

}
