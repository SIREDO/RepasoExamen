package com.activitats.silvia.repasoexamen;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Principal extends Activity {
    final String[] nombres = new String[]{"","Juan", "Pepe", "Ana", "Luisa", "Concha","Toño"};
    final String[] localidades = new String[]{"","Alboraya", "Torrevieja", "Nules", "Foios", "Puebla de Farnals","Valencia"};
    final String[] provincias = new String[]{"","Castellón", "Valencia", "Alicante"};
    private GridView grid;
    private Spinner spin;
    final int DATOSSELECC_1=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptador_grid);

        //Creamos ArrayList de elemetos y le añadimos los elementos con los datos

        ArrayList<Element> datosGrid = new ArrayList<Element>();

        datosGrid.add(new Element(R.drawable.perfil,nombres[0],localidades[0], provincias[0]));
        datosGrid.add(new Element(R.drawable.perfil,nombres[1],localidades[1], provincias[2]));
        datosGrid.add(new Element(R.drawable.usu,nombres[2],localidades[2], provincias[3]));
        datosGrid.add(new Element(R.drawable.usu1,nombres[3],localidades[3], provincias[1]));
        datosGrid.add(new Element(R.drawable.usu2,nombres[4],localidades[4], provincias[2]));
        datosGrid.add(new Element(R.drawable.usu3,nombres[5],localidades[5], provincias[2]));
        datosGrid.add(new Element(R.drawable.usu4,nombres[6],localidades[6], provincias[2]));

        //Obtenemos objeto GridView y le establecemos nuestro adaptador
        grid= (GridView)findViewById(R.id.gvGrid);
        spin= (Spinner)findViewById(R.id.spinn);


        spin.setAdapter(new AdaptadorGrid(this, R.layout.activity_element, datosGrid) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    ImageView imagen = (ImageView) view.findViewById(R.id.iwFoto);
                    if (imagen != null)
                        imagen.setImageResource(((Element) entrada).getFoto());

                    TextView nombre = (TextView) view.findViewById(R.id.tvNombre);
                    if (nombre != null)
                        nombre.setText(((Element) entrada).getNombre());

                    TextView loc = (TextView) view.findViewById(R.id.twLoc);
                    if (loc != null)
                        loc.setText(((Element) entrada).getLocalidad());
                    TextView prov = (TextView) view.findViewById(R.id.twProv);
                    if (prov != null)
                        prov.setText(((Element) entrada).getProvincia());
                }
            }
        });



        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), DatosSelecc.class);
                Bundle b = new Bundle();
                // i.putExtras(b);
                switch (position) {

                    case 0:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        //startActivity(i);
                        break;
                    case 1:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        startActivity(i);
                        notifExpan();
                        break;

                    case 2:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        startActivity(i);
                        notifExpan();
                        break;
                    case 3:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        startActivity(i);
                        notifExpan();
                        break;
                    case 4:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        startActivity(i);
                        notifExpan();
                        break;
                    case 5:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        startActivity(i);
                        notifExpan();
                        break;
                    case 6:
                        b.putString("nom", nombres[position]);
                        b.putString("loc", localidades[position]);
                        b.putString("prov", provincias[position]);
                        i.putExtras(b);
                        startActivity(i);
                        notifExpan();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



        grid.setAdapter(new AdaptadorGrid(this, R.layout.activity_element, datosGrid) {
            @Override
            public void onEntrada(Object entrada, View view) {

                if (entrada != null) {
                    ImageView imagen = (ImageView) view.findViewById(R.id.iwFoto);
                    if (imagen != null)
                        imagen.setImageResource(((Element) entrada).getFoto());

                    TextView nombre = (TextView) view.findViewById(R.id.tvNombre);
                    if (nombre != null)
                        nombre.setText(((Element) entrada).getNombre());

                    TextView loc = (TextView) view.findViewById(R.id.twLoc);
                    if (loc != null)
                        loc.setText(((Element) entrada).getLocalidad());
                    TextView prov = (TextView) view.findViewById(R.id.twProv);
                    if (prov != null)
                        prov.setText(((Element) entrada).getProvincia());
                }
            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                    case 1:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                    case 2:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                    case 3:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                    case 4:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                    case 5:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                    case 6:
                        notificar("Has seleccionado ",nombres[position]);
                        break;
                }
            }
        });
    }

    public void notificar(String titulo, String texto){
        Notification.Builder ncb = new Notification.Builder(getApplicationContext());
        ncb.setContentTitle(titulo);
        ncb.setContentText(texto);
        ncb.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        ncb.setSmallIcon(R.mipmap.ic_launcher);
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,ncb.build());
    }
    public void notifExpan(){
        //cremos notificación
        Notification.Builder ncb = new Notification.Builder(getApplicationContext());
        ncb.setContentTitle("Notificación");
        ncb.setContentText("¿Quieres volver?");
        ncb.setSmallIcon(R.mipmap.ic_launcher);

        //Definimos objeto InboxStyle (notificación expandida)
        Notification.InboxStyle iS = new Notification.InboxStyle();

        //Agregamos las líneas de texto que mostrará cuando se expanda la notificación
        iS.addLine("Selecciona una opción");


        //Agregamos a la notificación el InboxStyle
        ncb.setStyle(iS);

        //creamos dos acciones a ejecutar desde la notificación
        Intent iC = new Intent();
        PendingIntent pi1 = PendingIntent.getActivity(this, 0, iC, PendingIntent.FLAG_UPDATE_CURRENT);
        ncb.addAction(R.mipmap.ic_launcher, "CONTINUAR", pi1);

        Intent iR = new Intent(getApplicationContext(),Principal.class);
        PendingIntent pi2 = PendingIntent.getActivity(this, 0, iR, PendingIntent.FLAG_UPDATE_CURRENT);
        ncb.addAction(R.mipmap.ic_launcher,"VOLVER",pi2);

        //agregamos las dos acciones a la notificación expandida
        ncb.setContentIntent(pi1);
        ncb.setContentIntent(pi2);

        //Lanzamos la notificación
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(2, ncb.build());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
