package pmdm.u2.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class u8a0AleatorioPrimoViewModel extends ViewModel {
    private static final double DELAY = 500;
    private static final double MAX_NUM = 10000;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero(){
        if(misDatos == null){
            misDatos = new MutableLiveData<Integer>();

        }
        return misDatos;
    }

    public void cargaNumero(int num1, int num2) {
        new Thread(
                ()->{
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        int i = num1 + num2;
                        misDatos.postValue(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();
    }
}
