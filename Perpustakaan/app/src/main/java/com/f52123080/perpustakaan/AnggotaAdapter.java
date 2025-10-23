package com.f52123080.perpustakaan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.AnggotaViewHolder> {

    private List<Anggota> anggotaList;

    public AnggotaAdapter(List<Anggota> anggotaList) {
        this.anggotaList = anggotaList;
    }

    @NonNull
    @Override
    public AnggotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anggota, parent, false);
        return new AnggotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnggotaViewHolder holder, int position) {
        Anggota anggota = anggotaList.get(position);

        holder.tvNama.setText(anggota.getNama());
        holder.tvEmail.setText("Email: " + anggota.getEmail());
        holder.tvTelepon.setText("Telp: " + anggota.getTelepon());

        if (anggota.getStatus().equals("Aktif")) {
            holder.tvStatus.setText("Aktif");
            holder.tvStatus.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.green));
        } else {
            holder.tvStatus.setText("Non-Aktif");
            holder.tvStatus.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return anggotaList.size();
    }

    public static class AnggotaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvEmail, tvTelepon, tvStatus;

        public AnggotaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvTelepon = itemView.findViewById(R.id.tvTelepon);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}