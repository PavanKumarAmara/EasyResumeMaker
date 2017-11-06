package pavan.com.easyresumemaker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.File;

public class SampleOutput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_output);
//        try{
//            String file=Environment.getExternalStorageDirectory()+"/"+this.getApplicationContext().getPackageName()+ "/samples/";
//
//        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
//        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
//     //   ScrollView scrollView=(ScrollView) findViewById(R.id.scrollView);
//        ImageView imageView=new ImageView(this);
//            File imgFile = new  File(file+"one.png");
//            if(imgFile.exists()){
//                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//                imageView.setImageBitmap(myBitmap);
//            }
//            imageView.setAdjustViewBounds(Boolean.TRUE);
//////        imageView.setLayoutParams(lparams);
//        linearLayout.addView(imageView);
//        ImageView imageView1=new ImageView(this);
//            File imgFile1 = new  File(file+"two.png");
//            if(imgFile.exists()){
//                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//                imageView1.setImageBitmap(myBitmap);
//
//            }
//////        imageView1.setLayoutParams(lparams);
//        imageView1.setAdjustViewBounds(Boolean.TRUE);
//        linearLayout.addView(imageView1);
//        }
//        catch (Exception e){
//            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
//        }


    }
}
