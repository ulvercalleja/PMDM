package pmdm.u2.practicaexamen2.ejercicio1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pmdm.u2.R;

public class AtraccionesAdapter extends RecyclerView.Adapter<AtraccionesAdapter.ViewHolder>{
    private List<PojoAtracciones> listaAtracciones;
    private Context context;

    public AtraccionesAdapter(List<PojoAtracciones> listaAtracciones, Context context){
        this.listaAtracciones = listaAtracciones;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNombre;
        private final TextView tvDescripcion;
        private final TextView tvOcupantes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.rtvNombre);
            tvDescripcion = itemView.findViewById(R.id.rtvDescripcion);
            tvOcupantes = itemView.findViewById(R.id.rtvOcupantes);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.practica_examen_ejercicio1_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PojoAtracciones atraccion = listaAtracciones.get(position);
        viewHolder.tvNombre.setText(atraccion.getNombre());
        viewHolder.tvDescripcion.setText(atraccion.getDescripcion());
        viewHolder.tvOcupantes.setText(String.valueOf(atraccion.getOcupantes()));
    }

    @Override
    public int getItemCount() {
        return listaAtracciones.size();
    }
}
