package pmdm.u2.ut06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import pmdm.u2.R;

public class u6a0DulceAdapter extends RecyclerView.Adapter<u6a0DulceAdapter.ViewHolder> {

    private ArrayList<u6a0Dulce> listaDulces;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView dulces;
        private final TextView frutosSecos;
        private final TextView calorias;

        public ViewHolder(View view) {
            super(view);
            dulces = (TextView) view.findViewById(R.id.u6a0ListaDulce);
            frutosSecos = (TextView) view.findViewById(R.id.u6a0ListaFrutosSecos);
            calorias = (TextView) view.findViewById(R.id.u6a0ListaCalorias);
        }

        public TextView getTextDulces() {
            return dulces;
        }
        public TextView getTextFrutosSecos() {
            return frutosSecos;
        }
        public TextView getTextCalorias() {
            return calorias;
        }
    }

    public u6a0DulceAdapter(u6a0Dulce[] dataSet) {
        listaDulces = new ArrayList<u6a0Dulce>();
        add(dataSet);
    }

    @Override
    public u6a0DulceAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_dulce, viewGroup, false);

        return new u6a0DulceAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getTextDulces().setText(listaDulces.get(position).dulce);
        viewHolder.getTextFrutosSecos().setText(listaDulces.get(position).frutosSecos);
        viewHolder.getTextCalorias().setText(listaDulces.get(position).calorias);
    }

    @Override
    public int getItemCount() {
        return listaDulces.size();
    }

    public void add(u6a0Dulce[] dataSet){
        listaDulces.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
