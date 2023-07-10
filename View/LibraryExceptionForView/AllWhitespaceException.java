package View.LibraryExceptionForView;

public class AllWhitespaceException extends RuntimeException {
    public AllWhitespaceException() {
        super("Строку состоящую из одних пробелов вводить нельзя");
    }
}
