package pmdm.u2.practicaexamen2.ejercicio4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import pmdm.u2.practicaexamen2.ejercicio4.api.PeliculasApi;
import pmdm.u2.practicaexamen2.ejercicio4.data.PojoPelicula;

import java.util.List;

public class PeliculasViewModel extends ViewModel {
    private LiveData<List<PojoPelicula>> peliculasData;
    private PeliculasApi peliculasRepository;

    public PeliculasViewModel() {
        peliculasRepository = PeliculasApi.getInstance();
        peliculasData = peliculasRepository.getPeliculasLiveData();
    }

    public void getLista(){
        peliculasRepository.getPeliculas();
    }

    public LiveData<List<PojoPelicula>> getPeliculasData() {
        return peliculasData;
    }
}
