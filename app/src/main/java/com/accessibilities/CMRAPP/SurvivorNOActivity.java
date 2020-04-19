package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SurvivorNOActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivor_no);

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
        String lang = sharedPref.getString("lang", null);
        Log.w("myApp || Survivor ", lang);

        if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "Stabilize", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Note the Patient's general appearances and mental State", ""));
            cells.add(new Cell(Cell.HINT_TYPE, "Consider ECPs, PEP, tetanus and Hepatitis B immediately", "", "Contact sheet of CMR facilities (referral pathway)"));
        } else if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE,"حتى لو كانت عيادتك لاتفي بالمعايير المذكورة في هذا العرض٬ اجعل الحالة مستقرة", ""));
            cells.add(new Cell(Cell.TEXT_TYPE,"ضع في عين الاعتبار إعطاء الحالة اقراص منع الحمل في PEP الحالات الطارئة والتطعيم ضد الكزاز", ""));
            cells.add(new Cell(Cell.HINT_TYPE,"قم بإحالة الناجية على الفور", "", "استخدام شبكة خدماتالإحالة المتوفرة لضمان حصول المريضة على الرعاية اللاحقةبعد خروجها من العيادة(رابط الى خدمة الاحالات)"));
        }
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }

}
