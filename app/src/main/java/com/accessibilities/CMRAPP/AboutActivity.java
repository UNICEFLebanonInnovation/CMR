package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null);

        TextView aboutTextID = (TextView) findViewById(R.id.about_text_id);

        if ( lang.equals("ENG") ) {
            aboutTextID.setText("The Clinical Mobile Application (CMR) is an offline downloadable mobile application for trained health professionals providing health care for rape survivors.\\nThe aim to have a resource pack on CMR treatment, soft skills and referral pathway for GBV survivors.\n\n The Application is developed by UNICEF in collaboration with Lebanese Ministry of Public Health, ABAAD and CMR Working group.");
        } else if ( lang.equals("ARB") ) {
            aboutTextID.setText("تطبيق “ادارة الحالة الطبية للناجيين/ات من الاعتداء الجنسي (CMR)” هو تطبيق قابل للتحميل دون انترنت للمتخصصين/ات الصحيين المدربين الذين يقدمون الرعاية الصحية للناجين/ات من الاغتصاب. الهدف هو من هذا التطبيق الحصول على حزمة موارد حول علاجات والمهارات وكيفية الإحالة للناجين/ات من الاعتداء الجنسي الى خدمات اخرى. تم تطوير التطبيق من قبل اليونيسف بالتعاون مع وزارة الصحة العامة اللبنانية، ابعاد ومجموعة عمل CMR.");
        }
    }
}
