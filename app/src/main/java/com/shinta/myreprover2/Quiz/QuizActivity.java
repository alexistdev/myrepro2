package com.shinta.myreprover2.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shinta.myreprover2.R;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE  = "extraScore";
    //3 menit timer
    private static final long COUNTDOWN_IN_MILLIS = 180000;

    private ImageView gambarPertanyaan;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private Button buttonConfirmNext;
    private long backPressedTime;


    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Pertanyaan> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Pertanyaan currentQuestion;

    private float score;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        //gambar pertanyaan

        gambarPertanyaan= findViewById(R.id.gbrPertanyaan);

        textViewQuestion = findViewById(R.id.txtPertanyaan);
        textViewScore = findViewById(R.id.txtNilai);
        textViewQuestionCount = findViewById(R.id.txtPertanyaanCount);
        textViewCountDown = findViewById(R.id.txtWaktu);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radioPilihan1);
        rb2 = findViewById(R.id.radioPilihan2);
        rb3 = findViewById(R.id.radioPilihan3);
        rb4= findViewById(R.id.radioPilihan4);
        rb5= findViewById(R.id.radioPilihan5);
        buttonConfirmNext = findViewById(R.id.btnSimpan);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList =  dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);


        //menampilkan pertanyaan berupa gambar
        //checkStatusPertanyaan();
        //gambarPertanyaan.setVisibility(View.VISIBLE);
        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked() || rb5.isChecked()){
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Silahkan pilih jawaban terlebih dahulu", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }
    private void tampilkanSoal()
    {
        String uri = currentQuestion.getQuestion();
        Resources resources = getResources();
        int resourceId = resources.getIdentifier( uri,
                "drawable", getPackageName());
        gambarPertanyaan.setImageResource(resourceId);
    }

    private void checkStatusPertanyaan()
    {
        currentQuestion = questionList.get(questionCounter);
        int statusPr = currentQuestion.getStatusPr();
        if (statusPr == 1){
            gambarPertanyaan.setVisibility(View.VISIBLE);
            textViewQuestion.setVisibility(View.GONE);
            tampilkanSoal();
        } else if(statusPr == 2) {
            gambarPertanyaan.setVisibility(View.GONE);
            textViewQuestion.setVisibility(View.VISIBLE);
            textViewQuestion.setText(Html.fromHtml(currentQuestion.getQuestion()));
        } else {
            gambarPertanyaan.setVisibility(View.VISIBLE);
            textViewQuestion.setVisibility(View.VISIBLE);
            tampilkanSoal();
            textViewQuestion.setText(Html.fromHtml((currentQuestion.getQuestion2())));
        }
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rb5.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {


            //menampilkan pertanyaan berupa gambar
//            currentQuestion = questionList.get(questionCounter);
//            int statusPr = currentQuestion.getStatusPr();
//            if (statusPr == 1){
//                gambarPertanyaan.setVisibility(View.VISIBLE);
//                textViewQuestion.setVisibility(View.GONE);
//                //jika benar gambar
//                //pertanyaan gambar
//                String uri = currentQuestion.getQuestion();
//                Resources resources = getResources();
//                int resourceId = resources.getIdentifier( uri,
//                        "drawable", getPackageName());
//                gambarPertanyaan.setImageResource(resourceId);
//            } else {
//                gambarPertanyaan.setVisibility(View.GONE);
//                textViewQuestion.setVisibility(View.VISIBLE);
//                textViewQuestion.setText(currentQuestion.getQuestion());
//            }

            checkStatusPertanyaan();
            //textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            rb5.setText(currentQuestion.getOption5());

            questionCounter++;
            textViewQuestionCount.setText("Pertanyaan: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Simpan");

            //untuk timer
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }
    //mengupdate text pada timer
    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis/ 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000){
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    //mengecek jawaban
    private void checkAnswer() {
        answered = true;
        //jika hasil ditampilkan maka timer dipause
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score += (100/2);
            textViewScore.setText("Nilai : " + score);
        }

        showSolution();
    }
    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        rb5.setTextColor(Color.RED);
        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                //textViewQuestion.setText("Jawaban A adalah benar");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                //textViewQuestion.setText("Jawaban B adalah benar");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                //textViewQuestion.setText("Jawaban C adalah benar");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                //textViewQuestion.setText("Jawaban D adalah benar");
                break;
            case 5:
                rb5.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Selanjutnya");

        } else {
            buttonConfirmNext.setText("SELESAI");
        }

    }
    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    //mengecek tombol back
    @Override
    public void onBackPressed(){
        //jika kita tekan back dibawah 2 detik maka akan ditutup
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
        } else {
            Toast.makeText(this, "Tekan back lagi untuk finish", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}
