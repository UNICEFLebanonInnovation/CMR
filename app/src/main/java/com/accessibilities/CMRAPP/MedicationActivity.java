package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MedicationActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        cells = new ArrayList<>();
        cells.add(new Cell(Cell.TITLE_TYPE, "Within 72 Hours", 0, "MedicationsMore_than_72_Activity" ));
        cells.add(new Cell(Cell.TITLE_TYPE, "More than 72 Hours", 1, "MedicationsLess_than_72_Activity" ));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}