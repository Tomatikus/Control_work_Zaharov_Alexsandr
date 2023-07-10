package View.LibraryExceptionForView;

public class GenderException extends RuntimeException {
    public GenderException(String variable) {
        super("Строка должна содержать символ М или Ж (введенные на русском языке) вместо " + variable);
    }
}
