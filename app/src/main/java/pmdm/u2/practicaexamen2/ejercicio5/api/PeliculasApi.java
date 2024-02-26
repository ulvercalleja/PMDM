package pmdm.u2.practicaexamen2.ejercicio5.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasApi {
    private static final String API_URL = "http://192.168.56.102:8000/";
    private static PeliculasApi instancia;
    private static PeliculasRepo API;
    private PeliculasApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API = retrofit.create(PeliculasRepo.class);
    }
    public static PeliculasRepo getAPI(){
        return API;
    }
    public static PeliculasApi getInstancia(){
        if(instancia == null){
            instancia = new PeliculasApi();
        }
        return instancia;
    }
}
