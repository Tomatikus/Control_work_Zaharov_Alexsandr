package View.LibraryExceptionForView;

public class CapitalLetterException extends RuntimeException {
    public CapitalLetterException() {
        super("Первый символ должен быть заглавным (в верхнем регистре)");
    }
}
