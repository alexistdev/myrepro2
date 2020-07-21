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

import java.util.ArrayList;

public class tentang extends AppCompatActivity {
    KompetensiAdapter mAdapterku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        setSupportActionBar(toolbarku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.panahbelakang);

        ListView listViewTentang = (ListView) findViewById(R.id.lvtentang);

        ArrayList<Kompetensi> daftarList = new ArrayList<>();
        daftarList.add(new Kompetensi(R.drawable.tentang_menu1));
        daftarList.add(new Kompetensi(R.drawable.tentang_menu2));
        daftarList.add(new Kompetensi(R.drawable.tentang_menu3));
        daftarList.add(new Kompetensi(R.drawable.tentang_menu4));
        mAdapterku = new KompetensiAdapter(this,daftarList);
        listViewTentang.setAdapter(mAdapterku);

        listViewTentang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
//                    Toast.makeText(getApplicationContext(),
//                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                        .show();
                    Intent myIntent = new Intent(getApplicationContext(), Kompetensiinti.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 1){
                    Intent myIntent = new Intent(getApplicationContext(), Kompetensidasar.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 2){
                    Intent myIntent = new Intent(getApplicationContext(), Tujuan.class);
                    startActivityForResult(myIntent, 0);
                } else if (position == 3){
                    Intent myIntent = new Intent(getApplicationContext(), Referensi.class);
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
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }
}
