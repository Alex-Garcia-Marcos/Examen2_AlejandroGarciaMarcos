package com.example.alex.examen_alejandrogarciamarcos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Alex on 21/02/2018.
 */

public class ActivityMaps extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private String latitud;
    private String longitud;
    private String pais;
    private String capital;
    private String poblacion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        longitud = getIntent().getExtras().getString("longitud");
        latitud = getIntent().getExtras().getString("latitud");
        pais=getIntent().getExtras().getString("pais");
        capital=getIntent().getExtras().getString("capital");
        poblacion=getIntent().getExtras().getString("poblacion");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        LatLng ubicacion= new LatLng(Double.parseDouble(latitud), Double.parseDouble("longitud"));
        mMap.addMarker(new MarkerOptions().position(ubicacion).title(pais+" Capital: "+capital+" Poblacion: "+poblacion));
    }
}
