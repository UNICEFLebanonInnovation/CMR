package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReferencesActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        cells = new ArrayList<>();
//        cells.add(new Cell(Cell.PDF_TYPE, "Link to the Website", 0, ""));
        cells.add(new Cell(Cell.PDF_TYPE, "Clinical Care of Sexual Assualt Facilitators Guide", 0, "REF_Clinical_care_of_Sexual_assualt_Facilitators_guide.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Clinical Management 2005 vp", 0, "REF_Clinical_Management_2005_vp.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Clinical Displaced Persons english", 0, "REF_ClinicalDisplaced_Persons_english.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "D4 CMR Brochure", 0, "REF_D4_CMR_BRochure-2017.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "kit 3 revised content 2016", 0, "REF_kit_3_revised_content_2016.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "pep kit no3 protocols WHO", 0, "REF_pep_kit_no3_protocols_WHO.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Post Rape Care for Adults and Children Pocket Guide", 0, "REF_post-rape-care-for-adults-and-children-pocket-guide.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Service Delivery guidlines Chap 3", 0, "REF_post-rape-care-for-adults-and-children-pocket-guide.pdf"));
        cells.add(new Cell(Cell.PDF_TYPE, "Updated PEP guidance", 0, "Legal.pdf"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }

}
