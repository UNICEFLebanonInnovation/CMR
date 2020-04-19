package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoverageRefugeeAdultActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverage_refugee_adult);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv=(RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        cells = new ArrayList<>();

        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null); // getting String

        if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "", "اللاجئون:السوريون، العراقيون، السودانيون، ملتمسو/طالبو"));
            cells.add(new Cell(Cell.TEXT_TYPE, "مجموعة العلاج الوقائي بعد التعرض للإصابة(PEP)", "متوفرة مجاناً في مرافق المعالجة الطبية  لناجين/ات الإغتصاب"));
            cells.add(new Cell(Cell.TEXT_TYPE, "رسوم الكشف الطبي العام والعلاجات من الجروح / الإصابات الأخرى ذات الصلة", "متوفر مجاناً في مرافق المعالجة الطبية  لناجين/ات الإغتصاب وفي المستشفيات المتعاقدة مع مفوضية الأمم المتحدة لشؤون اللاجئين والمدعومة من أنظمة الرعاية الصحية الخاصة."));
            cells.add(new Cell(Cell.TEXT_TYPE, "الوثائق الجنائية والرسوم", "اليونيسف من خلال شريك لإدارة الحالة"));

            cells.add(new Cell(Cell.TEXT_TYPE, "الفحوص (فيروس نقص المناعة البشرية)", "رب مرفق(الجدول)"));
            cells.add(new Cell(Cell.TEXT_TYPE, "حقن داء الكزاز", "مفوضية الأمم المتحدة لشؤون اللاجئين من خلال شريك لإدارة الحالات"));
            cells.add(new Cell(Cell.TEXT_TYPE, "إذا لم يتمكن الناجون من الدفع، يرجى التواصل مع إلى  أقرب مكان آمن أو جمعية إدارة الحالات حيث يتوفر الدعم لجميع الناجين.", ""));
        } else if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "Refugees: Syrian, Iraqi, Sudanese, Asylum seekers", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Pep Kit", "Available for free in the CMR facilities"));
            cells.add(new Cell(Cell.TEXT_TYPE, "General Examination fees & treatments of other relevant wounds", "Available for free in the CMR facilities and in UNHCR contracted hospitals and supported PHCs."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Forensic Documentation and fees", "UNHCR through case management partner"));

            cells.add(new Cell(Cell.TEXT_TYPE, "Tests (HIV)", "Nearest Facility (table)"));
            cells.add(new Cell(Cell.TEXT_TYPE, "Tetanus shots", "UNHCR through case management partner"));
            cells.add(new Cell(Cell.TEXT_TYPE, "If survivors can’t pay, please reach out the nearest safe spaces or case management agency as support is present for all survivors.", ""));
        }


    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
