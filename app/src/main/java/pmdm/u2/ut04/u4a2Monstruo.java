package pmdm.u2.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import pmdm.u2.R;
import pmdm.u2.ut03.u3a8Monstruo;

public class u4a2Monstruo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etNombre, etExtremidades, etColor;
    TextView tvError;
    Button btCrear;
    u4f2Monstruo monstruo1, monstruo2, monstruo3, monstruo4;
    Spinner spMonstruo;
    String monstruoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a2_monstruo);

        etNombre = findViewById(R.id.u4a2etNombre);
        etExtremidades = findViewById(R.id.u4a2etExtremidades);
        etColor = findViewById(R.id.u4a2etColor);
        btCrear = findViewById(R.id.u4a2btCrear);
        spMonstruo = findViewById(R.id.ut4a2idspMonstruo);
        tvError = findViewById(R.id.u4a2tvError);
        monstruo1 = (u4f2Monstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo1);
        monstruo2 = (u4f2Monstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo2);
        monstruo3 = (u4f2Monstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo3);
        monstruo4 = (u4f2Monstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo4);

        btCrear.setOnClickListener(view -> {
            try{
                String nombre = etNombre.getText().toString();
                String color = etColor.getText().toString();
                String etExtrem = etExtremidades.getText().toString();
                int extremidades = Integer.parseInt(etExtrem);

                // Creación de un objeto u3a8Monstruo
                u3a8Monstruo miMonstruo = new u3a8Monstruo(nombre, extremidades, color);

                // Actualización del fragmento seleccionado con los datos del monstruo
                if (monstruoSeleccionado.equals("Monstruo 1")) {
                    monstruo1.setText(miMonstruo.toString());
                    monstruo1.setColor(color);
                    tvError.setText("");
                } else if (monstruoSeleccionado.equals("Monstruo 2")) {
                    monstruo2.setText(miMonstruo.toString());
                    monstruo2.setColor(color);
                    tvError.setText("");
                } else if (monstruoSeleccionado.equals("Monstruo 3")) {
                    monstruo3.setText(miMonstruo.toString());
                    monstruo3.setColor(color);
                    tvError.setText("");
                } else if (monstruoSeleccionado.equals("Monstruo 4")) {
                    monstruo4.setText(miMonstruo.toString());
                    monstruo4.setColor(color);
                    tvError.setText("");
                }
            }catch (Exception e){
                tvError.setText("Hay campos vacios.");
            }
        });

        // Configuración del Spinner
        spMonstruo.setOnItemSelectedListener(this);
        String[] monstruos = {"Monstruo 1", "Monstruo 2", "Monstruo 3", "Monstruo 4"};

        // Crear un ArrayAdapter para el Spinner
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, monstruos);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMonstruo.setAdapter(ad);

    }

    // Método invocado cuando se selecciona un elemento en el Spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        monstruoSeleccionado = spMonstruo.getItemAtPosition(i).toString();
    }

    // Método invocado cuando no hay elementos seleccionados en el Spinner
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}