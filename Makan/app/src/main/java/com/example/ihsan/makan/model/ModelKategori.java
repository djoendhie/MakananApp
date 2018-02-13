
package com.example.ihsan.makan.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelKategori {

    @SerializedName("DataKategori")
    @Expose
    private List<com.example.ihsan.makan.model.DataKategori> dataKategori = null;

    public List<com.example.ihsan.makan.model.DataKategori> getDataKategori() {
        return dataKategori;
    }

    public void setDataKategori(List<com.example.ihsan.makan.model.DataKategori> dataKategori) {
        this.dataKategori = dataKategori;
    }

}
