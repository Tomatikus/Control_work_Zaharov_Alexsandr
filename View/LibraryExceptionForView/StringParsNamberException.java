package View.LibraryExceptionForView;

public class StringParsNamberException extends RuntimeException {
    public StringParsNamberException(String data) {
        super("Строку нельзя перевести в число так как она содержит " +
                "следующие символы: " + data);
    }
}
