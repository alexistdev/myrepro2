package com.shinta.myreprover2.API;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shinta.myreprover2.Network.APIService;
import com.shinta.myreprover2.Quiz.StartingScreenActivity;
import com.shinta.myreprover2.R;
import com.shinta.myreprover2.model.MessageModel;
import com.shinta.myreprover2.model.UserModel;


import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText etNis;
    private EditText etNama;
    private Button buttonSimpan;
    private TextView txtInfo;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initData();

        //tampilkan informasi
        txtInfo.setText(Html.fromHtml("HARAP DIBACA!!:<br>- Kerjakan 30 soal ini dalam waktu 90 menit<br>- Berdoalah dahulu sebelum memulai<br>- Dilarang mencontek<br>- Jika anda back/kembali ke halaman depan maka nilai tidak akan dihitung<br><br>Selamat Mengerjakan!"));

        try {
            buttonSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveDataPegawai();
                }
            });
        }
            catch (Exception e){
                e.printStackTrace();
                pesanException(e.getMessage());
        }

    }

    private void initData() {
        etNis = findViewById(R.id.etnis);
        etNama = findViewById(R.id.etnama);
        buttonSimpan = findViewById(R.id.btnSimpan);
        txtInfo = findViewById(R.id.txtInfo);
    }
    private void saveDataPegawai() {
        final String nis = etNis.getText().toString();
        String nama = etNama.getText().toString();

        if(nis.equals("") || nama.equals("")){
            Toast.makeText(this, "Silahkan lengkapi terlebih dahulu data yang dibutuhkan", Toast.LENGTH_SHORT).show();
        } else{
            progressDialog = ProgressDialog.show(SignupActivity.this, "", "Menyimpan.....", true, false);
            RequestBody requestBodyNis = RequestBody.create(MediaType.parse("text/plain"),nis);
            RequestBody requestBodyNama = RequestBody.create(MediaType.parse("text/plain"), nama);

            //memanggil API untuk tambah user
            Call<MessageModel> call = APIService.Factory.create().postTambahUser(requestBodyNis,
                    requestBodyNama);


            call.enqueue(new Callback<MessageModel>() {
                @Override
                public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                    progressDialog.dismiss();
                    //Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intenku = new Intent(getApplicationContext(), StartingScreenActivity.class);
                    intenku.putExtra("nis",nis);
                    startActivityForResult(intenku,1);
                }

                @Override
                public void onFailure(Call<MessageModel> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
    private void pesanException(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
