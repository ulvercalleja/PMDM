package pmdm.u2.ut03;

import java.io.Serializable;
import java.util.Random;

public class u3a8Monstruo implements Serializable {
    String nombre;
    int numeroMiembros;
    String color;
    int brazosIzquierdos;
    int brazosDerechos;
    int piernasIzquierdas;
    int piernasDerechas;
    public u3a8Monstruo(String nombre, int numeroMiembros, String color) {
        this.nombre = nombre;
        this.numeroMiembros = numeroMiembros;
        this.color = color;
        // Distribución aleatoria de partes entre brazos, piernas, y torso
        Random random = new Random();
        brazosIzquierdos = random.nextInt(numeroMiembros + 1);
        brazosDerechos = random.nextInt(numeroMiembros - brazosIzquierdos + 1);
        piernasIzquierdas = random.nextInt(numeroMiembros - brazosIzquierdos - brazosDerechos + 1);
        piernasDerechas = numeroMiembros - brazosIzquierdos - brazosDerechos - piernasIzquierdas;
    }

    @Override
    public String toString() {

        StringBuilder monstruoAsciiArt = new StringBuilder();

        monstruoAsciiArt.append("Nombre: ").append(nombre).append("\n");
        monstruoAsciiArt.append("Color: ").append(color).append("\n");
        monstruoAsciiArt.append("Número de partes: ").append(numeroMiembros).append("\n");

        // Dibujar el monstruo con ASCII art
        monstruoAsciiArt.append("*\n");

        // Dibujar brazos izquierdos
        for (int i = 0; i < brazosIzquierdos; i++) {
            monstruoAsciiArt.append("/");
        }

        // Dibujar torso
        monstruoAsciiArt.append("o");

        // Dibujar brazos derechos
        for (int i = 0; i < brazosDerechos; i++) {
            monstruoAsciiArt.append("\\");
        }
        monstruoAsciiArt.append("\n");

        // Dibujar piernas izquierdas
        for (int i = 0; i < piernasIzquierdas; i++) {
            monstruoAsciiArt.append("/");
        }
        monstruoAsciiArt.append("   ");

        // Dibujar piernas derechas
        for (int i = 0; i < piernasDerechas; i++) {
            monstruoAsciiArt.append("\\");
        }
        monstruoAsciiArt.append("\n");

        return monstruoAsciiArt.toString();
    }
}
