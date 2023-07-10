package View;

import View.LibraryExceptionForView.CapitalLetterException;
import View.LibraryExceptionForView.LowercaseException;
import View.LibraryExceptionForView.RussianAlphabetException;

public class ValidationFIO extends ValidationBase {

    public void inputData(String data) {

        chekBaseMaxLen(data,50);

        chekBaseMinLen(data, 2);

        chekBase(data);

        chekForRussianAlphabet(data);

        chekCapitalLetter(data);

        chekLowercase(data);
    }


    private void chekForRussianAlphabet(String data) {

        if ( ! data.matches("[а-яА-Я]+") ) {
            throw new RussianAlphabetException();
        }
    }

    private void chekCapitalLetter(String data) {

        if ( Character.isLowerCase(data.charAt(0)) ) {
            throw new CapitalLetterException();
        }
    }

    private void chekLowercase(String data) {

        for (int i = 1; i < data.length(); i++) {
            if (  Character.isUpperCase(data.charAt(i)) ) {
                throw new LowercaseException();
            }
        }
    }
}
