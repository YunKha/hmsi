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

public class PeminjamanFragment extends Fragment {

    private RecyclerView rvPeminjaman;
    private PeminjamanAdapter peminjamanAdapter;
    private List<Peminjaman> peminjamanList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peminjaman, container, false);

        rvPeminjaman = view.findViewById(R.id.rvPeminjaman);
        rvPeminjaman.setLayoutManager(new LinearLayoutManager(getActivity()));

        initDataPeminjaman();

        peminjamanAdapter = new PeminjamanAdapter(peminjamanList);
        rvPeminjaman.setAdapter(peminjamanAdapter);

        return view;
    }

    private void initDataPeminjaman() {
        peminjamanList = new ArrayList<>();
        peminjamanList.add(new Peminjaman("P001", "B001", "Pemrograman Android",
                "A001", "Abdillah", "2024-01-15", "2024-01-22"));
        peminjamanList.add(new Peminjaman("P002", "B002", "Java Programming",
                "A002", "Siti Aminah", "2024-01-16", "2024-01-23"));
        peminjamanList.add(new Peminjaman("P003", "B003", "Android Development",
                "A003", "Budi Santoso", "2024-01-17", "2024-01-24"));
    }
}