package com.f52123080.perpustakaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DaftarAnggotaFragment extends Fragment {

    private RecyclerView rvAnggota;
    private AnggotaAdapter anggotaAdapter;
    private List<Anggota> anggotaList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daftar_anggota, container, false);

        rvAnggota = view.findViewById(R.id.rvAnggota);
        rvAnggota.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Ambil data dari LoginActivity atau inisialisasi default
        initDataAnggota();

        anggotaAdapter = new AnggotaAdapter(anggotaList);
        rvAnggota.setAdapter(anggotaAdapter);

        return view;
    }

    private void initDataAnggota() {
        // Coba ambil data dari LoginActivity
        if (getActivity() instanceof LoginActivity) {
            LoginActivity loginActivity = (LoginActivity) getActivity();
            anggotaList = loginActivity.getAnggotaList();
        } else {
            // Jika tidak ada data dari LoginActivity, gunakan data default
            anggotaList = new ArrayList<>();
            anggotaList.add(new Anggota("A001", "Yesenia", "yesenia@gmail.com", "08123456789"));
            anggotaList.add(new Anggota("A002", "Abdillah", "abdillah@gmail.com", "08123456789"));
            anggotaList.add(new Anggota("A003", "Siti Aminah", "ratu@gmail.com", "08129876543"));
            anggotaList.add(new Anggota("A004", "Budi Santoso", "sakia@gmail.com", "08111222333"));
            anggotaList.add(new Anggota("A005", "Maya Sari", "maya@email.com", "08144555666"));
        }
    }

    // Method untuk refresh data anggota
    public void refreshAnggotaList(List<Anggota> newAnggotaList) {
        this.anggotaList = newAnggotaList;
        if (anggotaAdapter != null) {
            anggotaAdapter.notifyDataSetChanged();
        }
    }
}