package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class CoverageActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverage);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();



        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        cells = new ArrayList<>();

        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null); // getting String

        if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TITLE_TYPE, "Refugee Adult", 0, "CoverageRefugeeAdultActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "Refugee Child", 1, "CoverageRefugeeChildActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "Lebanese", 2, "CoverageLebaneseActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "Palestinian", 3, "CoveragePalestinianActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "Other Nationality", 4, "CoverageOtherActivity"));
        } else if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TITLE_TYPE, "البالغون اللاجئون", 0, "CoverageRefugeeAdultActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "الأطفال اللاجئون", 1, "CoverageRefugeeChildActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "اللبنانيون", 2, "CoverageLebaneseActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "الفلسطنين", 3, "CoveragePalestinianActivity"));
            cells.add(new Cell(Cell.TITLE_TYPE, "جنسية أخرى", 4, "CoverageOtherActivity"));
        }


    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
