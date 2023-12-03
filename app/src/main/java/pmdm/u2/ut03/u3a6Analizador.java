package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import pmdm.u2.R;

public class u3a6Analizador extends AppCompatActivity {
    public static final String CLAVE_ANALISIS = "letrascontadas";
    private static  final int LETRAS_A_PASAR = 3;
    LinkedHashMap<Character, Integer> mapaLetras = new LinkedHashMap<>();
    TextView tvLetrasOrdenadas;
    Button btFinAnalisis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_analizador);
        tvLetrasOrdenadas = findViewById(R.id.u3a6tvLetrasOrdenadas);
        btFinAnalisis = findViewById(R.id.u3a6btFinAnalizar);

        // Obtener los valores "texto"
        String texto = getIntent().getStringExtra(u3a6AnalisisLetras.INFO_TEXTO);

        // Cuenta la frecuencia de cada letra en el texto
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                if (mapaLetras.containsKey(c)) {
                    mapaLetras.put(c, mapaLetras.get(c) + 1);
                } else {
                    mapaLetras.put(c, 1);
                }
            }
        }

        // Ordena la lista de acuerdo a la frecuencia de las letras
        List<Map.Entry<Character, Integer>> lista = new ArrayList<>(mapaLetras.entrySet());
        Collections
                .sort(lista, (o1, o2) -> o2.getValue()
                        .compareTo(o1.getValue()));

        // Mostrar todas las letras y sus recuentos en el TextView
        StringBuilder sb = new StringBuilder();

        //utilizando el método forEach de la interfaz Map:
        lista.forEach(entry -> sb.append("Letra ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));

        tvLetrasOrdenadas.setText(sb.toString());

        // Lógica para devolver los datos a la actividad principal
        btFinAnalisis.setOnClickListener(view -> {
            // Obtener las tres letras más repetidas
            List<Map.Entry<Character, Integer>> tresMasListadas = lista.subList(0, Math.min(lista.size(), LETRAS_A_PASAR));
            StringBuilder sb2 = new StringBuilder();
            // Construir una cadena de texto con las tres letras más repetidas
            for (Map.Entry<Character, Integer> entry : tresMasListadas) {
                sb2.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            // Crear un Intent y pasar los datos a la actividad principal
            Intent dato = new Intent();
            dato.putExtra(CLAVE_ANALISIS, sb2.toString());
            setResult(Activity.RESULT_OK, dato);
            finish();
        });

    }
}