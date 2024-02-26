package pmdm.u2.practicaexamen2.ejercicio2;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pmdm.u2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ejercicio2Main extends AppCompatActivity {
    private TextView tvError;
    private RecyclerView rvAtracciones;
    private AtraccionesAdapter atraccionesAdapter;
    ProgressBar pbCargando;
    private List<PojoAtracciones> listaAtracciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_examen_ejercicio2);

        rvAtracciones = findViewById(R.id.pe2rvAtracciones);
        pbCargando = findViewById(R.id.pe2pbCargando);
        rvAtracciones.setLayoutManager(new LinearLayoutManager(Ejercicio2Main.this));
        tvError = findViewById(R.id.pe2tvError);

        getAtracciones();
    }
        private void getAtracciones(){

            AtraccionesViewModel mvvm = new ViewModelProvider(this).get(AtraccionesViewModel.class);

            mvvm.getAtraccion().observe(this, integer -> {
                pbCargando.setVisibility(View.INVISIBLE);
                rvAtracciones.setVisibility(View.VISIBLE);
            });

            pbCargando.setVisibility(View.VISIBLE);
            rvAtracciones.setVisibility(View.INVISIBLE);

            RepoAtracciones repoAtracciones = ApiAtracciones.getInstancia().create(RepoAtracciones.class);

            Call<List<PojoAtracciones>> call = repoAtracciones.getAtracciones();

            call.enqueue(new Callback<List<PojoAtracciones>>() {

                @Override
                public void onResponse(Call<List<PojoAtracciones>> call, Response<List<PojoAtracciones>> response) {
                    if (!response.isSuccessful()){
                        tvError.setText("Codigo: " + response.code());
                        atraccionesAdapter = new AtraccionesAdapter(listaAtracciones, Ejercicio2Main.this);
                        rvAtracciones.setAdapter(atraccionesAdapter);
                        mvvm.cargaAtraccion();
                        return;
                    }

                    List<PojoAtracciones> listaAtracciones = response.body();
                    atraccionesAdapter = new AtraccionesAdapter(listaAtracciones, Ejercicio2Main.this);
                    rvAtracciones.setAdapter(atraccionesAdapter);
                }

                @Override
                public void onFailure(Call<List<PojoAtracciones>> call, Throwable t) {
                    tvError.setText(t.getMessage());
                }
            });
        }


}