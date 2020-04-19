package com.accessibilities.CMRAPP;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android.net.Uri;
import android.widget.Toast;


import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.shockwave.pdfium.PdfDocument;



//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Cell> cells;
    RVAdapter(List<Cell> cells){
        this.cells = cells;
    }


//    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
//
//
//            Context context = view.getContext();
//            Intent intent = new Intent(context, ItemDetailActivity.class);
//            intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);
//            context.startActivity(intent);
//        }
//    };


    public static class CellViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView subtitle;
//        int _id;


        CellViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title_id);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle_id);
        }
    }

    // Cell with Yes / No
    public static class CellYesNoViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView subtitle;
        Button yesButton;
        Button noButton;

        CellYesNoViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_yesno);
            title = (TextView)itemView.findViewById(R.id.title_id);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle_id);
            yesButton = (Button)itemView.findViewById(R.id.button_yes_id);
            noButton = (Button)itemView.findViewById(R.id.button_no_id);
        }

        public void openYesActivity(String str) {
            Log.w("myApp", str);
            // WORKING
//            Context context = itemView.getContext();
//            Intent intent = new Intent(context, SurvivorYESActivity.class);
//            context.startActivity(intent);
            // END WORKING

            String activityToStart = "com.accessibilities.CMRAPP" + "." + str;
            try {
                Context context = itemView.getContext();
                Class<?> c = Class.forName(activityToStart);
                Intent intent = new Intent(context, c);
                context.startActivity(intent);
            } catch (ClassNotFoundException ignored) {
            }

        }


        public void openNoActivity(String str) {
            Log.w("myApp", str);
            String activityToStart = "com.accessibilities.CMRAPP" + "." + str;
            try {
                Context context = itemView.getContext();
                Class<?> c = Class.forName(activityToStart);
                Intent intent = new Intent(context, c);
                context.startActivity(intent);
            } catch (ClassNotFoundException ignored) {
            }
        }
    }

    // Cell with Hint
    public static class CellHintViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView subtitle;
        Button hintButton;

        CellHintViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_hint);
            title = (TextView)itemView.findViewById(R.id.title_id);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle_id);
            hintButton = (Button)itemView.findViewById(R.id.button_hint_id);
        }


        public void getBasicDialog(String str)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(cv.getContext() ).create();
            alertDialog.setTitle("Hint");
            alertDialog.setMessage(str);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // here you can add functions
                }
            });
            alertDialog.show();
        }
    }


    public static class TitleViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        int id;


        TitleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_title);
            title = (TextView)itemView.findViewById(R.id.title_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Context context = view.getContext();

                    Cell cell = (Cell) view.getTag();
                        Log.w("TitleViewHolder ID", Integer.toString(cell.id));
                        Log.w("TitleViewHolder NEXT", cell.nextScreen);

                     // WORKING
//                    Intent myIntent = new Intent(view.getContext(), ReferralCategoryActivity.class);
//                    myIntent.putExtra("extra", "my Extra Paramter");
//                    context.startActivity(myIntent);
                    // END WORKING


//                    // TBR
//                    String activityToStart = "com.accessibilities.CMRAPP" + "." + str;
//                    try {
//                        Context context = itemView.getContext();
//                        Class<?> c = Class.forName(activityToStart);
//                        Intent intent = new Intent(context, c);
//                        context.startActivity(intent);
//                    } catch (ClassNotFoundException ignored) {
//                    }
//                    // END TBR

                    if (cell.nextScreen != "") {
                        try {
                            String activityToStart = "com.accessibilities.CMRAPP" + "." + cell.nextScreen;
                            Log.w("Inside the TRY", activityToStart);
                            Class<?> c = Class.forName(activityToStart);
                            Intent myIntent = new Intent(view.getContext(), c);
                            Bundle data = new Bundle();
                            data.putInt("cityID", cell.id);
                            myIntent.putExtras(data);
                            context.startActivity(myIntent);
                        } catch (ClassNotFoundException ignored) {
                        }
                    }


                }
            });
        }
    }


    public static class PDFViewHolder extends RecyclerView.ViewHolder implements OnPageChangeListener, OnLoadCompleteListener,
            OnPageErrorListener {

        private static final String TAG = PDFViewHolder.class.getSimpleName();


        CardView cv;
        TextView title;
        int id;

        // PDFView Related
        PDFView pdfView;
        String pdfFileName;
        Integer pageNumber = 0;



        @Override
        public void loadComplete(int nbPages) {
            PdfDocument.Meta meta = pdfView.getDocumentMeta();
        }

        @Override
        public void onPageChanged(int page, int pageCount) {
        }

        @Override
        public void onPageError(int page, Throwable t) {
            Log.e(TAG, "Cannot load page " + page);
        }


        private void displayFromAsset(String assetFileName) {

            pdfFileName = assetFileName;

            pdfView.fromAsset(pdfFileName)
                    .defaultPage(pageNumber)
                    .onPageChange(this)
                    .enableAnnotationRendering(true)
                    .onLoad(this)
//                    .scrollHandle(new DefaultScrollHandle(this))
                    .spacing(10) // in dp
                    .onPageError(this)
//                    .pageFitPolicy(FitPolicy.BOTH)
                    .load();
        }



        PDFViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_pdf);
            title = (TextView)itemView.findViewById(R.id.title_id);

            // PDFView Related
            pdfView = (PDFView) itemView.findViewById(R.id.pdfView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Context context = view.getContext();

                    Cell cell = (Cell) view.getTag();
                    Log.w("PDFViewHolder ID", Integer.toString(cell.id));
                    Log.w("PDFViewHolder NEXT", cell.nextScreen);

                    if (cell.nextScreen != "") {
                        Intent intent = new Intent(context, PDFViewerActivity.class);
                        intent.putExtra("PDF_FileName", cell.nextScreen);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case Cell.TEXT_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
                return new CellViewHolder(view);
            case Cell.YESNO_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_yesno, viewGroup, false);
                return new CellYesNoViewHolder(view);
            case Cell.HINT_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hint, viewGroup, false);
                return new CellHintViewHolder(view);
            case Cell.TITLE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_title, viewGroup, false);
                return new TitleViewHolder(view);
            case Cell.PDF_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pdf, viewGroup, false);
                return new PDFViewHolder(view);
        }
        return null;
    }



    @Override
    public void onBindViewHolder( final RecyclerView.ViewHolder holder, final int i) {

        Cell object = cells.get(i);
        if (object == null) {
            return;
        }

        holder.itemView.setTag(cells.get(i));

        switch (object.type)
        {
            case Cell.TEXT_TYPE:
                ((CellViewHolder) holder).title.setText(cells.get(i).title);
                ((CellViewHolder) holder).subtitle.setText(cells.get(i).subtitle);
                break;
            case Cell.YESNO_TYPE:
                ((CellYesNoViewHolder) holder).title.setText(cells.get(i).title);
                ((CellYesNoViewHolder) holder).subtitle.setText(cells.get(i).subtitle);

                // YES BUTTON
                Button yesButton = ((CellYesNoViewHolder) holder).yesButton;
                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((CellYesNoViewHolder) holder).openYesActivity(cells.get(i).yesButton);
                    }
                });

                // NO BUTTON
                Button noButton = ((CellYesNoViewHolder) holder).noButton;
                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((CellYesNoViewHolder) holder).openNoActivity(cells.get(i).noButton);
                    }
                });

                break;

            case Cell.HINT_TYPE:
                ((CellHintViewHolder) holder).title.setText(cells.get(i).title);
                ((CellHintViewHolder) holder).subtitle.setText(cells.get(i).subtitle);

                // NO BUTTON
                Button hintButton = ((CellHintViewHolder) holder).hintButton;
                hintButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((CellHintViewHolder) holder).getBasicDialog(cells.get(i).hint);
                    }
                });
                break;

            case Cell.TITLE_TYPE:
                ((TitleViewHolder) holder).title.setText(cells.get(i).title);
                break;
            case Cell.PDF_TYPE:
                ((PDFViewHolder) holder).title.setText(cells.get(i).title);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {

        switch (cells.get(position).type) {
            case 0:
                return Cell.TEXT_TYPE;
            case 1:
                return Cell.YESNO_TYPE;
            case 2:
                return Cell.HINT_TYPE;
            case 3:
                return Cell.TITLE_TYPE;
            case 4:
                return Cell.PDF_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

}