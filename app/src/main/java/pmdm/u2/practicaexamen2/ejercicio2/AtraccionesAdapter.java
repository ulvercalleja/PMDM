package pmdm.u2.practicaexamen2.ejercicio2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pmdm.u2.R;

public class AtraccionesAdapter extends RecyclerView.Adapter<AtraccionesAdapter.ViewHolder>{
    private static final String INFO_OCUPACION = "ocupacion";
    private static final String INFO_DESCRIPCION = "descripcion";
    private static final String INFO_COMENTARIOS = "comentario";
    private List<PojoAtracciones> listaAtracciones;
    private Context context;

    public AtraccionesAdapter(List<PojoAtracciones> listaAtracciones, Context context){
        this.listaAtracciones = listaAtracciones;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNombre;
        private final Button btDetalles;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.per2tvNombre);
            btDetalles = itemView.findViewById(R.id.per2btDetalles);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.practica_examen_ejercicio2_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PojoAtracciones atraccion = listaAtracciones.get(position);
        viewHolder.tvNombre.setText(atraccion.getNombre());

        viewHolder.btDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetallesAtracciones.class);
            intent.putExtra(INFO_OCUPACION, atraccion.getOcupantes());
            intent.putExtra(INFO_DESCRIPCION, atraccion.getDescripcion());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaAtracciones.size();
    }
}
