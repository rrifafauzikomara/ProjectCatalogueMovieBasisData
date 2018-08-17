package com.rifafauzi.example.favoritemovie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rifafauzi.example.favoritemovie.Entity.MovieItem;
import com.rifafauzi.example.favoritemovie.R;

import static com.rifafauzi.example.favoritemovie.Db.DatabaseContract.FavoriteColumns.DESCRIPTION;
import static com.rifafauzi.example.favoritemovie.Db.DatabaseContract.FavoriteColumns.NAME;
import static com.rifafauzi.example.favoritemovie.Db.DatabaseContract.FavoriteColumns.POSTER;
import static com.rifafauzi.example.favoritemovie.Db.DatabaseContract.FavoriteColumns.RELEASE_DATE;
import static com.rifafauzi.example.favoritemovie.Db.DatabaseContract.getColumnString;

public class MovieAdapter extends CursorAdapter {

    public MovieAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_favorite, parent, false);
        return view;
    }

    @Override
    public Cursor getCursor() {
        return super.getCursor();
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        if (cursor != null){
            TextView textViewTitle, textViewOverview, textViewRelease;
            ImageView imgPoster;

            textViewTitle = view.findViewById(R.id.movie_name);
            textViewOverview = view.findViewById(R.id.movie_desc);
            textViewRelease = view.findViewById(R.id.movie_date);
            imgPoster = view.findViewById(R.id.movie_poster);

            textViewTitle.setText(getColumnString(cursor,NAME));
            textViewOverview.setText(getColumnString(cursor,DESCRIPTION));
            textViewRelease.setText(getColumnString(cursor,RELEASE_DATE));
            Glide.with(context).load(getColumnString(cursor, POSTER)).placeholder(R.drawable.img_default_bg).error(R.drawable.img_default_bg).into(imgPoster);
        }
    }
}