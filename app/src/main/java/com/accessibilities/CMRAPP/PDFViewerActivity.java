package com.accessibilities.CMRAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        String PDF_Filename;

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            PDF_Filename = null;
        } else {
            PDF_Filename= extras.getString("PDF_FileName");

            Log.w("File NAME : ", PDF_Filename);


            PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
            pdfView.fromAsset(PDF_Filename).load();


        }
    }
}
