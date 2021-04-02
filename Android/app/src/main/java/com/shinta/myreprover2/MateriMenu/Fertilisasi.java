package com.shinta.myreprover2.MateriMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;


import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Toast;


import com.shinta.myreprover2.Materi;
import com.shinta.myreprover2.Menuutama;
import com.shinta.myreprover2.Mindmap;
import com.shinta.myreprover2.R;


public class Fertilisasi extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilisasi);
        Toolbar toolbarku = findViewById(R.id.toolbarku);

        setSupportActionBar(toolbarku);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.panahbelakang);

       //youtube video
        mWebView= findViewById(R.id.videoview);
        String videoStr = "<html><body>Video Youtube<br><iframe width=\"300\" height=\"250\" src=\"https://www.youtube.com/embed/_VqRFtaWLWM\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        mWebView.loadData(videoStr, "text/html", "utf-8");

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
            Intent myIntent = new Intent(getApplicationContext(), Materi.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        return true;
    }
}
