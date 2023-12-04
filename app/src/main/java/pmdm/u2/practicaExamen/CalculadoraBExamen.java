package pmdm.u2.practicaExamen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import pmdm.u2.R;
import pmdm.u2.ut03.u3a1CalculatronPlus;

public class CalculadoraBExamen extends AppCompatActivity {
    TextView tvResultado;
    Button btVolver, btReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_calculadorab_examen);

        tvResultado = findViewById(R.id.extvResultado);
        btReset = findViewById(R.id.exbtReset);
        btVolver = findViewById(R.id.exbtVolver);
        double resultado = 0;

        // Obtener los datos pasados desde la actividad anterior
        String operacion = getIntent().getStringExtra(u3a1CalculatronPlus.INFO_NOMBRE_OPERACION);
        double num1 = Double.parseDouble(getIntent().getStringExtra(u3a1CalculatronPlus.INFO_NOMBRE_NUMERO1));
        double num2 = Double.parseDouble(getIntent().getStringExtra(u3a1CalculatronPlus.INFO_NOMBRE_NUMERO2));

        // Realizar la operación seleccionada
        if (operacion.equals("Sumar")){
            resultado = num1 + num2;
        } else if (operacion.equals("Restar")){
            resultado = num1 - num2;
        } else if (operacion.equals("Multiplicar")){
            resultado = num1 * num2;
        } else if (operacion.equals("Dividir")){
            resultado = num1 / num2;
        }

        String resultadoString = String.format("%.2f", resultado); // Formatear el resultado como una cadena con 2 decimales

        tvResultado.setText(resultadoString); // Mostrar el resultado en el TextView

        btVolver.setOnClickListener(v -> {
            // Cerrar la segunda actividad para volver a la primera
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });

        btReset.setOnClickListener(v -> {
            // Cerrar la segunda actividad para volver a la primera
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}