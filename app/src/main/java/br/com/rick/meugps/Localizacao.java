package br.com.rick.meugps;

import java.io.Serializable;

public class Localizacao implements Serializable {
    private int id;
    private double lat;
    private double lon;

    public Localizacao(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String toString(){
        return "" + lat + ", " + lon;
    }
}
