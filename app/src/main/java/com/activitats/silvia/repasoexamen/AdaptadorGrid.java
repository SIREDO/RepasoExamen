package com.activitats.silvia.repasoexamen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class AdaptadorGrid extends BaseAdapter {
    private Context context;
    private int idLayout;
    private ArrayList<?> entradas;

    public AdaptadorGrid(Context context,int idLayout,ArrayList<?> entradas ){
        super();
        this.context= context;
        this.idLayout= idLayout;
        this.entradas= entradas;
    }

    //Método, propio de la clase Adaptador, que devuelve el número de entradas que hay en el arraylist
    public int getCount(){

        return entradas.size();
    }

    ////Método, propio de la clase Adaptador, que devuelve el elemento de la posición indicada del arraylist
    public Object getItem(int position){
        return entradas.get(position);
    }

    //Método, propio de la clase Adaptador, que devuelve el identificador del item en su posición
    public long getItemId(int position){

        return position;
    }

    ////Método, propio de la clase Adaptador, que devuelve un View que relaciona datos con element.xml
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            //Accedemos al servicio que permite inflar Layouts
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Inflamos el layout
            convertView=vi.inflate(idLayout, null);
        }
        onEntrada (entradas.get(position), convertView);
        return convertView;
    }


    public abstract void onEntrada(Object entrada, View view);
}
