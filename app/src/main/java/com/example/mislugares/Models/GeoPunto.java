package com.example.mislugares.Models;

public class GeoPunto {

    private double longitud, latitud;

    public GeoPunto(double longitud, double latitud) {
        this.longitud= longitud;
        this.latitud= latitud;
    }

    public String toString() {
        return "longitud:" + longitud + ", latitud:" + latitud;
    }

    public double distancia(GeoPunto punto) {
        final double RADIO_TIERRA = 6371000; // en metros
        double dLat = Math.toRadians(latitud - punto.latitud);
        double dLon = Math.toRadians(longitud - punto.longitud);
        double lat1 = Math.toRadians(punto.latitud);
        double lat2 = Math.toRadians(latitud);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) *
                        Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return c * RADIO_TIERRA;
    }

    //<editor-fold desc="GETTERS METHOD">
    public double getLongitud() { return longitud; }

    public double getLatitud() { return latitud; }
    //</editor-fold>

    //<editor-fold desc="SETTERS METHOD">
    public void setLongitud(double longitud) { this.longitud = longitud; }

    public void setLatitud(double latitud) { this.latitud = latitud; }
    //</editor-fold>
}
