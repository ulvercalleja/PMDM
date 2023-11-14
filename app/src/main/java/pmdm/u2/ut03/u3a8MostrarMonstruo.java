package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

import pmdm.u2.R;

public class u3a8MostrarMonstruo extends AppCompatActivity {

    TextView monstruoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8_mostrar_monstruo);

        monstruoTextView = findViewById(R.id.u3a8tvMonstruo);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(u3a8MonstruosSA.KEY_MONSTRUO)) {
            u3a8Monstruo monstruo = (u3a8Monstruo) intent.getSerializableExtra(u3a8MonstruosSA.KEY_MONSTRUO);
            String monstruoString = monstruo.toString();
            monstruoTextView.setText(monstruoString);

            // Cambiar el color del texto en función del color del monstruo
            String color = monstruo.color.toString().toLowerCase();  // Convertir a minúsculas para hacer el check sin distinción de mayúsculas
            switch (color) {
                case "azul":
                    monstruoTextView.setTextColor(Color.BLUE);
                    break;
                case "rojo":
                    monstruoTextView.setTextColor(Color.RED);
                    break;
                case "verde":
                    monstruoTextView.setTextColor(Color.GREEN);
                    break;
                case "amarillo":
                    monstruoTextView.setTextColor(Color.YELLOW);
                    break;
                case "morado":
                    monstruoTextView.setTextColor(Color.MAGENTA);
                    break;
                case "gris":
                    monstruoTextView.setTextColor(Color.GRAY);
                    break;
                default:
                    monstruoTextView.setTextColor(Color.BLACK);
                    break;  // Color predeterminado en caso de que no coincida con ningún caso
            }


        }

    }
}