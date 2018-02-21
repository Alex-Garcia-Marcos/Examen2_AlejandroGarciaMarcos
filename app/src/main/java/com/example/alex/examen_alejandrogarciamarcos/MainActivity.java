package com.example.alex.examen_alejandrogarciamarcos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPaisesDelMundo;

    //private static final String URL="https://restcountries.eu/rest/v2/all";
    private static final String URL="http://192.168.31.44/Paises/paises.json";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPaisesDelMundo=findViewById(R.id.lvPaisesDelMundo);

        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {

                ArrayList<Pais> listaPaises = new ArrayList<Pais>();
                int tamañoArray = response.length();


                String paisesFronterizos = "";
                try {
                    JSONArray jsonArrayPrincipal = new JSONArray(response.toString(0));
                    for (int i = 0; i < tamañoArray; i++) {
                         String nombreIngles = jsonArrayPrincipal.getJSONObject(i).getString("name");
                        String poblacion = jsonArrayPrincipal.getJSONObject(i).getString("population");
                        String nombreCastellano = jsonArrayPrincipal.getJSONObject(i).getJSONObject("translations").getString("es");
                        String clave = jsonArrayPrincipal.getJSONObject(i).getString("alpha2Code");
                        String capital = jsonArrayPrincipal.getJSONObject(i).getString("capital");
                        String continente = jsonArrayPrincipal.getJSONObject(i).getString("region");
                        String latitud = jsonArrayPrincipal.getJSONObject(i).getJSONObject("latlng").getString("0");
                        String longitud = jsonArrayPrincipal.getJSONObject(i).getJSONObject("latlng").getString("1");
                        for (int j = 0; j < jsonArrayPrincipal.getJSONObject(i).getJSONObject("latlng").length(); j++) {
                            paisesFronterizos = paisesFronterizos + " " + response.getJSONObject(i).getJSONObject("borders").getString("" + j);
                        }
                       /* String nombreIngles = response.getJSONObject(i).getString("name");
                        String poblacion = response.getJSONObject(i).getString("population");
                        String nombreCastellano = response.getJSONObject(i).getJSONObject("translations").getString("es");
                        String clave = response.getJSONObject(i).getString("alpha2Code");
                        String capital = response.getJSONObject(i).getString("capital");
                        String continente = response.getJSONObject(i).getString("region");
                        String latitud = response.getJSONObject(i).getJSONObject("latlng").getString("0");
                        String longitud = response.getJSONObject(i).getJSONObject("latlng").getString("1");
                        for (int j = 0; j < response.getJSONObject(i).getJSONObject("latlng").length(); j++) {
                            paisesFronterizos = paisesFronterizos + " " + response.getJSONObject(i).getJSONObject("borders").getString("" + j);
                        }*/
                        Pais pais = new Pais(nombreIngles, poblacion, nombreCastellano, clave, capital, continente, latitud, longitud, paisesFronterizos);

                        listaPaises.add(pais);
                    }

                     AdaptadorPaises adaptador= new AdaptadorPaises(getApplicationContext(), listaPaises);

                    lvPaisesDelMundo.setAdapter(adaptador);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        request.add(jsonArrayRequest);

        lvPaisesDelMundo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getApplicationContext(),ActivityMaps.class);
                intent.putExtra("pais",view.findViewById(R.id.tvNombreCastellano).toString());
                intent.putExtra("capital",view.findViewById(R.id.tvCapital).toString());
                intent.putExtra("poblacion",view.findViewById(R.id.tvPoblacion).toString());
                startActivity(intent);
            }
        });
    }
}
