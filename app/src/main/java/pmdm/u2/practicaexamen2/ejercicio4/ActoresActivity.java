package pmdm.u2.practicaexamen2.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import pmdm.u2.R;
import pmdm.u2.practicaexamen2.ejercicio4.data.PojoActor;

import java.util.List;

public class ActoresActivity extends AppCompatActivity {
    private TextView titulo;
    private TextView desc;
    private TextView estrellas;
    private TextView actores;
    private ActoresViewModel vml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actores_activity);

        titulo = findViewById(R.id.detalleTitulo);
        desc = findViewById(R.id.detalleDesc);
        estrellas = findViewById(R.id.detalleEstrellas);
        actores = findViewById(R.id.detalleLista);

        Intent intent = getIntent();
        String url = intent.getStringExtra(PeliculasActivity.URL);

        vml = new ViewModelProvider(this).get(ActoresViewModel.class);

        vml.getDetalleData().observe(this, response -> {
            titulo.setText(response.getNombre());
            desc.setText(response.getDescripcion());
            estrellas.setText(response.getEstrellas());
            String textoActores = getActores(response.getActores());
            actores.setText(textoActores);
        });

        vml.getDetalle(url);
    }

    private String getActores(List<PojoActor> listaActores) {
        StringBuilder actores = new StringBuilder();
        for (PojoActor actor : listaActores) {
            actores.append(actor.getNombre());
            actores.append("\n");
        }
        return actores.toString();
    }
}