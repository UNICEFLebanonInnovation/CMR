package com.accessibilities.CMRAPP;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ReferralActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        DataBaseHelper myDbHelper = new DataBaseHelper(ReferralActivity.this);

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        Cursor c = null;
        c = myDbHelper.query("cd_cities", null, null, null, null,null, null);


        cells = new ArrayList<>();


        if (c.moveToFirst())
        {
            do {
                int idIndex = c.getInt(c.getColumnIndex("id"));
                int nameIndex = c.getColumnIndex("name");
//                    Log.i("ID", Integer.toString(idIndex));
//                    Log.i("name", c.getString(nameIndex));
                cells.add(new Cell(Cell.TITLE_TYPE, c.getString(nameIndex), idIndex, "ReferralCategoryActivity" ));
            } while (c.moveToNext());
        }

        initializeAdapter();
    }


    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }

}
