package View.LibraryExceptionForView;

public class NumberLengthException extends RuntimeException {
    public NumberLengthException(long data) {
        super("Телефонный номер не должен быть короче трех цифр " +
                "введено значение: " + data);
    }
}
