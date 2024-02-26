package pmdm.u2.practicaexamen2.ejercicio5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pmdm.u2.R;
import pmdm.u2.practicaexamen2.ejercicio5.pojo.PojoPelicula;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ViewHolder>{

    private ArrayList<PojoPelicula> datosPeliculas;
    private OnItemClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView descripcion;
        private final TextView estrellas;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.NombrePelicula);
            descripcion = (TextView) view.findViewById(R.id.Descripcion);
            estrellas = (TextView) view.findViewById(R.id.Estrellas);
        }

        public TextView getNombrePeliculas() {
            return nombre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }
        public TextView getEstrellas() {
            return estrellas;
        }

    }

    public PeliculasAdapter(List<PojoPelicula> dataSet) {
        datosPeliculas = new ArrayList<PojoPelicula>();
        add(dataSet);
    }
    public interface OnItemClickListener {
        void onItemClick(PojoPelicula pelicula);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PeliculasAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_peliculas, viewGroup, false);

        return new PeliculasAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PeliculasAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getNombrePeliculas().setText("Nombre: " + datosPeliculas.get(position).getNombre().toString());
        viewHolder.getDescripcion().setText("Descripcion: " + datosPeliculas.get(position).getDescripcion().toString());
        viewHolder.getEstrellas().setText("Estrellas: " + datosPeliculas.get(position).getEstrellas().toString());

        PojoPelicula pelicula = datosPeliculas.get(position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(pelicula);
                }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datosPeliculas.size();
    }

    public void add(List<PojoPelicula> dataSet) {
        datosPeliculas.addAll(dataSet);
        notifyDataSetChanged();
    }

}
