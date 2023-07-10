package View.LibraryExceptionForView;

public class AtLeastOneWhitespaceException extends RuntimeException {
    public AtLeastOneWhitespaceException() {
        super("Строку в которой есть пробелы вводить нельзя");
    }
}
