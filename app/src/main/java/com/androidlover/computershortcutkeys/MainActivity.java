package com.androidlover.computershortcutkeys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView basic,microsoftwindows,excel,word,win,outlook,notepadplus,paint,photoshop,illustrator;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-5348647911544430~9445339167" );
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        basic=(CardView)findViewById(R.id.basic);
        microsoftwindows=(CardView)findViewById(R.id.microsoftwindows);
        excel=(CardView)findViewById(R.id.excel);
        word=(CardView)findViewById(R.id.word);
        win=(CardView)findViewById(R.id.win);
        outlook=(CardView)findViewById(R.id.outlook);
        notepadplus=(CardView)findViewById(R.id.notepadplus);
        paint=(CardView)findViewById(R.id.paint);
        photoshop=(CardView)findViewById(R.id.photoshop);
        illustrator=(CardView)findViewById(R.id.illustrator);

        basic.setOnClickListener(this);
        microsoftwindows.setOnClickListener(this);
        excel.setOnClickListener(this);
        word.setOnClickListener(this);
        win.setOnClickListener(this);
        outlook.setOnClickListener(this);
        notepadplus.setOnClickListener(this);
        paint.setOnClickListener(this);
        photoshop.setOnClickListener(this);
        illustrator.setOnClickListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.about_us){
            Intent i=new Intent(MainActivity.this,About_Us.class);
            startActivity(i);
            return true;
        }
        if (id==R.id.rate_us){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(i);
            } catch (Exception e) {
                Toast.makeText(this, "Unable to open", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        if(id==R.id.share)
            {
                Intent shareintent=new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent,"Share Via"));
                return true;
            }
        return true;

    }


    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.basic : i = new Intent(this,basic.class);startActivity(i); break;
            case R.id.microsoftwindows : i = new Intent(this,microsoftwindows.class);startActivity(i); break;
            case R.id.excel : i = new Intent(this,excel.class);startActivity(i); break;
            case R.id.word : i = new Intent(this,word.class);startActivity(i); break;
            case R.id.win : i = new Intent(this,win.class);startActivity(i); break;
            case R.id.outlook : i = new Intent(this,outlook.class);startActivity(i); break;
            case R.id.notepadplus : i = new Intent(this,notepadplus.class);startActivity(i); break;
            case R.id.paint : i = new Intent(this,Paint.class);startActivity(i); break;
            case R.id.photoshop : i = new Intent(this,Photoshop.class);startActivity(i); break;
            case R.id.illustrator : i = new Intent(this,illustrator.class);startActivity(i); break;

            default:break;



        }
    }




















}