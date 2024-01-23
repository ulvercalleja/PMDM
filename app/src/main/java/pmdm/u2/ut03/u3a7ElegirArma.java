package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import pmdm.u2.R;

public class u3a7ElegirArma extends AppCompatActivity {

    public static final String INFO_IMAGEN = "ImageResourceArma";
    ImageButton ivArma1;
    ImageButton ivArma2;
    ImageButton ivArma3;
    ImageButton ivArma4;
    Button btLimpiar;
    Button btCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_elegir_arma);
        ivArma1 = findViewById(R.id.u3a7ivArma1);
        ivArma2 = findViewById(R.id.u3a7ivArma2);
        ivArma3 = findViewById(R.id.u3a7ivArma3);
        ivArma4 = findViewById(R.id.u3a7ivArma4);
        btLimpiar = findViewById(R.id.u3a7btLimpiarArma);
        btCancelar = findViewById(R.id.u3a7btCancelarArma);

        ivArma1.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.arma_uno);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        ivArma2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.arma_dos);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        ivArma3.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.arma_tres);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        ivArma4.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.arma_cuatro);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        btLimpiar.setOnClickListener(view -> {
            Intent data = new Intent();
            setResult(Activity.RESULT_FIRST_USER, data);
            finish();
        });

        btCancelar.setOnClickListener(view -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
    }
}