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

public class Tujuan extends AppCompatActivity {
    ListView listViewDasar;
    String[] menuTujuan = {
            "Setelah mengikuti kegiatan pembelajaran diharapkan siswa mampu :",
            "A. Menganalisis fungsi dari setiap organ reproduksi pria maupun wanita.",
            "B. Membedakan organ reproduksi luar dan dalam baik pria maupun wanita.",
            "C. Mendeskripsikan proses pembentukan sperma (spermatogenesis) dan sel telur (oogenesis) berdasarkan gambar.",
            "D. Menganalisis siklus menstruasi serta hormon yang berperan di dalamnya.",
            "E. Menganalisis terjadinya fertilisasi, kehamilan dan persalinan.",
            "F. Mengidentifikasi dan mengevaluasi asumsi fertilisasi, kehamilan dan persalinan.",
            "G. Menganalisis asumsi ASI dan KB.",
            "H. Mengidentifikasi dan mengevaluasi asumsi ASI dan KB.",
            "I. Menganalisis penyebab terjadinya kelianan atau penyakit sistem reproduksi.",
            "J. Mengidentifikasi kelainan atau penyakit sistem reproduksi.",
            "K. Menganalisis asumsi kesehatan reproduksi.",
            "L. Mengevaluasi dan mengidentifikasi asumsi kesehatan reproduksi."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tujuan);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        listViewDasar = (ListView) findViewById(R.id.lvtujuan);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,menuTujuan);
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
