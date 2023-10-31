package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pmdm.u2.R;

public class u3a4MostrarNombreP2 extends AppCompatActivity {
    EditText etNombreUsuario;
    Button btAceptar;
    Button btCancelar;
    Button btLimpiar;
    String nombre = "";
    public static final String INFO_NOMBREP2 = "nombreUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_mostrar_nombre_p2);

        etNombreUsuario = findViewById(R.id.u3a4etNombreUsuario);
        btAceptar = findViewById(R.id.u3a4btAceptar);
        btCancelar = findViewById(R.id.u3a4btCancelar);
        btLimpiar = findViewById(R.id.u3a4btLimpiar);

        nombre = getIntent().getStringExtra(u3a4MostrarNombre.INFO_NOMBREP1);
        etNombreUsuario.setText(nombre);

        btAceptar.setOnClickListener((View.OnClickListener) view -> {
            nombre = String.valueOf(etNombreUsuario.getText());
            Intent data = new Intent();
            data.putExtra(INFO_NOMBREP2, nombre);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        btCancelar.setOnClickListener((View.OnClickListener) view -> {
            nombre = String.valueOf(etNombreUsuario.getText());
            Intent data = new Intent();
            data.putExtra(INFO_NOMBREP2, nombre);
            setResult(Activity.RESULT_CANCELED, data);
            finish();
        });

        btLimpiar.setOnClickListener((View.OnClickListener) view -> {

        });

    }
}