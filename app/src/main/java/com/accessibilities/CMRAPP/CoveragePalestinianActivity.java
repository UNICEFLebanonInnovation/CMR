package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoveragePalestinianActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverage_palestinian);

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

        if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "Pep Kit", "100% coverage in CMR facilities, UNRWA contracted hospitals for CMR services"));
            cells.add(new Cell(Cell.TEXT_TYPE, "General Examination fees & treatments of other relevant wounds", "100% coverage in CMR facilities, UNRWA contracted hospitals for CMR services."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Forensic Documentation and fees", "UNICEF through case management partner when available."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Tests (HIV)", "Nearest Facility (table)"));
            cells.add(new Cell(Cell.TEXT_TYPE, "Tetanus shots", "UNRWA Primary Health Clinics."));
            cells.add(new Cell(Cell.TEXT_TYPE, "If survivors can’t pay, please reach out the nearest safe spaces or case management agency as support is present for all survivors.", ""));
        } else if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "مجموعة العلاج الوقائي بعد التعرض للإصابة(PEP", "تغطية 100 % في متوفرة مجاناً في مراكز المعالجة الطبية  لناجين/ات الإغتصاب وفي المستشفيات المتعاقدة مع الأونروا لخدمات المعالجة الطبية  لناجين/ات الإغتصاب"));
            cells.add(new Cell(Cell.TEXT_TYPE, "رسوم الكشف الطبي العام والعلاجات من الجروح / الإصابات الأخرى ذات الصلة", "تغطية 100 % في مرافق المعالجة الطبية  لناجين/ات الإغتصاب ، وفي المستشفيات المتعاقدة مع الأونروا لخدمات."));
            cells.add(new Cell(Cell.TEXT_TYPE, "الوثائق الجنائية والرسوم", "أقرب مرفق (الجدول)."));
            cells.add(new Cell(Cell.TEXT_TYPE, "الفحوص (فيروس نقص المناعة البشرية)", "أقرب مرفق (الجدول)"));
            cells.add(new Cell(Cell.TEXT_TYPE, "حقن داء الكزاز", "عيادات الرعاية الصحية الأولية التابعة لمفوضية الأمم المتحدة لشؤون اللاجئين."));
            cells.add(new Cell(Cell.TEXT_TYPE, "إذا لم يتمكن الناجون من الدفع، يرجى التواصل مع إلى  أقرب مكان آمن أو جمعية إدارة الحالات حيث يتوفر الدعم لجميع الناجين.", ""));
        }
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
