package pmdm.u2.practicaexamen2.ejercicio3.api;

import pmdm.u2.practicaexamen2.ejercicio3.pojo.PojoAtracciones;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoAtracciones {
    @GET("api/atracciones/")
    Call<List<PojoAtracciones>> getAtracciones();

    @GET("api/atracciones/{id}/")
    Call<PojoAtracciones> getDetalle(@Path("id") String id);

}