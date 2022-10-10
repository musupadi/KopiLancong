package com.ascendant.kopilancong.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseObject {
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


    @SerializedName("data")
    @Expose
    DataModel data;

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

    public List<DataModel> getIsi() {
        return isi;
    }

    public void setIsi(List<DataModel> isi) {
        this.isi = isi;
    }
}
