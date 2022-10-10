package com.ascendant.kopilancong.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {
    @SerializedName("status")
    @Expose
    String status;

    @SerializedName("id_setting")
    @Expose
    String id_setting;

    @SerializedName("nama_setting")
    @Expose
    String nama_setting;

    @SerializedName("isi_setting")
    @Expose
    String isi_setting;

    @SerializedName("id_user")
    @Expose
    String id_user;

    @SerializedName("email_user")
    @Expose
    String email_user;

    @SerializedName("nama_user")
    @Expose
    String nama_user;

    @SerializedName("level")
    @Expose
    String level;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("access_token")
    @Expose
    String access_token;

    @SerializedName("code")
    @Expose
    Integer code;


    @SerializedName("data")
    @Expose
    DataModel data;

    @SerializedName("id_transaksi")
    @Expose
    public String id_transaksi;

    @SerializedName("id_toko")
    @Expose
    public String id_toko;

    @SerializedName("total_harga")
    @Expose
    public String total_harga;

    @SerializedName("modal_transaksi")
    @Expose
    public String modal_transaksi;

    @SerializedName("pembayaran")
    @Expose
    public String pembayaran;

    @SerializedName("kembalian")
    @Expose
    public String kembalian;

    @SerializedName("waktu_transaksi")
    @Expose
    public String waktu_transaksi;



    @SerializedName("id_product_kategori")
    @Expose
    public String id_product_kategori;

    @SerializedName("nama_product")
    @Expose
    public String nama_product;

    @SerializedName("deskripsi_product")
    @Expose
    public String deskripsi_product;

    @SerializedName("quantity")
    @Expose
    public String quantity;


    @SerializedName("img_product")
    @Expose
    public String img_product;


    @SerializedName("harga_product")
    @Expose
    public String harga_product;


    @SerializedName("potongan_harga")
    @Expose
    public String potongan_harga;

    @SerializedName("modal_product")
    @Expose
    public String modal_product;

    @SerializedName("status_product")
    @Expose
    public String status_product;


    @SerializedName("nama")
    @Expose
    public String nama;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("jenis_kelamin")
    @Expose
    public String jenis_kelamin;

    @SerializedName("password")
    @Expose
    public String password;

    @SerializedName("kontak")
    @Expose
    public String kontak;

    @SerializedName("photo")
    @Expose
    public String photo;


    @SerializedName("id_notice")
    @Expose
    public String id_notice;


    @SerializedName("title_notice")
    @Expose
    public String title_notice;


    @SerializedName("category_notice")
    @Expose
    public String category_notice;

    @SerializedName("notice")
    @Expose
    public String notice;

    @SerializedName("image_notice")
    @Expose
    public String image_notice;

    @SerializedName("tanggal_notice")
    @Expose
    public String tanggal_notice;

    @SerializedName("id_product")
    @Expose
    public String id_product;

    @SerializedName("gambar")
    @Expose
    public String gambar;

    @SerializedName("price")
    @Expose
    public String price;

    @SerializedName("stock")
    @Expose
    public String stock;

    @SerializedName("isi")
    @Expose
    List<DataModel> isi;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_setting() {
        return id_setting;
    }

    public void setId_setting(String id_setting) {
        this.id_setting = id_setting;
    }

    public String getNama_setting() {
        return nama_setting;
    }

    public void setNama_setting(String nama_setting) {
        this.nama_setting = nama_setting;
    }

    public String getIsi_setting() {
        return isi_setting;
    }

    public void setIsi_setting(String isi_setting) {
        this.isi_setting = isi_setting;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_toko() {
        return id_toko;
    }

    public void setId_toko(String id_toko) {
        this.id_toko = id_toko;
    }

    public String getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(String total_harga) {
        this.total_harga = total_harga;
    }

    public String getModal_transaksi() {
        return modal_transaksi;
    }

    public void setModal_transaksi(String modal_transaksi) {
        this.modal_transaksi = modal_transaksi;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getKembalian() {
        return kembalian;
    }

    public void setKembalian(String kembalian) {
        this.kembalian = kembalian;
    }

    public String getWaktu_transaksi() {
        return waktu_transaksi;
    }

    public void setWaktu_transaksi(String waktu_transaksi) {
        this.waktu_transaksi = waktu_transaksi;
    }

    public String getId_product_kategori() {
        return id_product_kategori;
    }

    public void setId_product_kategori(String id_product_kategori) {
        this.id_product_kategori = id_product_kategori;
    }

    public String getNama_product() {
        return nama_product;
    }

    public void setNama_product(String nama_product) {
        this.nama_product = nama_product;
    }

    public String getDeskripsi_product() {
        return deskripsi_product;
    }

    public void setDeskripsi_product(String deskripsi_product) {
        this.deskripsi_product = deskripsi_product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImg_product() {
        return img_product;
    }

    public void setImg_product(String img_product) {
        this.img_product = img_product;
    }

    public String getHarga_product() {
        return harga_product;
    }

    public void setHarga_product(String harga_product) {
        this.harga_product = harga_product;
    }

    public String getPotongan_harga() {
        return potongan_harga;
    }

    public void setPotongan_harga(String potongan_harga) {
        this.potongan_harga = potongan_harga;
    }

    public String getModal_product() {
        return modal_product;
    }

    public void setModal_product(String modal_product) {
        this.modal_product = modal_product;
    }

    public String getStatus_product() {
        return status_product;
    }

    public void setStatus_product(String status_product) {
        this.status_product = status_product;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId_notice() {
        return id_notice;
    }

    public void setId_notice(String id_notice) {
        this.id_notice = id_notice;
    }

    public String getTitle_notice() {
        return title_notice;
    }

    public void setTitle_notice(String title_notice) {
        this.title_notice = title_notice;
    }

    public String getCategory_notice() {
        return category_notice;
    }

    public void setCategory_notice(String category_notice) {
        this.category_notice = category_notice;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getImage_notice() {
        return image_notice;
    }

    public void setImage_notice(String image_notice) {
        this.image_notice = image_notice;
    }

    public String getTanggal_notice() {
        return tanggal_notice;
    }

    public void setTanggal_notice(String tanggal_notice) {
        this.tanggal_notice = tanggal_notice;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public List<DataModel> getIsi() {
        return isi;
    }

    public void setIsi(List<DataModel> isi) {
        this.isi = isi;
    }
}
