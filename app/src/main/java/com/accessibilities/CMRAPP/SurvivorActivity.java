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

public class SurvivorActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivor);

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

        if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "استقبال المريضة والتقييم الأولي", "يتم تقييم الناجية فورا و يتم ابلاغ فريق حالات الاغتصاب او طبيب سريري مخصص اخر.  انه ليس من مسؤولية مقدم العناية الصحية. ان يقرر اذا ما كان الشخص قد تعرض للاغتصاب٬ وذلك يعتبر تحديد قانوني."));
            cells.add(new Cell(Cell.TEXT_TYPE, "لاحظ المظهر العام والحالة النفسية للمريضة", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "وثقالعلامات الحيوية وقيم وجود علامات للتعرض للصدمة (انخفاض ضغط الدم وضعف النبض)", ""));
            cells.add(new Cell(Cell.YESNO_TYPE, "هل بامكانك توفير العناية المطلوبة في العيادة الحالية؟", "", "SurvivorYESActivity", "SurvivorNOActivity"));
        } else if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "Patient Assessed Immediately", "Survivors can come not in crisis - Health paracticioner trained on CMR needed. Crisis Team or other designated clinician notified in case survivor comes in emergency."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Note the Patient's general appearances and mental State", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Document Vital Signs and assess for shock (Blood Pressure, pulse)", "", "this is the hint"));
            cells.add(new Cell(Cell.YESNO_TYPE, "Can Care be given at facility", "", "SurvivorYESActivity", "SurvivorNOActivity"));
        }
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }


}
