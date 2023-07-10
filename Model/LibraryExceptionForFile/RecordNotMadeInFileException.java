package Model.LibraryExceptionForFile;

import java.io.IOException;

public class RecordNotMadeInFileException extends IOException {
    public RecordNotMadeInFileException(String fileName) {
        super("Запись данных не может быть осуществлена в файл: " + fileName);
    }
}
