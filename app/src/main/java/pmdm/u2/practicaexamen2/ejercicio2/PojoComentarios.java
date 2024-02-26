package pmdm.u2.practicaexamen2.ejercicio2;

import java.io.Serializable;

public class PojoComentarios implements Serializable {
    private String texto;

    public PojoComentarios(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
