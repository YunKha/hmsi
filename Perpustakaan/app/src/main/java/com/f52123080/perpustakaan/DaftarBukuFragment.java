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

public class DaftarBukuFragment extends Fragment {

    private RecyclerView rvBuku;
    private BukuAdapter bukuAdapter;
    private List<Buku> bukuList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daftar_buku, container, false);

        rvBuku = view.findViewById(R.id.rvBuku);
        rvBuku.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inisialisasi data dummy
        initData();

        bukuAdapter = new BukuAdapter(bukuList);
        rvBuku.setAdapter(bukuAdapter);

        return view;
    }

    private void initData() {
        bukuList = new ArrayList<>();
        bukuList.add(new Buku("1", "Pemrograman Android", "John Doe", "2023"));
        bukuList.add(new Buku("2", "Java Programming", "Jane Smith", "2022"));
        bukuList.add(new Buku("3", "Android Development", "Bob Wilson", "2023"));
        bukuList.add(new Buku("4", "OOP Concepts", "Alice Brown", "2021"));
        bukuList.add(new Buku("5", "Mobile App Design", "Charlie Davis", "2023"));
    }
}
