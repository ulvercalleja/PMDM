package pmdm.u2.practicaexamen2.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import pmdm.u2.R;
import pmdm.u2.practicaexamen2.ejercicio3.AtraccionesActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallesAtracciones extends AppCompatActivity {
    private TextView tvDetalleOcupacion;
    private TextView tvDetalleDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_examen_detalles_atracciones);

        tvDetalleOcupacion = findViewById(R.id.pedatvDetalleOcupacion);
        tvDetalleDescripcion = findViewById(R.id.pedatvDetalleDescripcion);

        int ocupacion = getIntent().getIntExtra(AtraccionesAdapter.INFO_OCUPACION, 0);
        String descripcion = getIntent().getStringExtra(AtraccionesAdapter.INFO_DESCRIPCION);

        // Establecer los datos en los TextViews
        tvDetalleOcupacion.setText("Ocupacion: " + ocupacion);
        tvDetalleDescripcion.setText(descripcion);
    }

}