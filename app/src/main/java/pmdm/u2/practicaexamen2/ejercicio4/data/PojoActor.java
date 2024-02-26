package pmdm.u2.practicaexamen2.ejercicio4.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoActor {

    private String url;
    private String nombre;
    private String pelicula;

    public String getNombre() {
        return nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getUrl() {
        return url;
    }
}
