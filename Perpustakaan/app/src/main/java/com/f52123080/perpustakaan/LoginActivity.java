package com.f52123080.perpustakaan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvSignUp; // ganti dari btnBuatAkun menjadi tvSignUp
    private List<User> userList;
    private List<Anggota> anggotaList;
    private User currentUser;
    private int anggotaCounter = 6; // Counter untuk ID anggota baru

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi elemen tampilan
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp); // TextView "Sign Up"

        // Inisialisasi daftar user dan anggota
        userList = new ArrayList<>();
        anggotaList = new ArrayList<>();

        // Tambahkan user default dan anggotanya
        userList.add(new User("admin", "admin123"));
        initDataAnggotaDefault();

        // Tombol login ditekan
        btnLogin.setOnClickListener(v -> loginUser());

        // Teks Sign Up ditekan
        tvSignUp.setOnClickListener(v -> showBuatAkunDialog());
    }

    private void initDataAnggotaDefault() {
        // Data anggota default
        anggotaList.add(new Anggota("A001", "admin", "admin@email.com", "08123456789"));
        anggotaList.add(new Anggota("A002", "Abdillah", "abdillah@email.com", "08123456789"));
        anggotaList.add(new Anggota("A003", "Siti Aminah", "siti@email.com", "08129876543"));
        anggotaList.add(new Anggota("A004", "Budi Santoso", "budi@email.com", "08111222333"));
        anggotaList.add(new Anggota("A005", "Maya Sari", "maya@email.com", "08144555666"));
    }

    private void loginUser() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean userFound = false;
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                userFound = true;
                currentUser = user;
                break;
            }
        }

        if (userFound) {
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }

    private void showBuatAkunDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Buat Akun Baru");

        // Input form
        final EditText inputUsername = new EditText(this);
        inputUsername.setHint("Username");

        final EditText inputPassword = new EditText(this);
        inputPassword.setHint("Password");
        inputPassword.setInputType(android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);

        final EditText inputEmail = new EditText(this);
        inputEmail.setHint("Email");
        inputEmail.setInputType(android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        final EditText inputTelepon = new EditText(this);
        inputTelepon.setHint("Nomor Telepon");
        inputTelepon.setInputType(android.text.InputType.TYPE_CLASS_PHONE);

        // Layout untuk dialog
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 0, 50, 0);
        layout.addView(inputUsername);
        layout.addView(inputPassword);
        layout.addView(inputEmail);
        layout.addView(inputTelepon);
        builder.setView(layout);

        // Tombol dialog
        builder.setPositiveButton("Buat Akun", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newUsername = inputUsername.getText().toString().trim();
                String newPassword = inputPassword.getText().toString().trim();
                String newEmail = inputEmail.getText().toString().trim();
                String newTelepon = inputTelepon.getText().toString().trim();

                if (newUsername.isEmpty() || newPassword.isEmpty() ||
                        newEmail.isEmpty() || newTelepon.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean usernameExists = false;
                for (User user : userList) {
                    if (user.getUsername().equals(newUsername)) {
                        usernameExists = true;
                        break;
                    }
                }

                if (usernameExists) {
                    Toast.makeText(LoginActivity.this,
                            "Username sudah digunakan", Toast.LENGTH_SHORT).show();
                } else {
                    // Buat user baru
                    User newUser = new User(newUsername, newPassword);
                    userList.add(newUser);

                    // Buat anggota baru otomatis
                    String newAnggotaId = "A" + String.format("%03d", anggotaCounter);
                    Anggota newAnggota = new Anggota(newAnggotaId, newUsername, newEmail, newTelepon);
                    anggotaList.add(newAnggota);
                    anggotaCounter++;

                    // Simpan data anggota
                    saveAnggotaToFragment(newAnggota);

                    Toast.makeText(LoginActivity.this,
                            "Akun berhasil dibuat! Silakan login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Batal", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    private void saveAnggotaToFragment(Anggota anggota) {
        Toast.makeText(this,
                "Anggota " + anggota.getNama() + " berhasil ditambahkan", Toast.LENGTH_SHORT).show();
    }

    public List<Anggota> getAnggotaList() {
        return anggotaList;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
