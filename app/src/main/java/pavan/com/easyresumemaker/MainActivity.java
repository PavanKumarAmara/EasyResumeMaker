package pavan.com.easyresumemaker;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pavan.com.helper.DataHelper;
import pavan.com.helper.ViewUtility;

public class MainActivity extends AppCompatActivity {
    private  boolean isAllPersmissionsGranted=Boolean.TRUE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                Toast.makeText(this, "We apologize for not being available in lower versions", Toast.LENGTH_LONG).show();
            } else {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                DataHelper.loadSamplesToMemory(this);
                TextView startBuilding = (TextView) findViewById(R.id.start_building);
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Give Permission To Write", Toast.LENGTH_LONG).show();
                    isAllPersmissionsGranted=Boolean.FALSE;
                }
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Give Permission To Read Contacts", Toast.LENGTH_LONG).show();
                    isAllPersmissionsGranted=Boolean.FALSE;
                }
                if(isAllPersmissionsGranted){
                    Toast.makeText(this, "Application is opened by " + ViewUtility.getUsername(this), Toast.LENGTH_LONG).show();
                    startBuilding.setOnLongClickListener(hiddenToast);
                }
                else {
                    Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
            }
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    View.OnLongClickListener hiddenToast = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(getApplicationContext(), "Welcome Pavan", Toast.LENGTH_LONG).show();
            return true;
        }
    };

   public void startBuilding(View view) {
        try {
            Intent startBuilding = new Intent(this, ResumeActivity.class);
            startActivity(startBuilding);
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void seeSamples(View view){
        try {
            Intent sampleImages = new Intent(this, SampleOutput.class);
            startActivity(sampleImages);
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void seeExistingFiles(View view){
        try {
            Intent existingFiles = new Intent(this, ViewExistingResumes.class);
            startActivity(existingFiles);
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
