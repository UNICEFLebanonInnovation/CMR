package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }


    /** Called when the user touches the button */
    public void arabicButtonTapped(View view) {
        Log.w("myApp", "Arabic Button Clicked");

        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("lang", "ARB"); // Storing string
        editor.commit();

        finish();
    }

    /** Called when the user touches the button */
    public void englishButtonTapped(View view) {
        Log.w("myApp", "English Button Clicked");

        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("lang", "ENG"); // Storing string
        editor.commit();

        finish();
    }


}
