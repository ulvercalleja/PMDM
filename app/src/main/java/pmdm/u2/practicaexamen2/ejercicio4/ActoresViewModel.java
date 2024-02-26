package pmdm.u2.practicaexamen2.ejercicio4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import pmdm.u2.practicaexamen2.ejercicio4.api.PeliculasApi;
import pmdm.u2.practicaexamen2.ejercicio4.data.PojoPelicula;

public class ActoresViewModel extends ViewModel {
    private LiveData<PojoPelicula> detalleData;
    private PeliculasApi peliculasRepository;

    public ActoresViewModel() {
        peliculasRepository = PeliculasApi.getInstance();
        detalleData = peliculasRepository.getDetalleLiveData();
    }

    public void getDetalle(String url){
        peliculasRepository.getDetalle(url);
    }

    public LiveData<PojoPelicula> getDetalleData() {
        return detalleData;
    }
}
