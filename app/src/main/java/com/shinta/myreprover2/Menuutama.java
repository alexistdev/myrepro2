package com.shinta.myreprover2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shinta.myreprover2.API.SignupActivity;
import com.shinta.myreprover2.Quiz.QuizActivity;
import com.shinta.myreprover2.Quiz.StartingScreenActivity;

public class Menuutama extends AppCompatActivity {
    //KompetensiAdapter mAdapterku;
    CardView pendahuluan,materi,tentang,evaluasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuutama);
        pendahuluan= findViewById(R.id.cpendahuluan);
        materi= findViewById(R.id.cmateri);
        tentang= findViewById(R.id.ctentang);
        evaluasi = findViewById(R.id.cevaluasi);

        pendahuluan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenku = new Intent(getApplicationContext(),Pendahuluan.class);
                startActivity(intenku);
            }
        });
        materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenku = new Intent(getApplicationContext(),Materi.class);
                startActivity(intenku);
            }
        });
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenku = new Intent(getApplicationContext(),tentang.class);
                startActivity(intenku);
            }
        });
        evaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenku = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intenku);
            }
        });
    }
}
