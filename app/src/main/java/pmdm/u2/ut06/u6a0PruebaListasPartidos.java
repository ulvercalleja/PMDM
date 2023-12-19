package pmdm.u2.ut06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pmdm.u2.R;

public class u6a0PruebaListasPartidos extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Button add;
    u6a0PartidoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut06_prueba_listas_partidos);

        reyclerViewUser = (RecyclerView) findViewById(R.id.u6a0ListaContenedor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new u6a0PartidoAdapter(u6a0Partido.generatePartidos(u6a0Partido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.u6a0ListaAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(u6a0Partido.generatePartidos(u6a0Partido.PARTIDOS_INICIALES));
            }
        });
    }
}