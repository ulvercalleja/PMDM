package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pmdm.u2.R;

public class u3a2Heladotron extends AppCompatActivity {
    Spinner spRecipientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2_heladotron);

        spRecipientes = findViewById(R.id.u3a2spRecipientes);

        List<String> opciones = new ArrayList<>();
        opciones.add("Cucurucho");
        opciones.add("Cucurucho de chocolate");
        opciones.add("Tarrina");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRecipientes.setAdapter(adapter);

        spRecipientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String opcionSeleccionada = opciones.get(position);
                // Haz algo con la opción seleccionada
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Si no se selecciona nada
            }
        });

    }
}