package View.LibraryExceptionForView;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException() {
        super("Пустую строку вводить нельзя");
    }
}
