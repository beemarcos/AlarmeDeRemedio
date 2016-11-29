package com.example.marcos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pantufa on 22/10/2016.
 */
public class MedicamentoAdapter extends BaseAdapter {
    private Context context;
    private List<Medicamento> list;

    public MedicamentoAdapter (Context context, List<Medicamento> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }


    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.medicamento, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome);
        tv.setText(list.get(position).getNome());

        Button editarBt = (Button) layout.findViewById(R.id.editar);
        editarBt.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View arg0) {
                Intent intent = new Intent(context, NewMedicamentoActivity.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("tipo_dosagem", list.get(auxPosition).getTipo_dosagem());
                intent.putExtra("tempo_tratamento", list.get(auxPosition).getTempo_tratamento());
                intent.putExtra("dose", list.get(auxPosition).getDose());
                intent.putExtra("intervalo", list.get(auxPosition).getIntervalo());
                intent.putExtra("quantidade", list.get(auxPosition).getQuantidade());
                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View arg0) {
                //Intent intent = new Intent(context, ListMedicamentosActivity.class);
                BD bd = new BD(context);
                bd.deletarMedicamento(list.get(auxPosition));
                layout.setVisibility(View.GONE);
               // context.startActivity(intent);
            }
        });

        return layout;
    }
}
