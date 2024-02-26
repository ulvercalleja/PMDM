package pmdm.u2.practicaexamen2.ejercicio5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import pmdm.u2.R;
import pmdm.u2.practicaexamen2.ejercicio5.api.PeliculasApi;
import pmdm.u2.practicaexamen2.ejercicio5.pojo.PojoActor;
import pmdm.u2.practicaexamen2.ejercicio5.pojo.PojoPelicula;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActividadPeliculas extends AppCompatActivity {

    RecyclerView rvPeliculas;
    Button btPelis;
    PeliculasAdapter adapter;
    ProgressBar pbCargando;
    EditText etSeleccion;
    TextView tvError;
    private PeliculasViewModel peliculasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_peliculas);

        rvPeliculas = (RecyclerView) findViewById(R.id.recyclerPeliculas);
        pbCargando = findViewById(R.id.pbCargandoPelis);
        etSeleccion = findViewById(R.id.seleccionPelicula);
        btPelis = findViewById(R.id.botonPeliculas);
        tvError = findViewById(R.id.tvError);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPeliculas.setLayoutManager(layoutManager);

        peliculasViewModel = new ViewModelProvider(this).get(PeliculasViewModel.class);

        peliculasViewModel.getCargando().observe(this, cargando -> {
            if (cargando) {
                pbCargando.setVisibility(View.VISIBLE);
            } else {
                pbCargando.setVisibility(View.GONE);
            }
        });

        btPelis.setOnClickListener((v)->{
            String seleccion = etSeleccion.getText().toString();
            if(seleccion == null | seleccion.equals("")) {
                tvError.setText("Introduce un id de pelicula.");
            }else{
                peliculasViewModel.setCargando(true);
                PeliculasApi peli = PeliculasApi.getInstancia();
                Call<JsonObject> llamada = peli.getAPI().getPelicula(Integer.parseInt(seleccion));

                llamada.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject listaPeliculas = response.body();
                            List<PojoPelicula> listPelis = parseJson(listaPeliculas);


                            adapter = new PeliculasAdapter(listPelis);
                            rvPeliculas.setAdapter(adapter);

                            adapter.setOnItemClickListener(new PeliculasAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(PojoPelicula pelicula) {
                                    Intent i = new Intent(ActividadPeliculas.this, MostrarContenidoPelis.class);
                                    i.putExtra(PojoPelicula.CLAVE_PELICULAS, pelicula);
                                    startActivity(i);
                                }
                            });
                        }
                        peliculasViewModel.setCargando(false);
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.e("Fallo", "No se puede acceder a la api");
                        peliculasViewModel.setCargando(false);
                    }
                });
            }
        });
    }

    private List<PojoPelicula> parseJson(JsonObject listaPeliculas){
        List<PojoPelicula> listaPelis = new ArrayList<>();

        String nombrePeli = listaPeliculas.get("nombre").getAsString();
        String descripcion = listaPeliculas.get("descripcion").getAsString();
        Integer estrellas = listaPeliculas.get("estrellas").getAsInt();
        JsonArray listaActores = listaPeliculas.get("actores").getAsJsonArray();

        List<PojoActor> actoresList = new ArrayList<>();
        for (JsonElement element : listaActores) {
            JsonObject actoresObject = element.getAsJsonObject();
            String url = actoresObject.get("url").getAsString();
            String nombre = actoresObject.get("nombre").getAsString();
            String pelicula = actoresObject.get("pelicula").getAsString();

            PojoActor actor = new PojoActor(url, nombre, pelicula);
            actoresList.add(actor);
        }

        listaPelis.add(new PojoPelicula(nombrePeli,descripcion,estrellas,actoresList));

        return listaPelis;

    }

}