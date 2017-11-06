package pavan.com.easyresumemaker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;

import pavan.com.helper.DataHelper;

public class ViewExistingResumes extends AppCompatActivity {
    TextView fileTextView=null;
    Context context=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_view_existing_resumes);
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayoutViewExistingFiles);
//        DataHelper.listFiles(context,linearLayout);
        File file = new File(Environment.getExternalStorageDirectory() + "/" + context.getApplicationContext().getPackageName());
        if (file.isDirectory()) {
            int count = 0;
            for (File tempFile : file.listFiles()) {
                if (tempFile.getAbsolutePath().endsWith(".pdf")) {
                    count++;
                    TextView fileTextView = new TextView(context);
                    fileTextView.setText(count + " " + tempFile.getName());
                    fileTextView.setOnClickListener(viewResume);
                    linearLayout.addView(fileTextView);
                }
            }
        }
    }
    View.OnClickListener viewResume= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
            if(v instanceof TextView) {
                final TextView tempView = (TextView) v;
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context,R.style.MyDialogTheme);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                String[] array_options = new String[]{"view", "delete", "update", "share"};
                builder.setTitle("Select one").setItems(array_options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                DataHelper.viewFile(context, tempView);
                                break;
                            case 1:
                                DataHelper.deleteFile(context, tempView);
                                break;
                            case 2:
                                DataHelper.updateFile(context, tempView);
                                break;
                            case 3:
                                DataHelper.shareFile(context, tempView);
                                break;


                        }
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
//                        .setMessage("Are you sure you want to delete this entry?")
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // continue with delete
//                            }
//                        })
//                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // do nothing
//                            }
//                        })
                ;
            }

            }
            catch(Exception e){
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    };

}
