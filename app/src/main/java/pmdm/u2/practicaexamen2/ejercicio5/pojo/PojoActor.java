package pmdm.u2.practicaexamen2.ejercicio5.pojo;

import java.io.Serializable;

public class PojoActor implements Serializable {

    public PojoActor(String url, String nombre, String pelicula){
        this.url = url;
        this.nombre = nombre;
        this.pelicula = pelicula;
    }

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
