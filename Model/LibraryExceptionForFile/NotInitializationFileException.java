package Model.LibraryExceptionForFile;

import java.io.IOException;

public class NotInitializationFileException extends IOException {
    public NotInitializationFileException(String fileName) {
        super("Файл " + fileName + " не инициализирован (файл не получилось создать)");
    }
}
