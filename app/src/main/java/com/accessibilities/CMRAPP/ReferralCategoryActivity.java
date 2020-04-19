package com.accessibilities.CMRAPP;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReferralCategoryActivity extends AppCompatActivity {


    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referral_category);

        int city_id = 0;

            // WORKING... Passing String
            //        String cat_id = getIntent().getStringExtra("extra");
            //        Toast.makeText(ReferralCategoryActivity.this, cat_id, Toast.LENGTH_SHORT).show();
            // END WORKING

        // Passing Integer
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            city_id = extras.getInt("cityID");
//            Toast.makeText(ReferralCategoryActivity.this, "city_id : " + Integer.toString(city_id), Toast.LENGTH_SHORT).show();
        }

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        DataBaseHelper myDbHelper = new DataBaseHelper(ReferralCategoryActivity.this);

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
        String table = "cd_categories";
        String[] columns = {"id", "city_id", "name"};
        String selection = "city_id = " + Integer.toString(city_id);
//            Toast.makeText(ReferralCategoryActivity.this, selection, Toast.LENGTH_SHORT).show();
        String[] selectionArgs = {""};
        String groupBy = null;
        String having = null;
        String orderBy = "id DESC";
        String limit = "100";

        c = myDbHelper.query(table, columns, selection, null, null,null, null);

//        int count = c.getCount();
//        Toast.makeText(ReferralCategoryActivity.this, "Count = " + Integer.toString(count), Toast.LENGTH_SHORT).show();

        cells = new ArrayList<>();


        if (c.moveToFirst())
        {
            do {
                int idIndex = c.getInt(c.getColumnIndex("id"));
                int nameIndex = c.getColumnIndex("name");
//                Log.i("ID", Integer.toString(idIndex));
//                Log.i("name", c.getString(nameIndex));
                cells.add(new Cell(Cell.TITLE_TYPE, c.getString(nameIndex), idIndex, "ReferralSubCategoryActivity" ));
            } while (c.moveToNext());
        }

        initializeAdapter();

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }

}
