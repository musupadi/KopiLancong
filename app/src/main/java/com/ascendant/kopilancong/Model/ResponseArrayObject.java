package com.ascendant.kopilancong.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseArrayObject {
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
    List<DataModel> data;

    @SerializedName("isi")
    @Expose
    List<DataModel> isi;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
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
}
