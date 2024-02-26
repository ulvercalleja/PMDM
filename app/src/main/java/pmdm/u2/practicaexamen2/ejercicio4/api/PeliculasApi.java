package pmdm.u2.practicaexamen2.ejercicio4.api;

import androidx.lifecycle.MutableLiveData;

import pmdm.u2.practicaexamen2.ejercicio4.data.PojoPelicula;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasApi {
    private static final String API_URL = "http://192.168.56.102:8000/";
    private static PeliculasApi instance;
    private PeliculasRepo service;
    private MutableLiveData<List<PojoPelicula>> peliculasLiveData;
    private MutableLiveData<PojoPelicula> detalleLiveData;

    public PeliculasApi() {
        peliculasLiveData = new MutableLiveData<>();

        detalleLiveData = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PeliculasRepo.class);
    }

    public static PeliculasApi getInstance() {
        if (instance == null) {
            instance = new PeliculasApi();
        }
        return instance;
    }

    public void getPeliculas() {
        service.getPeliculas()
                .enqueue(new Callback<List<PojoPelicula>>() {
                    @Override
                    public void onResponse(Call<List<PojoPelicula>> call, Response<List<PojoPelicula>> response) {
                        List<PojoPelicula> listaPeliculas = response.body();
                        peliculasLiveData.postValue(listaPeliculas);
                    }

                    @Override
                    public void onFailure(Call<List<PojoPelicula>> call, Throwable t) {
                        peliculasLiveData.postValue(new ArrayList<>());
                    }
                });
    }

    public void getDetalle(String url) {
        service.getDetalle(url)
                .enqueue(new Callback<PojoPelicula>() {
                    @Override
                    public void onResponse(Call<PojoPelicula> call, Response<PojoPelicula> response) {
                        detalleLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<PojoPelicula> call, Throwable t) {
                        detalleLiveData.postValue(null);
                    }
                });
    }

    public MutableLiveData<PojoPelicula> getDetalleLiveData() {
        return detalleLiveData;
    }

    public MutableLiveData<List<PojoPelicula>> getPeliculasLiveData() {
        return peliculasLiveData;
    }
}
