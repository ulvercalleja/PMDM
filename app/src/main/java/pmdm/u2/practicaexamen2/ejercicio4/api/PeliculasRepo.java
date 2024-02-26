package pmdm.u2.practicaexamen2.ejercicio4.api;

import pmdm.u2.practicaexamen2.ejercicio4.data.PojoPelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PeliculasRepo {
    @GET("/api/peliculas/")
    Call<List<PojoPelicula>> getPeliculas();
    @GET
    Call<PojoPelicula> getDetalle(@Url String url);
}
