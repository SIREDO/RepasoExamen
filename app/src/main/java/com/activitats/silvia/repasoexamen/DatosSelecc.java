package com.activitats.silvia.repasoexamen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DatosSelecc extends Activity {
    private ImageView foto;
    private TextView nombre, n, localidad, l, provincia, p;
    private Spinner spin, spincol;
    ArrayAdapter<String> adap_anim, adap_colores;
    String [] array_animales;
    ArrayList<String> aco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_selecc);

        foto = (ImageView)findViewById(R.id.ivF);
        nombre = (TextView) findViewById(R.id.tvN);
        n = (TextView) findViewById(R.id.tvNombre);
        localidad = (TextView) findViewById(R.id.tvL);
        l = (TextView) findViewById(R.id.tvLoc);
        provincia = (TextView) findViewById(R.id.tvP);
        p = (TextView) findViewById(R.id.tvProv);
        spin = (Spinner)findViewById(R.id.sp);
        spincol= (Spinner)findViewById(R.id.spc);

        n.setText(this.getIntent().getExtras().getString("nom"));
        l.setText(this.getIntent().getExtras().getString("loc"));
        p.setText(this.getIntent().getExtras().getString("prov"));

        //rellenamos el spinner: creamos array de strings de animales y recogemos la info del archivo arrays
        String array_animales[] = getResources().getStringArray(R.array.animales);

        //creamos arraylist de paises, con el metodo aslist le pasamos el array estático que ya teniamos
        ArrayList<String> aAnim= new ArrayList<String>(Arrays.asList(array_animales));

        //creamos adaptador de strings y le pasamos el array de paises
        adap_anim= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,aAnim);

        //pasamos al spinner el adaptador que hemos creado
        spin.setAdapter(adap_anim);

        aco= new ArrayList<String>();
        adap_colores= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,aco);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        aco = new ArrayList<String>();

                        break;
                    case 1:
                        aco = new ArrayList<String>( Arrays.asList(getResources().getStringArray(R.array.Colores_Elefante)));
                        Toast.makeText(getApplicationContext(), "Has elegido "+spin.getSelectedItem().toString()+", ahora elige un color", Toast.LENGTH_LONG).show();

                        break;
                    case 2:
                        aco = new ArrayList<String>( Arrays.asList(getResources().getStringArray(R.array.Colores_Tortuga)));
                        Toast.makeText(getApplicationContext(), "Has elegido "+spin.getSelectedItem().toString()+", ahora elige un color", Toast.LENGTH_LONG).show();

                        break;
                    case 3:
                        aco = new ArrayList<String>( Arrays.asList(getResources().getStringArray(R.array.Colores_Conejo)));
                        Toast.makeText(getApplicationContext(), "Has elegido "+spin.getSelectedItem().toString()+", ahora elige un color", Toast.LENGTH_LONG).show();

                        break;
                    case 4:
                        aco = new ArrayList<String>( Arrays.asList(getResources().getStringArray(R.array.Colores_Ratón)));
                        Toast.makeText(getApplicationContext(), "Has elegido "+spin.getSelectedItem().toString()+", ahora elige un color", Toast.LENGTH_LONG).show();

                        break;
                    case 5:
                        aco = new ArrayList<String>( Arrays.asList(getResources().getStringArray(R.array.Colores_Gato)));
                        Toast.makeText(getApplicationContext(), "Has elegido "+spin.getSelectedItem().toString()+", ahora elige un color", Toast.LENGTH_LONG).show();

                        break;
                }
                adap_colores.clear();
                adap_colores.addAll(aco);
                spincol.setAdapter(adap_colores);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }



        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datos_selecc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
