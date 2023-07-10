package View.LibraryExceptionForView;

public class LowercaseException extends RuntimeException {
    public LowercaseException() {
        super("Все символы кроме первого должны быть в нижнем регистре");
    }
}
