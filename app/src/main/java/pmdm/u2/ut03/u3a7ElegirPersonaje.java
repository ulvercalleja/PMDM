package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import pmdm.u2.R;

public class u3a7ElegirPersonaje extends AppCompatActivity {
    public static final String INFO_IMAGEN = "ImageResourcePersonaje";
    public static final String INFO_PERSONAJE = "PERSONAJESELECCIONADO";
    ImageButton ivPersonaje1;
    ImageButton ivPersonaje2;
    ImageButton ivPersonaje3;
    ImageButton ivPersonaje4;
    Button btLimpiar;
    Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_elegir_personaje);
        ivPersonaje1 = findViewById(R.id.u3a7ivPersonaje1);
        ivPersonaje2 = findViewById(R.id.u3a7ivPersonaje2);
        ivPersonaje3 = findViewById(R.id.u3a7ivPersonaje3);
        ivPersonaje4 = findViewById(R.id.u3a7ivPersonaje4);
        btLimpiar = findViewById(R.id.u3a7btLimpiarPersonaje);
        btCancelar = findViewById(R.id.u3a7btCancelarPersonaje);

        ivPersonaje1.setOnClickListener(view -> {
            ivPersonaje1.setVisibility(View.INVISIBLE);
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.personaje1);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        ivPersonaje2.setOnClickListener(view -> {
            ivPersonaje2.setVisibility(View.INVISIBLE);
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.personaje2);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        ivPersonaje3.setOnClickListener(view -> {
            ivPersonaje3.setVisibility(View.INVISIBLE);
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.personaje3);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        ivPersonaje4.setOnClickListener(view -> {
            ivPersonaje4.setVisibility(View.INVISIBLE);
            Intent intent = new Intent();
            intent.putExtra(INFO_IMAGEN, R.drawable.personaje4);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        btLimpiar.setOnClickListener(view -> {
            setResult(Activity.RESULT_FIRST_USER);
            finish();
        });

        btCancelar.setOnClickListener(view -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
    }
}