package com.f52123080.perpustakaan;

public class Anggota {
    private String id;
    private String nama;
    private String email;
    private String telepon;
    private String status;

    public Anggota(String id, String nama, String email, String telepon) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.status = "Aktif";
    }

    // Getter dan Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
