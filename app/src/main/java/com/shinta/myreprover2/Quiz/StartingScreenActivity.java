package com.shinta.myreprover2.Quiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shinta.myreprover2.R;

public class StartingScreenActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ  = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private TextView textViewHighscore;
    private String nis;
    private float highscore = 0;
    public float score = 0;
    public String nilaiAkhir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);
        nis = getIntent().getStringExtra("nis");
        textViewHighscore = findViewById(R.id.txtNilai);
        try{
            loadHighScore();
            if(highscore != 0){
                Button buttonMulai = findViewById(R.id.btnStartQuiz);
                buttonMulai.setEnabled(false);
                Toast.makeText(this, "Anda sudah pernah mengikuti ujian sebelumnya", Toast.LENGTH_SHORT).show();
            } else {
                Button buttonMulai = findViewById(R.id.btnStartQuiz);
                buttonMulai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mulaiQuis();
                    }
                });
            }
        }
            catch(Exception e){
                e.printStackTrace();
                pesanException(e.getMessage());
        }
    }

    private void mulaiQuis(){
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //jika sudah pernah mengikuti ujian
        super.onActivityResult(requestCode, resultCode, data);
        Button buttonMulai = findViewById(R.id.btnStartQuiz);
        buttonMulai.setEnabled(false);
        try{
            if(requestCode == REQUEST_CODE_QUIZ){
                if(resultCode == RESULT_OK){
                    score = data.getFloatExtra(QuizActivity.EXTRA_SCORE,0);
                    if (score > highscore){
                        perbaharuiNilai(score);
                    }
                }
            }
        }
            catch(Exception e){
                e.printStackTrace();
                pesanException(e.getMessage());
        }
    }
    private void loadHighScore(){
        try{
            SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            highscore = prefs.getFloat(KEY_HIGHSCORE, 0);
            nilaiAkhir = String.valueOf(highscore);
            textViewHighscore.setText("Nilai :" + nilaiAkhir);
        }
            catch(Exception e){
                e.printStackTrace();
                pesanException(e.getMessage());
        }
    }

    //memperbaharui score yang tampil
    private void perbaharuiNilai(float highscoreNew){
        try{
            highscore = highscoreNew;
            nilaiAkhir = String.valueOf(highscore);
            textViewHighscore.setText("Nilai :" + nilaiAkhir);
            SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(KEY_HIGHSCORE, highscore);
            editor.apply();
        }
            catch(Exception e) {
                e.printStackTrace();
                pesanException(e.getMessage());
        }
    }
    //menampilkan pesan error
    private void pesanException(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
