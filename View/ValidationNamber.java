package View;

import View.LibraryExceptionForView.NumberLengthException;
import View.LibraryExceptionForView.StringParsNamberException;

public class ValidationNamber extends ValidationBase {

    public void inputData(String data) {

        chekBaseMaxLen(data,15);

        chekBase(data);

        searchNotNumberInString(data);

        evaluationNumber(data, 1);
    }

    private void searchNotNumberInString(String data) {

        String byfer = "";

        for (int i = 0; i < data.length(); i++) {

            if ( !Character.isDigit(data.charAt(i)) ) {
                byfer = byfer + data.charAt(i) + " на позиции: " + (i + 1) + " ";
            }
        }

        if ( !byfer.isEmpty() ) {
            throw new StringParsNamberException(byfer);
        }
    }

    private void evaluationNumber(String data , int minNamber) {

        long number = Long.parseLong(data);

        if ( number < minNamber ) {
            throw new NumberLengthException(number);
        }
    }
}
