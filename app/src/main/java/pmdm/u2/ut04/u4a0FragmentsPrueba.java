package pmdm.u2.ut04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pmdm.u2.R;

public class u4a0FragmentsPrueba extends AppCompatActivity {

    Button btOpcionUno;
    Button btOpcionDos;
    Button btOpcionTres;
    Button btOpcionCuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a0_fragments_prueba);

        btOpcionUno = findViewById(R.id.u4a0btOpcionUno);
        btOpcionDos = findViewById(R.id.u4a0btOpcionDos);
        btOpcionTres = findViewById(R.id.u4a0btOpcionTres);
        btOpcionCuatro = findViewById(R.id.u4a0btOpcionCuatro);

        btOpcionUno.setOnClickListener(v -> {
            // Crear una instancia del Fragmento Uno
            u4a0FragmentUno fragmentUno = new u4a0FragmentUno();
        });

        btOpcionDos.setOnClickListener(v -> {
            u4a0FragmentDos fragmentDos = new u4a0FragmentDos();
        });

        btOpcionTres.setOnClickListener(v -> {
            u4a0FragmentTres fragmentTres = new u4a0FragmentTres();
        });

        btOpcionCuatro.setOnClickListener(v -> {
            u4a0FragmentCuatro fragmentCuatro = new u4a0FragmentCuatro();
        });
    }
}