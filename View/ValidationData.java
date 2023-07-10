package View;

import View.LibraryExceptionForView.FormatDataException;
import View.LibraryExceptionForView.MaxLenForDataException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationData extends ValidationBase {

    public void inputData(String data) {

        chekLenght(data,10);

        chekBase(data);

        chekData(data);
    }

    protected void chekLenght(String data, int maxQuantitySymbol) {

        if ( data.length() != maxQuantitySymbol ) {
            throw new MaxLenForDataException(maxQuantitySymbol);
        }
    }

    private void chekData(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
        } catch (ParseException message) {
            throw new FormatDataException(date);
        }
    }
}
