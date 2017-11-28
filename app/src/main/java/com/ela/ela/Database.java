package com.ela.ela;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EllaDw on 26/11/2017.
 */

public class Database extends SQLiteOpenHelper {

    final static String namadb = "sqlite";
    final static String namatabel = "mahasiswa";
    private SQLiteDatabase operation;
    private String x;

    public Database(Context context) {
        super(context, namadb, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+namatabel+" (nim integer primary key AUTOINCREMENT, nama text)";
        sqLiteDatabase.execSQL(query);
    }

    public void tambahdata(String nama_mhs){
        operation = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", nama_mhs);
        operation.insert(namatabel, null, values);
    }

    public List<String>tampildata(){

        List<String> datanama = new ArrayList<>();
        operation = this.getReadableDatabase();
        Cursor cursor = operation.rawQuery("select * from "+namatabel, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            x = cursor.getString(cursor.getColumnIndex("nama"));
            datanama.add(x);
        }

        return datanama;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


