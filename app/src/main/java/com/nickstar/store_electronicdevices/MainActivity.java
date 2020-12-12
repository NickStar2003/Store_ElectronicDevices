package com.nickstar.store_electronicdevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String clients_table = "Clients";
    public static final String order_table = "Orders";
    public static final String current_order = "Current_Order";

    SQLiteDatabase db;

    ImageView cart;

    DataBase_Electronics dataBase_electronics;
    ListView stock;


    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart = findViewById(R.id.imageView2);
        cart.setOnClickListener(this);

        db = openOrCreateDatabase(DataBase_Electronics.DEVICES_L, MODE_PRIVATE, null);




        db = openOrCreateDatabase(clients_table, MODE_PRIVATE, null);
        db.execSQL("create table if not exists "+clients_table+"(id int, name text, email text, adress text)");


        db = openOrCreateDatabase(order_table, MODE_PRIVATE, null);
        db.execSQL("create table if not exists "+order_table+"(id int, sum int, customer int, product int, quantity int)");

        db = openOrCreateDatabase(current_order, MODE_PRIVATE, null);
        db.execSQL("create table if not exists "+current_order+"(id int, sum int, customer int, product int, quantity int)");


        stock = findViewById(R.id.goods);

         adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getTheArrayListOfDevices());
         stock.setAdapter((ListAdapter) adapter);




    }


    private ArrayList<String> getTheArrayListOfDevices() {



        String query = "SELECT " + DataBase_Electronics.firstColumn + ", " + DataBase_Electronics.nameColumn + ", " + DataBase_Electronics.priceColumn
                + " FROM " + DataBase_Electronics.DEVICES_L;

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();


        ArrayList<String> devices = new ArrayList<>();

        while(cursor.moveToNext()) {
            if (cursor.getCount() < 0) {
                String firstId = cursor.getString(cursor.getColumnIndex(DataBase_Electronics.firstColumn));
                String secondName = cursor.getString(cursor.getColumnIndex(DataBase_Electronics.nameColumn));
                String thirdPrice = cursor.getString(cursor.getColumnIndex(DataBase_Electronics.priceColumn));

                String everything = firstId + "     " + secondName + "      " + thirdPrice;

                devices.add(everything);
            }
        }

        return  devices;
    }


    @Override
    public void onClick(View view) {

        if(cart == view) {
            Intent intent = new Intent(this, Cart.class);
            startActivity(intent);
        }

    }
}