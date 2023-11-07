package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pmdm.u2.R;

public class u3a5SiguienteNumero extends AppCompatActivity {
    public static final String INFO_RESULTADO_SUMA = "resultadoSuma";
    String resultadoSuma = "";
    Button btAceptar;
    Button btCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5_siguiente_numero);
        btAceptar = findViewById(R.id.u3a5btAceptar);
        btCancelar = findViewById(R.id.u3a5btCancelar);

        // Obtener los valores "n1" y "n2"
        String strN1 = getIntent().getStringExtra(u3a5Fibonacci.INFO_NUM1);
        String strN2 = getIntent().getStringExtra(u3a5Fibonacci.INFO_NUM2);

        // Convertir los valores a números
        int n1 = Integer.parseInt(strN1);
        int n2 = Integer.parseInt(strN2);
        resultadoSuma = Integer.toString(n1 + n2);

        btAceptar.setOnClickListener((View.OnClickListener) view -> {
            Intent data = new Intent();
            data.putExtra(INFO_RESULTADO_SUMA, resultadoSuma);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        btCancelar.setOnClickListener((View.OnClickListener) view -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
    }
}