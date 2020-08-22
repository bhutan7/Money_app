package models.validators;


import java.util.ArrayList;
import java.util.List;

import models.Expenditure;

public class ExpenditureValidator {
    public static List<String> validate(Expenditure e) {
        List<String> errors = new ArrayList<String>();

        String memo_error = _validateMemo(e.getMemo());
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

