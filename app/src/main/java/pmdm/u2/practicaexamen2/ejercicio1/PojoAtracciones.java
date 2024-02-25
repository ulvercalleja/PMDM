package pmdm.u2.practicaexamen2.ejercicio1;

import java.io.Serializable;

public class PojoAtracciones implements Serializable {
    private String url;
    private String nombre;
    private String descripcion;
    private int ocupantes;

    public PojoAtracciones(String nombre, String descripcion, int ocupantes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ocupantes = ocupantes;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOcupantes() {
        return ocupantes;
    }
}
