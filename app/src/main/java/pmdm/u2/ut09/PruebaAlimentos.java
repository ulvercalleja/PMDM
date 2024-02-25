package pmdm.u2.ut09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import pmdm.u2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PruebaAlimentos extends AppCompatActivity {

    private TextView tvAlimentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_alimentos);

        tvAlimentos= findViewById(R.id.apatvAlimentos);
        getAlimentos();
    }

    private void getAlimentos(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RepoAlimentos repoAlimentos = retrofit.create(RepoAlimentos.class);

        Call<List<PojoAlimentos>> call = repoAlimentos.getAlimentos();

        call.enqueue(new Callback<List<PojoAlimentos>>() {
            @Override
            public void onResponse(Call<List<PojoAlimentos>> call, Response<List<PojoAlimentos>> response) {
                if (!response.isSuccessful()){
                    tvAlimentos.setText("Codigo: " + response.code());
                    return;
                }

                List<PojoAlimentos> listaComida = response.body();

                for (PojoAlimentos alimentos: listaComida){
                    String content = "";
                    content += "userId:" + alimentos.getId() + "\n";
                    content += "nombre:" + alimentos.getNombre() + "\n";
                    content += "calorias:" + alimentos.getValorCalorico() + "\n";
                    tvAlimentos.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<PojoAlimentos>> call, Throwable t) {
                tvAlimentos.setText(t.getMessage());
            }
        });
    }
}