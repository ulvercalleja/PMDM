package pmdm.u2.practicaexamen2.ejercicio2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class AtraccionesViewModel extends ViewModel {
    private MutableLiveData<Integer> misDatos;
    private final int DELAY=1000;
    private final int MAX_NUM=10000;

    public LiveData<Integer> getAtraccion(){
        if(misDatos==null){
            misDatos=new MutableLiveData<Integer>();
            cargaAtraccion();
        }
        return misDatos;
    }

    public void cargaAtraccion() {
        Random random = new Random();
        new Thread(()->{
            try {
                Thread.sleep((long)(Math.random()*DELAY)+DELAY);
                int i=random.nextInt(MAX_NUM);
                misDatos.postValue(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
