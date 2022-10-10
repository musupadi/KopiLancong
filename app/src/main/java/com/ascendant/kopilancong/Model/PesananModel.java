package com.ascendant.kopilancong.Model;

public class PesananModel {
    String id_product,gambar,nama,harga,jumlah;

    public PesananModel() {

    }
    public PesananModel(String id_product,String gambar,String nama,String harga,String jumlah){
        this.id_product=id_product;
        this.gambar=gambar;
        this.nama=nama;
        this.harga=harga;
        this.jumlah=jumlah;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
}
