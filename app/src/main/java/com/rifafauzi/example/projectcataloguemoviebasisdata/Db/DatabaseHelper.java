package com.rifafauzi.example.projectcataloguemoviebasisdata.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.FavoriteColumns._ID;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.FavoriteColumns.NAME;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.FavoriteColumns.POSTER;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.FavoriteColumns.RELEASE_DATE;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.FavoriteColumns.DESCRIPTION;
import static com.rifafauzi.example.projectcataloguemoviebasisdata.Db.DatabaseContract.FavoriteColumns.TABLE_FAVORITE;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db_favorite";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_FAVORITE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            TABLE_FAVORITE,
            _ID,
            NAME,
            POSTER,
            RELEASE_DATE,
            DESCRIPTION
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_FAVORITE);
        onCreate(db);
    }
}
