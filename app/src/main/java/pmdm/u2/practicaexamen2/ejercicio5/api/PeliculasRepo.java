package pmdm.u2.practicaexamen2.ejercicio5.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeliculasRepo {
    @GET("/api/peliculas_related/{id}")
    Call<JsonObject> getPelicula(@Path("id") int id);
}
