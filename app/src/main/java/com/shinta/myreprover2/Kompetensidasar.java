package com.shinta.myreprover2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Kompetensidasar extends AppCompatActivity {
    ListView listViewDasar;
    String[] menuDasar = {
            "3.12 Menganalisis hubungan antara struktur jaringan penyusun organ reproduksi dengan fungsinya dalam proses reproduksi manusia melalui studi literatur, pengamatan, percobaan dan simulasi.",
            "3.13 Menerapkan pemahaman tentang prinsip reproduksi manusia untuk menanggulangi pertambahan penduduk melalui program keluarga berencana (KB) dan peningkatan kualitas hidup SDM melalui pemberian ASI ekslusif.",
            "4.12 Menyajikan hasil analisis tentang kelainan pada struktur dan fungsi organ yang menyebabkan gangguan sistem reproduksi manusia melalui berbagai bentuk media presentasi"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensidasar);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        listViewDasar = (ListView) findViewById(R.id.lvmenudasar);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,menuDasar);
        listViewDasar.setAdapter(adapter);
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
            Intent myIntent = new Intent(getApplicationContext(), tentang.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        return true;
    }
}
