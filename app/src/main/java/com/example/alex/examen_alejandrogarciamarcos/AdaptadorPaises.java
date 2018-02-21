package com.example.alex.examen_alejandrogarciamarcos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Alex on 21/02/2018.
 */

public class AdaptadorPaises extends BaseAdapter {

    Context contexto;
    ArrayList<Pais> listaPaises;

    public AdaptadorPaises(Context contexto, ArrayList<Pais> listaPaises) {
        this.contexto = contexto;
        this.listaPaises = listaPaises;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate =LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.list_view_item, null);

        TextView tvNombreIngles, tvPoblacion, tvNombreCastellano, tvClave, tvCapital, tvContinente, tvLatitud, tvLongitud, tvPaisesFronterizos;

        tvNombreIngles =vista.findViewById(R.id.tvNombreIngles);
        tvPoblacion =vista.findViewById(R.id.tvPoblacion);
        tvNombreCastellano =vista.findViewById(R.id.tvNombreCastellano);
        tvClave =vista.findViewById(R.id.tvClave);
        tvCapital =vista.findViewById(R.id.tvCapital);
        tvContinente =vista.findViewById(R.id.tvContinente);
        tvLatitud =vista.findViewById(R.id.tvLatitud);
        tvLongitud =vista.findViewById(R.id.tvLongitud);
        tvPaisesFronterizos =vista.findViewById(R.id.tvPaisesFronterizos);

        tvNombreIngles.setText(listaPaises.get(position).getNombreIngles());
        tvPoblacion.setText(listaPaises.get(position).getPoblacion());
        tvNombreCastellano.setText(listaPaises.get(position).getNombreCastellano());
        tvClave.setText(listaPaises.get(position).getClave());
        tvCapital.setText(listaPaises.get(position).getCapital());
        tvContinente.setText(listaPaises.get(position).getContinente());
        if(listaPaises.get(position).getLatitud()!=null || listaPaises.get(position).getLatitud()!="") {
            tvLatitud.setText(listaPaises.get(position).getLatitud());
        }
        else {
            tvLatitud.setText("");
        }
        if(listaPaises.get(position).getLongitud()!=null || listaPaises.get(position).getLongitud()!="") {
            tvLongitud.setText(listaPaises.get(position).getLongitud());
        }
        else{
            tvLongitud.setText("");
        }
        tvPaisesFronterizos.setText(listaPaises.get(position).getPaisesFronterizos());

        return vista;
    }
}
