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
    private float highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        textViewHighscore = findViewById(R.id.txtNilai);
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
        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                float score = data.getFloatExtra(QuizActivity.EXTRA_SCORE,0);
                if (score > highscore){
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadHighScore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getFloat(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Nilai :" + highscore);
    }

    private void updateHighscore(float highscoreNew){
        highscore = highscoreNew;
        textViewHighscore.setText("Nilai :" + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}
