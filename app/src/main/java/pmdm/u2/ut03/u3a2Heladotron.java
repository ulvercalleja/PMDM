package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pmdm.u2.R;

public class u3a2Heladotron extends AppCompatActivity {
    public static final String INFO_NOMBRE_SPINNER = "spinneropcion";
    public static final String INFO_NOMBRE_VAINILLA = "numvainilla";
    public static final String INFO_NOMBRE_FRESA = "numfresa";
    public static final String INFO_NOMBRE_CHOCOLATE = "numchocolate";
    Spinner spRecipientes;
    EditText etVainilla;
    EditText etFresa;
    EditText etChocolate;
    TextView tvError;
    Button btPedir;
    String opcionSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2_heladotron);

        spRecipientes = findViewById(R.id.u3a2spRecipientes);
        etVainilla = findViewById(R.id.u3a2etVainilla);
        etFresa = findViewById(R.id.u3a2etFresa);
        etChocolate = findViewById(R.id.u3a2etChocolate);
        tvError = findViewById(R.id.u3a2tvError);
        btPedir = findViewById(R.id.u3a2btPedir);

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
                opcionSeleccionada = opciones.get(position);
                // Haz algo con la opción seleccionada
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Si no se selecciona nada
            }
        });

        btPedir.setOnClickListener(view -> {
            String numVainilla = etVainilla.getText().toString();
            String numFresa = etFresa.getText().toString();
            String numChocolate = etChocolate.getText().toString();

            if (numVainilla.isEmpty() && numFresa.isEmpty() && numChocolate.isEmpty()){
                tvError.setText("Por favor, elija al menos una bola.");
            } else {
                if (numVainilla.isEmpty()){
                    numVainilla = "0";
                } else if (numFresa.isEmpty()){
                    numFresa = "0";
                } else if (numChocolate.isEmpty()) {
                    numChocolate = "0";
                }
                // Crear un intent para pasar los datos a la siguiente actividad
                Intent intent = new Intent(u3a2Heladotron.this, u3a2HeladotronP2.class);
                intent.putExtra(INFO_NOMBRE_VAINILLA, numVainilla);
                intent.putExtra(INFO_NOMBRE_FRESA, numFresa);
                intent.putExtra(INFO_NOMBRE_CHOCOLATE, numChocolate);
                intent.putExtra(INFO_NOMBRE_SPINNER, opcionSeleccionada);
                startActivity(intent);
            }
        });

    }
}