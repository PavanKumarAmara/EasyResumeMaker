package pavan.com.helper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import pavan.com.easyresumemaker.R;
import pavan.com.easyresumemaker.ViewExistingResumes;
import pavan.com.pavan.com.model.EducationDetails;

/**
 * Created by Hitesh_A on 6/25/2017.
 */

public class DataHelper {
    static LinearLayout linearLayout1=null;
    public static List<EducationDetails> setEducationDataToObject(List<EducationDetails> totalEducationDetails){
        if(totalEducationDetails!=null){
            for(int i=0;i<totalEducationDetails.size();i++){
                totalEducationDetails.get(i).setDegree(totalEducationDetails.get(i).getDegreeEditText().getText().toString());
                totalEducationDetails.get(i).setInstitute(totalEducationDetails.get(i).getInstituteEditText().getText().toString());
                totalEducationDetails.get(i).setDuration(totalEducationDetails.get(i).getDurationEditText().getText().toString());
                totalEducationDetails.get(i).setPercentage(totalEducationDetails.get(i).getPercentageEditText().getText().toString());
            }
        }

        return totalEducationDetails;
    }
    public static void loadSamplesToMemory(Context context) {
        File path = new File( Environment.getExternalStorageDirectory(), context.getApplicationContext().getPackageName()+"/samples" );
        if ( !path.exists() ){
            Toast.makeText(context,"A new "+context.getApplicationContext().getPackageName()+"Directory is created",Toast.LENGTH_LONG).show();
            path.mkdirs();
        }
        loadFile(context,R.drawable.one,"One");
        loadFile(context,R.drawable.two,"Two");

    }
static void loadFile(Context context,int drawableId,String name){
    Bitmap bm = BitmapFactory.decodeResource( context.getResources(),drawableId );
    File file = new File(Environment.getExternalStorageDirectory(),context.getApplicationContext().getPackageName()+ "/samples/"+name+".PNG");

    FileOutputStream sample=null;
    try {
        if(!file.exists()){
            file.createNewFile();
            sample = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 100, sample);
            sample.flush();
            sample.close();
            Toast.makeText(context,"samples are loaded..",Toast.LENGTH_LONG).show();
        }
    } catch (IOException e) {
        Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
    }
}
    public static void viewFile(Context context, TextView v){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+context.getApplicationContext().getPackageName()+"/"+v.getText().toString().substring(2) );
        if(file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            context.startActivity(intent);
        }
        else {
            Toast.makeText(context,file.getAbsolutePath(),Toast.LENGTH_LONG).show();;
        }
    }
    public static void deleteFile(Context context, TextView v){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+context.getApplicationContext().getPackageName()+"/"+v.getText().toString().substring(2) );
        if(file.exists()) {
            file.delete();
//            listFiles(context,linearLayout1);
        }
        else {
            Toast.makeText(context,file.getAbsolutePath(),Toast.LENGTH_LONG).show();;
        }
    }
    public static void updateFile(Context context, TextView v){
            Toast.makeText(context,"Under Maintenance",Toast.LENGTH_LONG).show();;
    }
    public static void shareFile(Context context, TextView v){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+context.getApplicationContext().getPackageName()+"/"+v.getText().toString().substring(2) );
        if(file.exists()) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "#EasyResumeMaker");
            sendIntent.setType("application/pdf");
            Uri uri = Uri.fromFile(file);
            sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
            context.startActivity(sendIntent);
        }
        else {
            Toast.makeText(context,file.getAbsolutePath(),Toast.LENGTH_LONG).show();;
        }

    }
    public static void listFiles(Context context,LinearLayout linearLayout) {
       linearLayout1=linearLayout;
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + context.getApplicationContext().getPackageName());
            if (file.isDirectory()) {
                int count = 0;
                for (File tempFile : file.listFiles()) {
                    if (tempFile.getAbsolutePath().endsWith(".pdf")) {
                        count++;
                        TextView fileTextView = new TextView(context);
                        fileTextView.setText(count + " " + tempFile.getName());
//                        fileTextView.setOnClickListener(v.viewResume);
                        linearLayout.addView(fileTextView);
                    }
                }
            }
        }
        catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
