package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicationsMore_than_72_Activity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications_more_than_72_);
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        cells = new ArrayList<>();
        cells.add(new Cell(Cell.TEXT_TYPE,"Emergency Contraceptive pills (ECP) - for women and girls only", "1 tablet of Levonorgestrel 1.5mg or 2 tablets of Levonorgestrel 0.75 mg labeled to be taken twice 12 hours apart ( can safely be taken together)"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Sexually transmitted infections", ""));
        cells.add(new Cell(Cell.TEXT_TYPE,"Tetanus shot", "Follow Local procedures"));
        cells.add(new Cell(Cell.HINT_TYPE,"HIV Post exposure Prophylaxis", "", "Explain to the patient: The drugs may prevent HIV if started within 72 hours and taken for 28 days We do not know exactly how effective it is at preventing infection. You will need to take two drugs: zidovudine and lamivudine. They are usually combined into a single pill (combivir) to make them easier to take. These are not the same drugs that are usually given to people with HIV to treat the disease. Do not borrow or share drugs with another person. We do not know exactly what the drug might do to an early pregnancy (less than 3 months) but it is believed to be safe. The drugs should be taken by pregnant women to prevent getting the infection and passing in on the baby. It is best to know your HIV status before starting the medicine. A person who is already infected will not get any benefit from the medicine. If the test cannot be done immediately, it should be done within 2 weeks. \\nIf the test is positive within 2 weeks that means you were already infected with HIV. If that happens we will give you information on how to take care of yourself. The drugs can cause nausea, tiredness, and weakness while you are taking them. It may help to take them with food. These symptoms will go away when you stop the medication. They are not dangerous. It is very important to stay on the medication for the full 28 days. If you aren’t feeling well, come back to the clinic for a follow up. Return to the clinic for a follow up test in 3-4 months. Use condoms every time you have sex until your follow up test is negative."));
        cells.add(new Cell(Cell.TEXT_TYPE,"Adult including pregnant women", "Treatment : Zidovudine(AZT)\\n Form: 300 mg tablet\\n Dosages: 1 tablet every 12 hours\\n 30 day Supply: 60 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Treatment : Lamivudine (3TC)\\n Form: 150 mg tablet\\n Dosages: 1 tablet every 12 hours\\n 30 day Supply: 60 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Child 40 kg or more, including pregnant girls", "Treatment : Zidovudine(AZT)\\n Form: 300 mg tablet\\n Dosages: 1 tablet every 12 hours\\n 30 day Supply: 60 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Treatment : Lamivudine (3TC)\\n Form: 150 mg tablet\\n Dosages: 1 tablet every 12 hours\\n 30 day Supply: 60 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Child 20 – 39 kg", "Treatment : Zidovudine(AZT)\\n Form: 100 mg tablet\\n Dosages: Two capsules twice a day\\n 30 day Supply: 120 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Treatment : Lamivudine (3TC)\\n Form: 150 mg tablet\\n Dosages: 1 tablet twice a day\\n 30 day Supply: 60 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Children 10 – 19 kg", "Treatment : Zidovudine(AZT)\\n Form: 100 mg tablet\\n Dosages: One capsules three times a day\\n 30 day Supply: 90 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Treatment : Lamivudine (3TC)\\n Form: 150 mg tablet\\n Dosages: 1/2 tablet twice a day\\n 30 day Supply: 30 tablets"));
        cells.add(new Cell(Cell.TEXT_TYPE,"Children < 2 years old (5-9 Kg)", "Treatment : Zidovudine(AZT)\\n Form: 10 mg/ml tablet\\n Dosages: 7.5 ml twice a day\\n 30 day Supply: 420 ml (i.e five bottles of 100ml or three bottles of 200 ml )"));
        cells.add(new Cell(Cell.TEXT_TYPE,"", "Treatment : Lamivudine (3TC)\\n Form: 11 mg/ml\\n Dosages: 2.5 ml twice a day\\n 30 day Supply: 140 ml (i.e two bottles of 100ml or one bottle of 200 ml)"));


    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
