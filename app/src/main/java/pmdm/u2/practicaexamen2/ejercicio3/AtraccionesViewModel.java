package pmdm.u2.practicaexamen2.ejercicio3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import pmdm.u2.practicaexamen2.ejercicio3.api.AtraccionesRepo;
import pmdm.u2.practicaexamen2.ejercicio3.pojo.PojoAtracciones;

import java.util.List;

public class AtraccionesViewModel extends ViewModel {
    private LiveData<List<PojoAtracciones>> listaData;
    private LiveData<PojoAtracciones> detalleData;
    private AtraccionesRepo repository = AtraccionesRepo.getInstance();
    public void getAtracciones() {
        repository.getAtracciones();
    }

    public void getDetalle(String id) {
        repository.getDetalle(id);
    }

    public LiveData<List<PojoAtracciones>> getListaData() {
        if (listaData == null) {
            listaData = repository.getAtraccionesLiveData();
        }
        return listaData;
    }

    public LiveData<PojoAtracciones> getDetalleData() {
        if (detalleData == null) {
            detalleData = repository.getDetalleLiveData();
        }
        return detalleData;
    }
}