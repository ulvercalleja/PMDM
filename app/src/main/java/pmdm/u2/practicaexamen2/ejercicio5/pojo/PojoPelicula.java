package pmdm.u2.practicaexamen2.ejercicio5.pojo;

import java.io.Serializable;
import java.util.List;

public class PojoPelicula implements Serializable {

    private String url;
    private String nombre;
    private String descripcion;
    private Integer estrellas;
    private List<PojoActor> listaActores;
    public static final String CLAVE_PELICULAS = "peliculas";

    public PojoPelicula(String nombre, String descripcion, Integer estrellas, List<PojoActor> listaActores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
        this.listaActores = listaActores;
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

    public Integer getEstrellas() {
        return estrellas;
    }

    public List<PojoActor> getActores() {
        return listaActores;
    }

    public String toString() {
        StringBuilder actores = new StringBuilder();

        actores.append("Pelicula : " + nombre + "\n");
        actores.append("Descripcion : " + descripcion + "\n");
        actores.append("Estrellas : " + estrellas + "\n");
        actores.append("\n");

        if (!listaActores.isEmpty()) {
            // Iteramos sobre la lista de actores
            for (PojoActor actor : listaActores) {
                // Obtenemos los datos del actor actual
                String urlActor = actor.getUrl();
                String nombreActor = actor.getNombre();
                String peliculaActor = actor.getPelicula();

                // Añadimos la información del actor actual al StringBuilder
                actores.append("URL del actor: " + urlActor + "\n");
                actores.append("Nombre del actor: " + nombreActor + "\n");
                actores.append("Película del actor: " + peliculaActor + "\n");
                actores.append("\n"); // Añadimos un salto de línea entre cada actor
            }
        } else {
            actores.append("No hay datos de actores disponibles.\n");
        }

        return actores.toString();
    }
}


