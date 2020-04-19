package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    private Button survivorButton;
//    private Button medicationButton;
//    private Button referralButton;
//    private Button resourcesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CardView survivorCard = (CardView) findViewById(R.id.survivor_card_id);
        survivorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivitySurvivor();
            }
        });

        CardView medicationCard = (CardView) findViewById(R.id.medication_card_id);
        medicationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityMedication();
            }
        });

        CardView referralCard = (CardView) findViewById(R.id.referrals_card_id);
        referralCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityReferral();
            }
        });

        CardView resourcesCard = (CardView) findViewById(R.id.resources_card_id);
        resourcesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                openActivityResources();
            }
        });

        Log.w("CMR CMR CMR : ", "MainActivity::onCreate()");

        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null); // getting String

        if (lang == null) {
            Log.w("CMR LANG : ", "NULL");
            Intent intent = new Intent(this, LanguageActivity.class);
            startActivity(intent);
        } else {
            switchLanguage();
        }



    }


    public void switchLanguage() {
        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null); // getting String

        if ( lang.equals("ENG") ) {
            Log.w("CMR LANG : ", lang);
            TextView survivorTextID = (TextView) findViewById(R.id.survivor_text_id);
            survivorTextID.setText("Receiving a Survivor");

            TextView medicationTextID = (TextView) findViewById(R.id.medication_text_id);
            medicationTextID.setText("Medication");

            TextView referralsTextID = (TextView) findViewById(R.id.referrals_text_id);
            referralsTextID.setText("Referrals");

            TextView resourcesTextID = (TextView) findViewById(R.id.resources_text_id);
            resourcesTextID.setText("Resources");

            ////////////////////////////////////////////////////////

//            MenuItem menuHomeTextID = (MenuItem) findViewById(R.id.menu_nav_home);
//            menuHomeTextID.setTitle("Home");



        } else if ( lang.equals("ARB") ) {
            TextView survivorTextID = (TextView) findViewById(R.id.survivor_text_id);
            survivorTextID.setText("استقبال الناجي(ة)");

            TextView medicationTextID = (TextView) findViewById(R.id.medication_text_id);
            medicationTextID.setText("المعالجة");

            TextView referralsTextID = (TextView) findViewById(R.id.referrals_text_id);
            referralsTextID.setText("الإحالات");

            TextView resourcesTextID = (TextView) findViewById(R.id.resources_text_id);
            resourcesTextID.setText("موارد");

            ////////////////////////////// MENU //////////////////////
//            MenuItem menuHomeTextID = (MenuItem) findViewById(R.id.menu_nav_home);
//            menuHomeTextID.setTitle("الصفحة الرئيسية");


        }
    }


    public void openActivitySurvivor() {
        Intent intent = new Intent(this, SurvivorActivity.class);
        startActivity(intent);
    }

    public void openActivityMedication() {
        Intent intent = new Intent(this, MedicationActivity.class);
        startActivity(intent);
    }

    public void openActivityReferral() {
        Intent intent = new Intent(this, ReferralActivity.class);
        startActivity(intent);
    }

    public void openActivityResources() {
        Intent intent = new Intent(this, ResourcesActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        this.onCreate(null);

        Log.w("myApp : ", "onResume");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_nav_home) {
            // Handle the camera action
        } else if (id == R.id.menu_nav_form) {
            Intent intent = new Intent(this, FormsActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_nav_coverage) {
            Intent intent = new Intent(this, CoverageActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_nav_legal) {
            Intent intent = new Intent(this, LegalActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_nav_resource) {
            Intent intent = new Intent(this, ReferencesActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_nav_language) {
            Intent intent = new Intent(this, LanguageActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
//            getSupportFragmentManager().beginTransaction().replace( R.id.fragment_about_id, new AboutFragment()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
