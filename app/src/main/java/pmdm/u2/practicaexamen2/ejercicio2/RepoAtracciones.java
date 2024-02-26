package pmdm.u2.practicaexamen2.ejercicio2;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoAtracciones {
    @GET("/api/atracciones/")
    Call<List<PojoAtracciones>> getAtracciones();

    @GET("/api/atracciones/{id}/")
    Call<PojoAtracciones> getComentarios(@Path("id") String id);
}
