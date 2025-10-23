package com.f52123080.perpustakaan;

public class Buku {
    private String id;
    private String judul;
    private String penulis;
    private String tahunTerbit;
    private boolean statusPinjam;

    // Constructor
    public Buku(String id, String judul, String penulis, String tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.statusPinjam = false;
    }

    // Getter dan Setter (Encapsulation)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }

    public String getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(String tahunTerbit) { this.tahunTerbit = tahunTerbit; }

    public boolean isStatusPinjam() { return statusPinjam; }
    public void setStatusPinjam(boolean statusPinjam) { this.statusPinjam = statusPinjam; }
}
