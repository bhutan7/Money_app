package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Revenue;

public class RevenueValidator {
    public static List<String> validate(Revenue r) {
        List<String> errors = new ArrayList<String>();

        String memo_error = _validateMemo(r.getMemo());
        if(!memo_error.equals("")) {
            errors.add(memo_error);
        }
        return errors;
    }

    private static String _validateMemo(String memo) {
        if(memo == null || memo.equals("")) {
            return "入力してください。";
            }

        return "";
    }


}