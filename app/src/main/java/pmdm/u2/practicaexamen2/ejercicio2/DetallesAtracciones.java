package pmdm.u2.practicaexamen2.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import pmdm.u2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallesAtracciones extends AppCompatActivity {
    private static final String INFO_OCUPACION = "ocupacion";
    private static final String INFO_DESCRIPCION = "descripcion";
    private TextView tvDetalleOcupacion;
    private TextView tvDetalleDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_examen_detalles_atracciones);

        tvDetalleOcupacion = findViewById(R.id.pedatvDetalleOcupacion);
        tvDetalleDescripcion = findViewById(R.id.pedatvDetalleDescripcion);

        int ocupacion = getIntent().getIntExtra(INFO_OCUPACION, 0);
        String descripcion = getIntent().getStringExtra(INFO_DESCRIPCION);

        // Establecer los datos en los TextViews
        tvDetalleOcupacion.setText("Ocupacion: " + ocupacion);
        tvDetalleDescripcion.setText(descripcion);
    }

}