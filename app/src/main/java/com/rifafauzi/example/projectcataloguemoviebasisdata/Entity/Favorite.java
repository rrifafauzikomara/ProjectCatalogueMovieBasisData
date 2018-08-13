package com.rifafauzi.example.projectcataloguemoviebasisdata.Entity;

import android.database.Cursor;

import com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract;

import java.io.Serializable;

import static android.provider.BaseColumns._ID;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.getColumnInt;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.getColumnString;

public class Favorite implements Serializable {

    private int id;
    private String name;
    private String poster;
    private String date;
    private String description;

    public Favorite(Cursor cursor) {
        this.id = getColumnInt(cursor, _ID);
        this.name = getColumnString(cursor, DatabaseContract.FavoriteColumns.NAME);
        this.poster = getColumnString(cursor, DatabaseContract.FavoriteColumns.POSTER);
        this.date = getColumnString(cursor, DatabaseContract.FavoriteColumns.RELEASE_DATE);
        this.description = getColumnString(cursor, DatabaseContract.FavoriteColumns.DESCRIPTION);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPoster() {
        return poster;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
