package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LegalActivity extends AppCompatActivity {


    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        cells = new ArrayList<>();
        cells.add(new Cell(Cell.PDF_TYPE, "MoPH circular", 0, "Legal_D1_new_MoPH_circular.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "ISF Memo Full", 0, "Legal_D2_ISF_memo_Full.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "ISF Memo Brief", 0, "Legal_D3_ISF_Memo_Brief.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "ISF Memo 339-2017", 0, "Legal_ISF_Memo_339-2017.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Law 119-128", 0, "Legal_Law_119-128.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Legal Opinion", 0, "Legal_Opinion_mandatory_reporting.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Mandatory Reporting", 0, "Legal_mandatory_reporting_circular.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Medical Law Up To 5", 0, "Legal_medical_law_up_to_5.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "MoPH Circular CMR EN", 0, "Legal_MoPH_circular_CMR_EN.pdf"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }

}
