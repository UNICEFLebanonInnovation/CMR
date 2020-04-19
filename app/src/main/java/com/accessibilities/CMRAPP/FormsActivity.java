package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FormsActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        cells = new ArrayList<>();
        cells.add(new Cell(Cell.PDF_TYPE,"Consent Form", 0, "Forms_ConsentENG.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Medical History & Examination Form", 1, "Forms_Medical_History_Examination_FormENG.pdf"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
