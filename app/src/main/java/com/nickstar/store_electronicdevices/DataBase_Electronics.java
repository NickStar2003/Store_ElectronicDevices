package com.nickstar.store_electronicdevices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase_Electronics  {


    public static final String DEVICES_L = "DEVICES_LIST";
    public static final String firstColumn = "ID";
    public static final String nameColumn = "NAME";
    public static final String priceColumn = "PRICE";



    public static void create_tables(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+DEVICES_L+"("+firstColumn+" text, "+nameColumn+" text,"+ priceColumn+" text)");



        db.execSQL("insert into "+DEVICES_L+" values('1', 'iphone x', '550')");
        db.execSQL("insert into "+DEVICES_L+" values('2', 'iphone xs', '650')");
        db.execSQL("insert into "+DEVICES_L+" values('3', 'iphone 12', '750')");
        db.execSQL("insert into "+DEVICES_L+" values('4', 'samsung s20', '850')");
        db.execSQL("insert into "+DEVICES_L+" values('5', 'Bosch wasching machine', '780')");
        db.execSQL("insert into "+DEVICES_L+" values('6', 'Samsung 4k TV', '999')");






    }



}
