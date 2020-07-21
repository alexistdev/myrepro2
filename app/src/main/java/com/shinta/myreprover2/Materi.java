package com.shinta.myreprover2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shinta.myreprover2.MateriMenu.Airsusu;
import com.shinta.myreprover2.MateriMenu.Fertilisasi;
import com.shinta.myreprover2.MateriMenu.Gametogenesis;
import com.shinta.myreprover2.MateriMenu.Gangguanreproduksi;
import com.shinta.myreprover2.MateriMenu.Hormonreproduksi;
import com.shinta.myreprover2.MateriMenu.Kehamilan;
import com.shinta.myreprover2.MateriMenu.Keluargaberencana;
import com.shinta.myreprover2.MateriMenu.Kesehatan;
import com.shinta.myreprover2.MateriMenu.Materipertama;
import com.shinta.myreprover2.MateriMenu.Menstruasi;
import com.shinta.myreprover2.MateriMenu.Organreproduksi;
import com.shinta.myreprover2.MateriMenu.Steaming;

import java.util.ArrayList;

public class Materi extends AppCompatActivity {
    KompetensiAdapter mAdapterku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        ListView listViewTentang = (ListView) findViewById(R.id.lvmateri);

        setSupportActionBar(toolbarku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.panahbelakang);

        ArrayList<Kompetensi> daftarList = new ArrayList<>();
        daftarList.add(new Kompetensi(R.drawable.menu_materi0));
        daftarList.add(new Kompetensi(R.drawable.menu_materi1));
        daftarList.add(new Kompetensi(R.drawable.menu_materi2));
        daftarList.add(new Kompetensi(R.drawable.menu_materi3));
        daftarList.add(new Kompetensi(R.drawable.menu_materifertilisasi));
        daftarList.add(new Kompetensi(R.drawable.menu_materi4));
        daftarList.add(new Kompetensi(R.drawable.menu_materi5));
        daftarList.add(new Kompetensi(R.drawable.menu_materi6));
        daftarList.add(new Kompetensi(R.drawable.menu_materi7));
        daftarList.add(new Kompetensi(R.drawable.menu_materi8));
        daftarList.add(new Kompetensi(R.drawable.menu_kesehatan));
        daftarList.add(new Kompetensi(R.drawable.menu_steaming));
        mAdapterku = new KompetensiAdapter(this,daftarList);
        listViewTentang.setAdapter(mAdapterku);
        //menangani klik menu materi
        listViewTentang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(getApplicationContext(), Materipertama.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 1){
                    Intent myIntent = new Intent(getApplicationContext(), Organreproduksi.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 2){
                    Intent myIntent = new Intent(getApplicationContext(), Gametogenesis.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 3){
                    Intent myIntent = new Intent(getApplicationContext(), Menstruasi.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 4){
                    Intent myIntent = new Intent(getApplicationContext(), Fertilisasi.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 5){
                    Intent myIntent = new Intent(getApplicationContext(), Kehamilan.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 6){
                    Intent myIntent = new Intent(getApplicationContext(), Hormonreproduksi.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 7){
                    Intent myIntent = new Intent(getApplicationContext(), Gangguanreproduksi.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 8){
                    Intent myIntent = new Intent(getApplicationContext(), Keluargaberencana.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 9){
                    Intent myIntent = new Intent(getApplicationContext(), Airsusu.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 10){
                    Intent myIntent = new Intent(getApplicationContext(), Kesehatan.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 11){
                    Intent myIntent = new Intent(getApplicationContext(), Steaming.class);
                    startActivityForResult(myIntent, 0);
                } else {
                    Intent myIntent = new Intent(getApplicationContext(), Menuutama.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
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
            Intent myIntent = new Intent(getApplicationContext(), Menuutama.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        return true;
    }
}
