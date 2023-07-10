package View.LibraryExceptionForView;

public class MinLenException extends RuntimeException {
    public MinLenException(int minQuantitySymbol, String data) {
        super("Количество символов не должна быть менее " + minQuantitySymbol + " введено: " + data);
    }
}
