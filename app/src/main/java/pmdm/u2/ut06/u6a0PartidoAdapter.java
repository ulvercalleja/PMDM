package pmdm.u2.ut06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import pmdm.u2.R;

import java.util.ArrayList;
import java.util.Arrays;
public class u6a0PartidoAdapter extends RecyclerView.Adapter<u6a0PartidoAdapter.ViewHolder> {
    private ArrayList<u6a0Partido> datos;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView partido;
        private final TextView resultado;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            partido = (TextView) view.findViewById(R.id.u6a0ListaNombre);
            resultado = (TextView) view.findViewById(R.id.u6a0ListaResultado);
        }

        public TextView getTextPartido() {
            return partido;
        }

        public TextView getTextResultado() {
            return resultado;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public u6a0PartidoAdapter(u6a0Partido[] dataSet) {
        datos = new ArrayList<u6a0Partido>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_partido, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextPartido().setText(datos.get(position).local + " vs " + datos.get(position).visitante);
        viewHolder.getTextResultado().setText(datos.get(position).resultado);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(u6a0Partido[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}