package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a1CalculatronPlusResultado extends AppCompatActivity {
    TextView tvResultado;
    Button btVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_calculatron_plus_resultado);

        // Inicialización de las variables
        tvResultado = findViewById(R.id.u3a1tvResultado);
        btVolver = findViewById(R.id.u3a1btVolver);
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


        // Configurar el listener para el botón "Volver"
        btVolver.setOnClickListener(v -> {
            // Cerrar la segunda actividad para volver a la primera
            finish();
        });
    }
}