package com.shinta.myreprover2.API;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    private static final int REQUEST_CODE_QUIZ  = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private float highscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dapatkanHighscore();
        if(highscore !=0){
            Intent intenku = new Intent(getApplicationContext(), StartingScreenActivity.class);
            intenku.putExtra("nis",123);
            startActivityForResult(intenku,REQUEST_CODE_QUIZ);
        } else{
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences( this);
            String daftar = sp.getString("daftar","");
            if(daftar != null){
                if(daftar.equals("")){
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
                } else {
                    Intent intenku = new Intent(getApplicationContext(), StartingScreenActivity.class);
                    intenku.putExtra("nis",123);
                    startActivityForResult(intenku,REQUEST_CODE_QUIZ);
                }
            }
        }
    }

    private void dapatkanHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getFloat(KEY_HIGHSCORE, 0);
    }

    private void initData() {
        etNis = findViewById(R.id.etnis);
        etNama = findViewById(R.id.etnama);
        buttonSimpan = findViewById(R.id.btnSimpan);
        txtInfo = findViewById(R.id.txtInfo);
    }

    private void saveDataPegawai() {
        final String nis = etNis.getText().toString();
        final String nama = etNama.getText().toString();

        if(nis.equals("") || nama.equals("")){
            Toast.makeText(this, "Silahkan lengkapi terlebih dahulu data yang dibutuhkan", Toast.LENGTH_SHORT).show();
        } else{
            progressDialog = ProgressDialog.show(SignupActivity.this, "", "Loading.....", true, false);
            RequestBody requestBodyNis = RequestBody.create(MediaType.parse("text/plain"),nis);
            RequestBody requestBodyNama = RequestBody.create(MediaType.parse("text/plain"), nama);
            //memanggil API untuk tambah user
            try{
                Call<MessageModel> call = APIService.Factory.create().postTambahUser(requestBodyNis,
                        requestBodyNama);
                call.enqueue(new Callback<MessageModel>() {
                    @Override
                    public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                        progressDialog.dismiss();
                        String statusku = response.body().getStatus();
                        if(statusku !=null){
                            if(statusku.equals(getString(R.string.daftar5))){
                                String idUserku = response.body().getIdUser();
                                if(idUserku != null){
                                    if(idUserku.equals("")){
                                        Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Intent intenku = new Intent(getApplicationContext(), StartingScreenActivity.class);
                                        //memasukkan data iduser ke session
                                        pernahRegistrasi(idUserku, nama);
                                        startActivity(intenku);
                                    }
                                }
                            } else {
                                Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MessageModel> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
                catch (Exception e){
                    e.printStackTrace();
                    pesanException(e.getMessage());
            }
        }
    }

    private void pernahRegistrasi(String idUser, String nama){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences( this);
        SharedPreferences.Editor editor = sp.edit();
        String daftar = "completed";
        String idUserku = idUser;
        String namaku = nama;
        editor.putString("idUserku", idUserku);
        editor.putString("namaku", namaku);
        editor.putString("daftar", daftar);
        editor.apply();
    }

    private void pesanException(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
