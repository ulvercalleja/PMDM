package pmdm.u2.practicaexamen2.ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pmdm.u2.R;
import pmdm.u2.practicaexamen2.ejercicio5.pojo.PojoPelicula;

public class MostrarContenidoPelis extends AppCompatActivity {

    TextView tvContenido;
    Button btVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contenido_pelis);

        tvContenido = findViewById(R.id.textoContenido);
        btVolver = findViewById(R.id.btVolver);

        Intent intent = getIntent();
        PojoPelicula pelicula = (PojoPelicula) intent.getSerializableExtra(PojoPelicula.CLAVE_PELICULAS);

        tvContenido.setText(pelicula.toString());

        btVolver.setOnClickListener((View v)-> finish());


    }
}