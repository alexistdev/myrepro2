package com.shinta.myreprover2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shinta.myreprover2.MateriMenu.Materipertama;

public class landingpage extends AppCompatActivity {
    TextView tvgetStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);
        tvgetStart = (TextView)findViewById(R.id.tv_getstart);

        // function intent
        tvgetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogin = new Intent(getApplicationContext(), Menuutama.class);
                startActivity(iLogin);
                finish();
            }
        });
    }
}
