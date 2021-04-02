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

public class Kompetensiinti extends AppCompatActivity {
    ListView listViewDasar;
    String[] menuInti = {
            "1. Menghayati dan mengamalkan ajaran agama yang dianutnya.",
            "2. Menghayati dan mengamalkan perilaku jujur, disiplin, tanggung jawab, peduli (gotong royong, kerjasama, toleran, damai) santun, responsif dan pro-aktif dan menunjukkan sikap sebagian dari solusi atas berbagai permasalahan dalam berinteraksi secara efektif dengan lingkungan sosial dan alam serta menempatkan diri sebagai cerminan bangsa dalam pergaulan dunia.",
            "3. Memahami, menerapkan, menganalisis konsep faktual, konseptual, prosedural berdasarkan rasa ingin tahu tentang ilmu pengetahuan, teknologi, seni, budaya, dan humaniora dengan wawasan kemanusiaan, kenegaraan dan peradaban terkait penyebab fenomena dan kejadian serta menerapkan pengetahuan procedural pada bidang kajian yang spesifik yang sesuai dengan bakat dan minatnya untuk memecahkan masalah.",
            "4. Mengolah, menalar, menyaji, dalam ranah konkret dan ranah abstrak terkait dengan pengembangan dari yang dipelajarinya di sekolah secara mandiri dan mampu menggunakan metode sesuai kaidah keiilmuan."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensiinti);
        Toolbar toolbarku = findViewById(R.id.toolbarku);
        listViewDasar = (ListView) findViewById(R.id.lvmenuinti);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,menuInti);
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
            Intent myIntent = new Intent(getApplicationContext(), tentang.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        return true;
    }
}
