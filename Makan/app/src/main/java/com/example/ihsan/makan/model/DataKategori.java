
package com.example.ihsan.makan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataKategori {

    @SerializedName("id_kategori")
    @Expose
    private String idKategori;
    @SerializedName("nama_kategori")
    @Expose
    private String namaKategori;

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

}
