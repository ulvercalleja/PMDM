package pmdm.u2.ut06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class u6a0Dulce {
    public String dulce;
    public String frutosSecos;
    public String calorias;
    public static final int DULCES_INICIALES = 1;
    private static ArrayList<String> dulces = new ArrayList<String>(Arrays.asList(new String[]{"Turron", "Mazapán", "Polvorón", "Roscón de Reyes", "Rosco de vino", "Peladilla", "Mantecado", "Hojaldrina", "Alfajor",}));

    public static u6a0Dulce generateDulce() {
        Collections.shuffle(dulces);
        u6a0Dulce p = new u6a0Dulce();
        p.dulce = dulces.get(0);

        switch (p.dulce) {
            case "Turron":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "490kcal por cada 100 gramos";
                break;
            case "Mazapán":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "147kcal por cada 30 gramos";
                break;
            case "Polvorón":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "189kcal";
                break;
            case "Roscón de Reyes":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "350kcal por cada 100 gramos";
                break;
            case "Rosco de vino":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "515kcal por cada 100 gramos";
                break;
            case "Peladilla":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "485kcal por cada 100 gramos";
                break;
            case "Mantecado":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "535kcal por cada 100 gramos";
                break;
            case "Hojaldrina":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "571kcal por cada 100 gramos";
                break;
            case "Alfajor":
                p.frutosSecos = "Tiene frutos secos";
                p.calorias = "396kcal por cada 100 gramos";
                break;
            default:
                p.calorias = "0";
                break;
        }
        return p;

    }

    public static u6a0Dulce[] generateDulces(int n) {
        u6a0Dulce[] dulces = new u6a0Dulce[n];
        for(int i = 0; i< n; i++){
            dulces[i] = u6a0Dulce.generateDulce();
        }
        return dulces;
    }


}
