package pmdm.u2.practicaexamen2.ejercicio3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pmdm.u2.R;

public class ComentariosActivity extends AppCompatActivity {
    private RecyclerView lista;
    private ComentariosAdapter adapter;
    private AtraccionesViewModel vml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        lista = findViewById(R.id.comentariosRV);

        adapter = new ComentariosAdapter();
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);

        vml = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        Intent intent = getIntent();
        String id = intent.getStringExtra(AtraccionesActivity.ID_DETALLE);

        vml.getDetalleData().observe(this, response -> {
            adapter.setResults(response.getComentarios());
        });

        vml.getDetalle(id);
    }
}