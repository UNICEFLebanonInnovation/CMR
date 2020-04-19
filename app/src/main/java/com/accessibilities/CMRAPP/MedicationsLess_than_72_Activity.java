package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicationsLess_than_72_Activity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications_less_than_72_);
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        cells = new ArrayList<>();
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Survivor need to undergo a pregnancy test."));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Pregnancy test will only reveal the existence of a prior pregnancy."));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Women who are pregnant should still receive prophylaxis for STIs and HIV with some adjustments."));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Women and girls who don't have their menstruation cycle within 3 weeks of taking"));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "ECP need to re- take a pregnancy tests as they are at high chances of being pregnant."));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "ECP can only be taken within 120 hours (5 days) of the incident"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Emergency Contraceptive pills (ECP)- for women and girls only", "1 tablet of Levonorgestrel 1.5mg or 2 tablets of Levonorgestrel 0.75 mg labeled to be taken twice 12 hours apart ( can safely be taken together)"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Sexually transmitted infections", ""));
        cells.add(new Cell(Cell.TEXT_TYPE,"Tetanus shot", "Follow Local procedures"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
