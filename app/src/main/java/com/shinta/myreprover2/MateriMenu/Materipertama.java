package com.shinta.myreprover2.MateriMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.shinta.myreprover2.Materi;
import com.shinta.myreprover2.Menuutama;
import com.shinta.myreprover2.Mindmap;
import com.shinta.myreprover2.R;

public class Materipertama extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materipertama);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
//        String SistemReproduksi = "Reproduksi merupakan suatu upaya makhluk hidup untuk mempertahankan jenisnya sehingga jenisnya tidak punah. Reproduksi adalah kemmapuan organisme untuk menghasilkan organisme yang sifatnya sama persis dengan induknya ataupun  gabungan sifat dari kedua induknya. Sistem reproduksi adalah sistem yang berperan dalam menghasilkan gamet fungsional pada tubuh. Reproduksi menggambarkan pembuatan telur, sperma dan proses-proses yang menyertainya samapai pembuahan (fertilisasi). Sistem reproduksi terdiri dari organ seks primer atau gonad (testis pada pria dan ovarium pada wanita) yang mengekspresikan hormon dan menghasilkan gamet (sperma dan telur). Selain itu juga ada organ seks sekunder berupa kelenjar dan saluran-saluran.";
//        textView.setText(SistemReproduksi);

        setSupportActionBar(toolbarku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.panahbelakang);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    //Untuk menangani tombol klik di toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.beranda){
            Intent myIntent = new Intent(getApplicationContext(), Menuutama.class);
            startActivityForResult(myIntent, 0);
            finish();
        } else if (id == R.id.exit){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Intent myIntent = new Intent(getApplicationContext(), Materi.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        return true;
    }
}
