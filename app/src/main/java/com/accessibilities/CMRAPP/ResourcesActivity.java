package com.accessibilities.CMRAPP;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ResourcesActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);


        CardView survivorCard = (CardView) findViewById(R.id.forms_card_id);
        survivorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityForms();
            }
        });

        CardView medicationCard = (CardView) findViewById(R.id.coverage_card_id);
        medicationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityCoverage();
            }
        });

        CardView referralCard = (CardView) findViewById(R.id.legal_card_id);
        referralCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityLegal();
            }
        });

        CardView resourcesCard = (CardView) findViewById(R.id.reference_card_id);
        resourcesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityReference();
            }
        });
    }


    public void openActivityForms() {
        Intent intent = new Intent(this, FormsActivity.class);
        startActivity(intent);
    }

    public void openActivityCoverage() {
        Intent intent = new Intent(this, CoverageActivity.class);
        startActivity(intent);
    }

    public void openActivityLegal() {
        Intent intent = new Intent(this, LegalActivity.class);
        startActivity(intent);
    }

    public void openActivityReference() {
        Intent intent = new Intent(this, ReferencesActivity.class);
        startActivity(intent);
    }




}
