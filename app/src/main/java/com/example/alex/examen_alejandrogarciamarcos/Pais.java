package com.example.alex.examen_alejandrogarciamarcos;

import java.io.Serializable;

/**
 * Created by Alex on 21/02/2018.
 */

public class Pais implements Serializable {
    String nombreIngles;
    String poblacion;
    String nombreCastellano;
    String clave;
    String capital;
    String continente;
    String latitud;
    String longitud;
    String paisesFronterizos;

    public Pais(String nombreIngles, String poblacion, String nombreCastellano, String clave, String capital, String continente, String latitud, String longitud, String paisesFronterizos) {
        this.nombreIngles = nombreIngles;
        this.poblacion = poblacion;
        this.nombreCastellano = nombreCastellano;
        this.clave = clave;
        this.capital = capital;
        this.continente = continente;
        this.latitud = latitud;
        this.longitud = longitud;
        this.paisesFronterizos = paisesFronterizos;
    }

    public String getNombreIngles() {
        return nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getNombreCastellano() {
        return nombreCastellano;
    }

    public void setNombreCastellano(String nombreCastellano) {
        this.nombreCastellano = nombreCastellano;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPaisesFronterizos() {
        return paisesFronterizos;
    }

    public void setPaisesFronterizos(String paisesFronterizos) {
        this.paisesFronterizos = paisesFronterizos;
    }
}
