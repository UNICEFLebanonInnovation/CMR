package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SurvivorYES_NOActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivor_yes__no);
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        cells = new ArrayList<>();
        cells = new ArrayList<>();
        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null);

        if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "DISCHARGE", ""));
        } else if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "انهي تقديم المشورة والتعليم", ""));
        }
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }


}
