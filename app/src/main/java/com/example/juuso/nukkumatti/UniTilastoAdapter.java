package com.example.juuso.nukkumatti;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juuso.nukkumatti.db.UniTilasto;

import java.util.ArrayList;
import java.util.List;

public class UniTilastoAdapter extends RecyclerView.Adapter<UniTilastoAdapter.UnitilastoHolder> {
    private List<UniTilasto> uniTilastos = new ArrayList<>();

    @NonNull
    @Override
    public UnitilastoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.unilista_item, parent, false);
        return new UnitilastoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitilastoHolder holder, int position) {
        UniTilasto  currentUniTilasto = uniTilastos.get(position);
        holder.textViewPvm.setText(currentUniTilasto.getPvm());
        holder.textViewTunnit.setText(String.valueOf(currentUniTilasto.getTunnit()));
        holder.textViewFiilis.setText((currentUniTilasto.getFiilis()));
    }

    @Override
    public int getItemCount() {
        return uniTilastos.size();
    }

    public void setUniTilastos(List<UniTilasto> uniTilastos) {
        this.uniTilastos = uniTilastos;
        notifyDataSetChanged();
    }

    class UnitilastoHolder extends RecyclerView.ViewHolder {
        private TextView textViewPvm;
        private TextView textViewTunnit;
        private TextView textViewFiilis;

        public UnitilastoHolder(View itemView) {
            super(itemView);

            textViewPvm = itemView.findViewById(R.id.textView_pvm);
            textViewTunnit = itemView.findViewById(R.id.textView_tunnit);
            textViewFiilis = itemView.findViewById(R.id.textView_fiilis);
        }
    }
}
