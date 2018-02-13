package com.example.ihsan.makan.network;

import com.example.ihsan.makan.model.ModelKategori;
import com.example.ihsan.makan.model.ModelMakanan;
import com.example.ihsan.makan.model.ModelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by iswandisaputra on 2/13/18.
 */

public interface RestApi {

    @FormUrlEncoded
    @POST("registeruser.php/")
    Call<ModelUser> registerUser(
            @Field("vsnama") String strnama,
            @Field("vsalamat") String stralamat,
            @Field("vsnotelp") String strnotelp,
            @Field("vsjenkel") String strjenkel,
            @Field("vsusername") String strusername,
            @Field("vspassword") String strpassword,
            @Field("vslevel") String strlevel
    );
    @FormUrlEncoded
    @POST("loginuser.php/")
    Call<ModelUser> loginuser(
            @Field("edtusername") String strusername,
            @Field("edtpassword") String strpassword,
            @Field("vslevel") String strlevel
    );
    @GET("ambildataCarikategorimakanan.php/")
    Call<ModelKategori>getkategori();

    @FormUrlEncoded
    @POST("getdatamakanan.php/")
    Call<ModelMakanan> getdatamakanan(
            @Field("vsiduser") String striduser,
            @Field("vsidkastrkategorimakanan") String strkartmakaan
    );

}
