package com.example.marcos.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }


   /* Minhas alterações apartir deste ponto*/
    public void getActivity(View view) {
        Button bt = (Button) view;
        Intent intent = null;

        if (bt.getText().toString().equalsIgnoreCase("Novo Medicamento")) {
            intent = new Intent(this, NewMedicamentoActivity.class);
            startActivity(intent);


        } else if(bt.getText().toString().equalsIgnoreCase("Lista de Medicamentos")){
            intent = new Intent(this, ListMedicamentosActivity.class);
            startActivity(intent);


        } else if(bt.getText().toString().equalsIgnoreCase("Localizar")){
            intent = new Intent(this, PlacePickerActivity.class);
            startActivity(intent);


        }else if(bt.getText().toString().equalsIgnoreCase("Sair")){

            Intent intent1 = new Intent(Intent.ACTION_MAIN);
            intent1.addCategory(Intent.CATEGORY_HOME);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent1);
        }

        //startActivity(intent);
    }

}
