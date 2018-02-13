package com.example.ihsan.makan.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ihsan.makan.R;
import com.example.ihsan.makan.adapter.ListMakananAdapter;
import com.example.ihsan.makan.helper.SessionManager;
import com.example.ihsan.makan.model.DataKategori;
import com.example.ihsan.makan.model.DataMakanan;
import com.example.ihsan.makan.model.ModelKategori;
import com.example.ihsan.makan.model.ModelMakanan;
import com.example.ihsan.makan.network.MyRetrofit;
import com.example.ihsan.makan.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MakananActivity extends SessionManager {

    @BindView(R.id.spincarimakanan)
    Spinner spincarimakanan;
    @BindView(R.id.listmakanan)
    RecyclerView listmakanan;
    @BindView(R.id.refreshlayout)
    SwipeRefreshLayout refreshlayout;
    List<DataKategori> listkategori;
    List<DataMakanan> listdatamakanan;
    String strkategorimakanan,striduser;
    RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getdatakategorimakanan();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        manager = new LinearLayoutManager(MakananActivity.this);
        listmakanan.setLayoutManager(manager);
    }

    private void getdatakategorimakanan() {

//        showProgressDialog("precess get");
        RestApi api = MyRetrofit.getInstaceRetrofit();
        Call<ModelKategori> modelMakananCall = api.getkategori();
        modelMakananCall.enqueue(new Callback<ModelKategori>() {
            @Override
            public void onResponse(Call<ModelKategori> call, Response<ModelKategori> response) {
                listkategori = new ArrayList<>();
                listkategori =response.body().getDataKategori();
                String [] idkategori = new String[listkategori.size()];
                String [] namakategori = new String[listkategori.size()];
                for (int i =0;i<listkategori.size();i++){
                    idkategori[i] = listkategori.get(i).getIdKategori().toString();
                    namakategori[i]=listkategori.get(i).getNamaKategori().toString();
                }
                ArrayAdapter adapter = new ArrayAdapter(c,android.R.layout.simple_spinner_item,namakategori);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spincarimakanan.setAdapter(adapter);
                spincarimakanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //cara 1 untuk menampilakan brdasarkan nama
                        strkategorimakanan = parent.getItemAtPosition(position).toString();
                        //tvhargajual.setText("");
                        //cara 2 untuk menampilkan brdasarkan posisi
                        //strnmkota = items[position];

                        getDataMakanan(strkategorimakanan);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });
            }

            @Override
            public void onFailure(Call<ModelKategori> call, Throwable t) {

            }
        });
    }

    private void getDataMakanan(String strkategorimakanan) {
        final ProgressDialog dialog = ProgressDialog.show(MakananActivity.this, "process register user", "harap bersabar");
        String iduser = sessionManager.getIdUser();
        RestApi api = MyRetrofit.getInstaceRetrofit();
        Call<ModelMakanan> modelUserCall = api.getdatamakanan(
                iduser, strkategorimakanan);
        // myToast("iduser" + iduser);
        modelUserCall.enqueue(new Callback<ModelMakanan>() {
            @Override
            public void onResponse(Call<ModelMakanan> call, Response<ModelMakanan> response) {
                dialog.dismiss();
                //hideProgressDialog();
                listdatamakanan = response.body().getDataMakanan();
                String[] id_makanan = new String[listdatamakanan.size()];
                String[] namamakanan = new String[listdatamakanan.size()];
                String[] fotomakanan = new String[listdatamakanan.size()];
                for (int i = 0; i < listdatamakanan.size(); i++) {
                    namamakanan[i] = listdatamakanan.get(i).getMakanan().toString();
                    fotomakanan[i] = listdatamakanan.get(i).getFotoMakanan().toString();
                    id_makanan[i] = listdatamakanan.get(i).getIdMakanan().toString();
                    striduser = id_makanan[i];
                }
                ListMakananAdapter adapter = new ListMakananAdapter(c, listdatamakanan);
                listmakanan.setAdapter(adapter);
                //  adapter.setOnClick(MakananActivity.this);
            }

            @Override
            public void onFailure(Call<ModelMakanan> call, Throwable t) {
                dialog.dismiss();
                myToast(t.getMessage());
            }
        });

    }

}
