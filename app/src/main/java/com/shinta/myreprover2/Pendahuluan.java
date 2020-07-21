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
import android.widget.Toast;

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

public class Pendahuluan extends AppCompatActivity {
    KompetensiAdapter mAdapterku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendahuluan);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        ListView listViewTentang = (ListView) findViewById(R.id.lvpendahuluan);

        ArrayList<Kompetensi> daftarList = new ArrayList<>();
        daftarList.add(new Kompetensi(R.drawable.pendahuluan_menu1));
        daftarList.add(new Kompetensi(R.drawable.pendahuluan_menu2));
        mAdapterku = new KompetensiAdapter(this,daftarList);

        listViewTentang.setAdapter(mAdapterku);
        setSupportActionBar(toolbarku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.panahbelakang);

        listViewTentang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(getApplicationContext(), Pendahuluanmateri.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 1){
                    Intent myIntent = new Intent(getApplicationContext(), Mindmap.class);
                    startActivityForResult(myIntent, 0);

                } else {
                    Intent myIntent = new Intent(getApplicationContext(), Pendahuluan.class);
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
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }
}
