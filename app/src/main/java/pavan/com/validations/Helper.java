package pavan.com.validations;

import android.content.Context;

import pavan.com.easyresumemaker.exceptions.CustomExcetion;

/**
 * Created by Hitesh_A on 11/4/2017.
 */

public class Helper {
    public void validateForSpecialCharacters(String data, Context context) throws CustomExcetion {
        if(data.matches("[$&+,:;=?@#|'<>.-^*()%!]")){
//        if(data!=null && data.contains("@")){
            throw new CustomExcetion("special characters are not recommended here",context);
        }
    }
}
