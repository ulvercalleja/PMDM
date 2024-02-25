package pmdm.u2.practicaexamen2.ejercicio1;

import java.util.List;

import pmdm.u2.ut09.PojoAlimentos;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoEjercicio1 {
    @GET("/api/atracciones/")
    Call<List<PojoAtracciones>> getAtracciones();

}
