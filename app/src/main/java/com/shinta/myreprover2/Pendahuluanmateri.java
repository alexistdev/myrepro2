package com.shinta.myreprover2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Pendahuluanmateri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendahuluanmateri);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        setSupportActionBar(toolbarku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.panahbelakang);



    }
    //membuat tombol setting muncul di navbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //Untuk menangani tombol klik di toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.setting){
            Toast.makeText(getApplicationContext(),"Anda klik dibagi", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.tentang_kita){
            Toast.makeText(getApplicationContext(),"Anda klik tentang kita", Toast.LENGTH_SHORT).show();
        } else {
            Intent myIntent = new Intent(getApplicationContext(), Pendahuluan.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        return true;
    }
}
