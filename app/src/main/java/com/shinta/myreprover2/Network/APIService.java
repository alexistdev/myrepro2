package com.shinta.myreprover2.Network;

import com.shinta.myreprover2.config.Constants;
import com.shinta.myreprover2.model.MessageModel;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {


    @Multipart
    @POST("API/nilai.php")
    Call<MessageModel> postTambahNilai(@Part("idUser") RequestBody idUser,
                                      @Part("nilai") RequestBody nilai);

    @Multipart
    @POST("API/tambah.php")
    Call<MessageModel> postTambahUser(@Part("nis") RequestBody nis,
                                   @Part("nama") RequestBody nama);

    @Multipart
    @POST("API/jawaban.php")
    Call<MessageModel> postTambahJawaban(@Part("idUser") RequestBody idUser,
                                      @Part("nomorSoal") RequestBody nomorSoal,
                                      @Part("jawaban") RequestBody jawaban);

    class Factory{
        public static APIService create(){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.connectTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);
        }
    }
}
