package com.activitats.silvia.repasoexamen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Element {
    private int foto;
    private String nom, loc, prov;
    public Element(int idIm, String txt1, String txt2, String txt3){
        this.foto= idIm;
        this.nom= txt1;
        this.loc= txt2;
        this.prov=txt3;
    }

    //getters para recuperar los parámetros del constructor
    public int getFoto(){
        return foto;
    }
    public String getNombre(){
        return nom;
    }
    public String getLocalidad(){
        return loc;
    }
    public String getProvincia(){
        return prov;
    }

}
