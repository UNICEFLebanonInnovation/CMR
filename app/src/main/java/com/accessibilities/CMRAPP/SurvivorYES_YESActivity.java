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

public class SurvivorYES_YESActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivor_yes__yes);
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
            cells.add(new Cell(Cell.TEXT_TYPE, "Give ECPs up to (120 Hrs) if at risk of pregnancy", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Give prophylaxis for STIs", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Give PEP.", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "DISCHARGE", ""));
        } else if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "حدد حالة الحمل وقدم اقراص￼ منع الحمل للحالات الطارئة ان لم تكن حامل", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "اعطي علاج قائي للامراض المنقولة جنسيا حسب HIV البروتوكول", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "PEP اعطي.", "انهي تقديم المشورة والتعليم"));
            cells.add(new Cell(Cell.TEXT_TYPE, "انهي تقديم المشورة والتعليم", "تاكد من وجود مكان آمن للناجية لتذهب اليه. شجعها على زيارة للمتابعة خلال اسبوعين. اعطي تعليمات واضحة و مبسطة لاية ادوية عناية بالجروح. قم بتوثيق الفحص والعلاج بعناية واحفظ جميع الوثائق والادلة في مكان سري ومأمون. من المهم جداً الحفاظ على جميع المعلومات سرية من أجل أمن الناجية. اشرح لها ما تعنيه السرية وكيف ستقوم بالحفاظ على المعلومات آمنة وأي حدود للسرية في حالتها.يجب عليك أيضا تذكيرها أن الاعتداء لم يكن ذنبها٬ وأنها فعلت الشيءالصحيح من خلال طلبها للرعاية."));
        }

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }
}
