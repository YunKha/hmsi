package com.f52123080.perpustakaan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {

    private List<Buku> bukuList;

    // Constructor
    public BukuAdapter(List<Buku> bukuList) {
        this.bukuList = bukuList;
    }

    @NonNull
    @Override
    public BukuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_buku, parent, false);
        return new BukuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BukuViewHolder holder, int position) {
        Buku buku = bukuList.get(position);

        holder.tvJudul.setText(buku.getJudul());
        holder.tvPenulis.setText("Oleh: " + buku.getPenulis());
        holder.tvTahun.setText("Tahun: " + buku.getTahunTerbit());

        if (buku.isStatusPinjam()) {
            holder.tvStatus.setText("Dipinjam");
            holder.tvStatus.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.red));
        } else {
            holder.tvStatus.setText("Tersedia");
            holder.tvStatus.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.green));
        }
    }

    @Override
    public int getItemCount() {
        return bukuList.size();
    }

    // ViewHolder class
    public static class BukuViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPenulis, tvTahun, tvStatus;

        public BukuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            tvTahun = itemView.findViewById(R.id.tvTahun);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
