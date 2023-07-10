package View.LibraryExceptionForView;

public class FormatDataException extends RuntimeException {
    public FormatDataException(String data) {
        super("Введенное значение " + data + " не соответствует формату даты dd.mm.yyyy");
    }
}
