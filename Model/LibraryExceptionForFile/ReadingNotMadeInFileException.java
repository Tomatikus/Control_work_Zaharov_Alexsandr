package Model.LibraryExceptionForFile;

import java.io.IOException;

public class ReadingNotMadeInFileException extends IOException {
    public ReadingNotMadeInFileException(String fileName) {
        super("Чтение данных не может быть осуществлена в файл: " + fileName);
    }
}
