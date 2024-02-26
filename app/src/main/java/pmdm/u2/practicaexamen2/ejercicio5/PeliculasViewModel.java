package pmdm.u2.practicaexamen2.ejercicio5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PeliculasViewModel extends ViewModel {
    private static final double DELAY = 2000;

    private MutableLiveData<Boolean> cargando;

    public LiveData<Boolean> getCargando() {
        if (cargando == null) {
            cargando = new MutableLiveData<Boolean>();
            setCargando(false);
        }
        return cargando;
    }

    public void setCargando(boolean estado) {
        cargando.setValue(estado);
    }
}
