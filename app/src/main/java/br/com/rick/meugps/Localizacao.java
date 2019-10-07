package br.com.rick.meugps;

import java.io.Serializable;

public class Localizacao implements Serializable {
    private double lat;
    private double lon;

    public Localizacao(){

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
}
