package pmdm.u2.ut09;

import java.io.Serializable;

public class PojoAlimentos implements Serializable {

    private int id;
    private String nombre;
    private int valorCalorico;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValorCalorico() {
        return valorCalorico;
    }
}
