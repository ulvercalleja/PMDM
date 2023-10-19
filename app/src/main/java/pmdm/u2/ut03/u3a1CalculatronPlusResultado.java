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

        tvResultado = findViewById(R.id.u3a1tvResultado);
        btVolver = findViewById(R.id.u3a1btVolver);

        double resultado = 0;

        String operacion = getIntent().getStringExtra("operacion");
        double num1 = Double.parseDouble(getIntent().getStringExtra("num1"));
        double num2 = Double.parseDouble(getIntent().getStringExtra("num2"));

        if (operacion.equals("Sumar")){
            resultado = num1 + num2;
        } else if (operacion.equals("Restar")){
            resultado = num1 - num2;
        } else if (operacion.equals("Multiplicar")){
            resultado = num1 * num2;
        } else if (operacion.equals("Dividir")){
            resultado = num1 / num2;
        }
        String resultadoString = String.format("%.2f", resultado); // Formatea el resultado como una cadena con 2 decimales
        tvResultado.setText(resultadoString);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la segunda actividad y volver a la primera
                Intent intent = new Intent(u3a1CalculatronPlusResultado.this, u3a1CalculatronPlus.class);
                startActivity(intent);
                finish();
            }
        });
    }
}