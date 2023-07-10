package View;

import View.LibraryExceptionForView.*;

public class ValidationBase  {

    protected void chekBaseMaxLen(String data, int maxQuantitySymbol) {

        if ( data.length() > maxQuantitySymbol ) {
            throw new MaxLenException(maxQuantitySymbol,data);
        }
    }

    protected void chekBaseMinLen(String data, int minQuantitySymbol) {

        if ( data.length() < minQuantitySymbol ) {
            throw new MinLenException(minQuantitySymbol, data);
        }
    }

    protected void chekBase(String data) {

        if ( data.isEmpty() ) {
            throw new EmptyStringException();
        }

        if ( data.trim().isEmpty() ) {
            throw new AllWhitespaceException();
        }

        if ( data.contains(" ") ) {
            throw new AtLeastOneWhitespaceException();
        }
    }
}
