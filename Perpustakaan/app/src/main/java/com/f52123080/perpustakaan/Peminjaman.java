package com.f52123080.perpustakaan;

public class Peminjaman {
    private String id;
    private String idBuku;
    private String judulBuku;
    private String idAnggota;
    private String namaAnggota;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String status;

    public Peminjaman(String id, String idBuku, String judulBuku, String idAnggota,
                      String namaAnggota, String tanggalPinjam, String tanggalKembali) {
        this.id = id;
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status = "Dipinjam";
    }

    // Getter dan Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdBuku() { return idBuku; }
    public void setIdBuku(String idBuku) { this.idBuku = idBuku; }

    public String getJudulBuku() { return judulBuku; }
    public void setJudulBuku(String judulBuku) { this.judulBuku = judulBuku; }

    public String getIdAnggota() { return idAnggota; }
    public void setIdAnggota(String idAnggota) { this.idAnggota = idAnggota; }

    public String getNamaAnggota() { return namaAnggota; }
    public void setNamaAnggota(String namaAnggota) { this.namaAnggota = namaAnggota; }

    public String getTanggalPinjam() { return tanggalPinjam; }
    public void setTanggalPinjam(String tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }

    public String getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(String tanggalKembali) { this.tanggalKembali = tanggalKembali; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}