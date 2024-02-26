package pmdm.u2.practicaexamen2.ejercicio3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pmdm.u2.practicaexamen2.ejercicio3.pojo.PojoComentarios;
import pmdm.u2.R;

import java.util.ArrayList;
import java.util.List;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentariosViewHolder> {
    List<PojoComentarios> data = new ArrayList<>();

    @NonNull
    @Override
    public ComentariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_comentarios, parent, false);
        return new ComentariosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentariosViewHolder holder, int position) {
        holder.getTexto().setText(data.get(position).getTexto());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setResults(List<PojoComentarios> data){
        this.data = data;
        notifyDataSetChanged();
    }

    class ComentariosViewHolder extends RecyclerView.ViewHolder{
        private TextView texto;
        public ComentariosViewHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.comentarioTexto);
        }
        public TextView getTexto() {
            return texto;
        }
    }
}
