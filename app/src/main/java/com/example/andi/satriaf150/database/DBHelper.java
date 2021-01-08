package com.example.andi.satriaf150.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Ilham Bintang on 15/12/2017.
 */

public class DBHelper extends SQLiteAssetHelper {

    static final String DATABASE_NAME = "sistempakar.db";
    static final int DATABASE_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
