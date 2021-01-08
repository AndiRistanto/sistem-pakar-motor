package com.example.andi.satriaf150.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilham Bintang on 15/12/2017.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DBHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<String> getListData(String tabel, int kolom, String id) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM "+tabel+" where kode_"+ tabel+" = \"" + id + "\"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(kolom));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getListData(String tabel, int kolom, List<String> id) {
        List<String> list = new ArrayList<>();
        String data;

        for (int i=0; i<id.size(); i++) {
            data = getData(tabel,kolom,id.get(i));
            list.add(data);
            Log.e("iterasi : ",Integer.toString(i));
        }
        return list;
    }

    public String getData(String tabel, int kolom, String kode) {
        String hasil = "tidak ada hasil";
        Cursor cursor = database.rawQuery("SELECT * FROM "+tabel + " where kode_"+tabel+" = \"" +kode +"\"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            hasil = cursor.getString(kolom);
            cursor.moveToNext();
        }
        cursor.close();
        return hasil;
    }

    public List<String> getKerusakan() {
        List<String> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM nama_kerusakan", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

}
