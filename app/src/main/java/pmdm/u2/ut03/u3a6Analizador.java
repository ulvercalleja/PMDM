package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a6Analizador extends AppCompatActivity {
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

    }
}