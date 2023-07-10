package View.LibraryExceptionForView;

public class MaxLenForDataException extends RuntimeException {
    public MaxLenForDataException(int maxLen) {
        super("Введенное количество символов должна быть не больше: " + maxLen);
    }
}
