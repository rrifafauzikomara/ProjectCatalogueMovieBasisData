package com.rifafauzi.example.projectcataloguemoviebasisdata.Category;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rifafauzi.example.projectcataloguemoviebasisdata.Adapter.FavoriteAdapter;
import com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract;
import com.rifafauzi.example.projectcataloguemoviebasisdata.MainActivity;
import com.rifafauzi.example.projectcataloguemoviebasisdata.R;

import java.util.Objects;

import static android.provider.BaseColumns._ID;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView rvMovies;
    private FavoriteAdapter adapter;
    private Cursor listFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        rvMovies = findViewById(R.id.rv_movies);

        listFavorite = getApplicationContext().getContentResolver().query(DatabaseContract.CONTENT_URI,null,null,null,_ID + " DESC" );

        adapter = new FavoriteAdapter(getApplicationContext(), listFavorite);
        adapter.notifyDataSetChanged();

        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvMovies.setAdapter(adapter);

        //membuat back button toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}