package View.LibraryExceptionForView;

public class MaxLenException extends RuntimeException {
    public MaxLenException(int maxLen, String data) {
        super("Количество символов не должна быть более: " + maxLen + "введено:" + data);
    }
}
