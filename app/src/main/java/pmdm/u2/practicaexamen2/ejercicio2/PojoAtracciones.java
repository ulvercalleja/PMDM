package pmdm.u2.practicaexamen2.ejercicio2;

import java.io.Serializable;
import java.util.List;

public class PojoAtracciones implements Serializable {
    private String url;
    private String nombre;
    private String descripcion;
    private int ocupantes;
    private List<Comentario> comentarios;

    public PojoAtracciones(String nombre, String descripcion, int ocupantes, List<Comentario> comentarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ocupantes = ocupantes;
        this.comentarios = comentarios;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
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
