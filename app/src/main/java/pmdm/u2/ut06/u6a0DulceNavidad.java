package pmdm.u2.ut06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pmdm.u2.R;

public class u6a0DulceNavidad extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button addDulce;
    u6a0DulceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u6a0_dulce_navidad);

        reyclerViewUser = (RecyclerView) findViewById(R.id.u6a0ListaContenedor);
        addDulce = findViewById(R.id.u6a0ListaAdd);
        adapter = new u6a0DulceAdapter(u6a0Dulce.generateDulces(u6a0Dulce.DULCES_INICIALES));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        reyclerViewUser.setAdapter(adapter);

        addDulce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(u6a0Dulce.generateDulces(u6a0Dulce.DULCES_INICIALES));
            }
        });
    }
}