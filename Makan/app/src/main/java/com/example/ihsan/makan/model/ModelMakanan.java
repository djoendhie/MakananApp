
package com.example.ihsan.makan.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelMakanan {

    @SerializedName("DataMakanan")
    @Expose
    private List<com.example.ihsan.makan.model.DataMakanan> dataMakanan = null;

    public List<com.example.ihsan.makan.model.DataMakanan> getDataMakanan() {
        return dataMakanan;
    }

    public void setDataMakanan(List<com.example.ihsan.makan.model.DataMakanan> dataMakanan) {
        this.dataMakanan = dataMakanan;
    }

}
