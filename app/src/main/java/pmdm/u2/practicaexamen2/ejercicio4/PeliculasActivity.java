package pmdm.u2.practicaexamen2.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import pmdm.u2.R;

public class PeliculasActivity extends AppCompatActivity {
    public static final String URL = "1";
    private RecyclerView lista;
    private PeliculasAdapter peliculasAdapter;
    private PeliculasViewModel vml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peliculas_activity);

        peliculasAdapter = new PeliculasAdapter();

        lista = findViewById(R.id.e1Rv);

        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(peliculasAdapter);

        vml = new ViewModelProvider(this).get(PeliculasViewModel.class);

        peliculasAdapter.setClickListener((view, url) -> {
            Intent intent = new Intent(this, ActoresActivity.class);
            intent.putExtra(URL,url);
            startActivity(intent);
        });

        vml.getPeliculasData().observe(this, responses -> {
            peliculasAdapter.setResults(responses);
        });

        vml.getLista();
    }
}