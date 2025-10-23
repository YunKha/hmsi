package com.f52123080.perpustakaan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PeminjamanAdapter extends RecyclerView.Adapter<PeminjamanAdapter.PeminjamanViewHolder> {

    private List<Peminjaman> peminjamanList;

    public PeminjamanAdapter(List<Peminjaman> peminjamanList) {
        this.peminjamanList = peminjamanList;
    }

    @NonNull
    @Override
    public PeminjamanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_peminjaman, parent, false);
        return new PeminjamanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeminjamanViewHolder holder, int position) {
        Peminjaman peminjaman = peminjamanList.get(position);

        holder.tvJudulBuku.setText(peminjaman.getJudulBuku());
        holder.tvNamaAnggota.setText("Oleh: " + peminjaman.getNamaAnggota());
        holder.tvTanggalPinjam.setText("Pinjam: " + peminjaman.getTanggalPinjam());
        holder.tvTanggalKembali.setText("Kembali: " + peminjaman.getTanggalKembali());
        holder.tvStatus.setText(peminjaman.getStatus());

        if (peminjaman.getStatus().equals("Dipinjam")) {
            holder.tvStatus.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.red));
        } else {
            holder.tvStatus.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.green));
        }
    }

    @Override
    public int getItemCount() {
        return peminjamanList.size();
    }

    public static class PeminjamanViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudulBuku, tvNamaAnggota, tvTanggalPinjam, tvTanggalKembali, tvStatus;

        public PeminjamanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudulBuku = itemView.findViewById(R.id.tvJudulBuku);
            tvNamaAnggota = itemView.findViewById(R.id.tvNamaAnggota);
            tvTanggalPinjam = itemView.findViewById(R.id.tvTanggalPinjam);
            tvTanggalKembali = itemView.findViewById(R.id.tvTanggalKembali);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}