package pmdm.u2.practicaexamen2.ejercicio3.api;

import androidx.lifecycle.MutableLiveData;

import pmdm.u2.practicaexamen2.ejercicio3.pojo.PojoAtracciones;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtraccionesRepo {
    private static final String API_URL = "http://192.168.56.102:8000/";
    private static AtraccionesRepo instance;
    private RepoAtracciones service;
    private MutableLiveData<List<PojoAtracciones>> atraccionesLiveData;
    private MutableLiveData<PojoAtracciones> detalleLiveData;

    public AtraccionesRepo() {
        atraccionesLiveData = new MutableLiveData<>();
        detalleLiveData = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RepoAtracciones.class);
    }

    public void getDetalle(String id){
        service.getDetalle(id)
                .enqueue(new Callback<PojoAtracciones>() {
                    @Override
                    public void onResponse(Call<PojoAtracciones> call, Response<PojoAtracciones> response) {
                        if (response.body() != null) {
                            detalleLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<PojoAtracciones> call, Throwable t) {
                        detalleLiveData.postValue(null);
                    }
                });
    }

    public void getAtracciones(){
        service.getAtracciones()
                .enqueue(new Callback<List<PojoAtracciones>>() {
                    @Override
                    public void onResponse(Call<List<PojoAtracciones>> call, Response<List<PojoAtracciones>> response) {
                        if (response.body() != null) {
                            List<PojoAtracciones> listaAtracciones = response.body();
                            atraccionesLiveData.postValue(listaAtracciones);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PojoAtracciones>> call, Throwable t) {
                        List<PojoAtracciones> listaAtracciones = new ArrayList<>();
                        atraccionesLiveData.postValue(listaAtracciones);
                    }
                });
    }
    public static AtraccionesRepo getInstance() {
        if (instance == null) {
            instance = new AtraccionesRepo();
        }
        return instance;
    }
    public MutableLiveData<List<PojoAtracciones>> getAtraccionesLiveData() {
        return atraccionesLiveData;
    }

    public MutableLiveData<PojoAtracciones> getDetalleLiveData() {
        return detalleLiveData;
    }
}