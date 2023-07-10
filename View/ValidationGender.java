package View;


import View.LibraryExceptionForView.GenderException;

public class ValidationGender extends ValidationBase {

    public void inputData(String data) {

        chekBaseMaxLen(data,1);

        chekBase(data);

        chekGender(data);
    }

    private void chekGender(String data) {

        if ( ! (data.contains("М") || data.contains("Ж")) ) {
            throw new GenderException(data);
        }
    }
}
