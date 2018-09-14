package com.rifafauzi.example.favoritemovie;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFavoriteActivity extends AppCompatActivity {

    String img, judul, desc, tgl;
    ImageView tvImg;
    TextView tvJudul, tvDesc, tvTgl;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favorite);

        tvImg = findViewById(R.id.poster);
        tvJudul = findViewById(R.id.judul);
        tvDesc = findViewById(R.id.desc);
        tvTgl = findViewById(R.id.tgl);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);


        setMovie();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Detail Movie");
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setMovie(){
        img = getIntent().getStringExtra("poster_path");
        judul = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("overview");
        tgl = getIntent().getStringExtra("release_date");

        Picasso.with(getApplicationContext())
                .load(img)
                .placeholder(R.drawable.loading)
                .into(tvImg);
        tvJudul.setText(judul);
        tvDesc.setText(desc);
        tvTgl.setText(tgl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
