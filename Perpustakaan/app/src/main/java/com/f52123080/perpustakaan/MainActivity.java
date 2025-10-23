package com.f52123080.perpustakaan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private List<Anggota> anggotaListFromLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Load fragment default
        loadFragment(new DaftarBukuFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;

            if (item.getItemId() == R.id.nav_buku) {
                fragment = new DaftarBukuFragment();
            } else if (item.getItemId() == R.id.nav_anggota) {
                DaftarAnggotaFragment anggotaFragment = new DaftarAnggotaFragment();
                fragment = anggotaFragment;
            } else if (item.getItemId() == R.id.nav_peminjaman) {
                fragment = new PeminjamanFragment();
            }

            if (fragment != null) {
                loadFragment(fragment);
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // Method untuk set data anggota dari LoginActivity
    public void setAnggotaList(List<Anggota> anggotaList) {
        this.anggotaListFromLogin = anggotaList;
    }
}