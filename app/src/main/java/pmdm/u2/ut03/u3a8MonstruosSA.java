package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pmdm.u2.R;

public class u3a8MonstruosSA extends AppCompatActivity {

    public static final String KEY_MONSTRUO = "sullivan";

    EditText nombreEditText;
    EditText numeroMiembros;
    EditText colorEditText;
    Button enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8_monstruos_sa);

        nombreEditText = findViewById(R.id.u3a8etNombre);
        numeroMiembros = findViewById(R.id.u3a8etNumMiembros);
        colorEditText = findViewById(R.id.u3a8etColor);
        enviarButton = findViewById(R.id.u3a8btEnviar);

        enviarButton.setOnClickListener(v -> {
            String nombre = nombreEditText.getText().toString();
            String miembrosET = numeroMiembros.getText().toString();
            String color = colorEditText.getText().toString();

            if (nombre.isEmpty() || miembrosET.isEmpty() || color.isEmpty()) {
                if (nombre.isEmpty()) {
                    nombreEditText.setError("Por favor, introduzca un nombre.");
                } else {
                    nombreEditText.setError(null);
                }

                if (miembrosET.isEmpty()) {
                    numeroMiembros.setError("Por favor, introduzca un número.");
                } else {
                    numeroMiembros.setError(null);
                }

                if (color.isEmpty()) {
                    colorEditText.setError("Por favor, introduzca un color.");
                } else {
                    colorEditText.setError(null);
                }
            } else {
                try {
                    int miembros = Integer.parseInt(numeroMiembros.getText().toString());
                    u3a8Monstruo monstruo = new u3a8Monstruo(nombre, miembros, color);
                    Intent intent = new Intent(this, u3a8MostrarMonstruo.class);
                    intent.putExtra(KEY_MONSTRUO, monstruo);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    numeroMiembros.setError("Por favor, introduzca un número válido." + e.getMessage());
                }
            }
        });
    }
}