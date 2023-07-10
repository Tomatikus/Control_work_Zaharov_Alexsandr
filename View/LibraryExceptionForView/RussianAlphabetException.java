package View.LibraryExceptionForView;

public class RussianAlphabetException extends RuntimeException {
    public RussianAlphabetException() {
        super("Строка должна содержать только буквы русского алфавита");
    }
}
