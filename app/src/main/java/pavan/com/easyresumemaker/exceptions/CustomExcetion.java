package pavan.com.easyresumemaker.exceptions;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Hitesh_A on 11/4/2017.
 */

public class CustomExcetion extends Exception{
        public CustomExcetion(String msg, Context context){
            Toast t=Toast.makeText(context,msg,Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
}
