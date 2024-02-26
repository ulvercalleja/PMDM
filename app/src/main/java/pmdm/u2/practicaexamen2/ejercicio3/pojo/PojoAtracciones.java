package pmdm.u2.practicaexamen2.ejercicio3.pojo;

import java.util.List;

public class PojoAtracciones {

    private String url;
    private String nombre;
    private String descripcion;
    private int ocupantes;
    private List<PojoComentarios> comentarios;

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
    public List<PojoComentarios> getComentarios() {
        return comentarios;
    }
}