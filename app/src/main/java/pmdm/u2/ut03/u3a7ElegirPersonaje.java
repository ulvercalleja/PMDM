package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import pmdm.u2.R;

public class u3a7ElegirPersonaje extends AppCompatActivity {

    public static final String INFO_IMAGEN = "ImageResourcePersonaje";
    int imageResource = 0;
    View.OnClickListener manejador;
    ImageView ivPersonaje1;
    ImageView ivPersonaje2;
    ImageView ivPersonaje3;
    ImageView ivPersonaje4;
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

        manejador = (View imagenPulsada) -> {
            ImageView imagen = (ImageView) imagenPulsada;
            if (imagenPulsada == ivPersonaje1){
                imageResource = R.drawable.personaje1;
                Intent intent = new Intent();
                intent.putExtra(INFO_IMAGEN, imageResource);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else if(imagenPulsada == ivPersonaje2){
                imageResource = R.drawable.personaje2;
                Intent intent = new Intent();
                intent.putExtra(INFO_IMAGEN, imageResource);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else if(imagenPulsada == ivPersonaje3){
                imageResource = R.drawable.personaje3;
                Intent intent = new Intent();
                intent.putExtra(INFO_IMAGEN, imageResource);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else if(imagenPulsada == ivPersonaje4){
                imageResource = R.drawable.personaje4;
                Intent intent = new Intent();
                intent.putExtra(INFO_IMAGEN, imageResource);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        };

        ivPersonaje1.setOnClickListener(manejador);
        ivPersonaje2.setOnClickListener(manejador);
        ivPersonaje3.setOnClickListener(manejador);
        ivPersonaje4.setOnClickListener(manejador);

        btLimpiar.setOnClickListener(view -> {
            finish();
        });

        btCancelar.setOnClickListener(view -> {
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
    }
}