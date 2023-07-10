package Model;

import Model.LibraryExceptionForFile.NotInitializationFileException;
import Model.LibraryExceptionForFile.ReadingNotMadeInFileException;
import Model.LibraryExceptionForFile.RecordNotMadeInFileException;

import java.util.List;

public interface FileOperatorMethods {

    void initWorkFiles() throws NotInitializationFileException;

    List<List<String>> readAllFiles() throws ReadingNotMadeInFileException;

    void writeAllFile(List<List<String>> lists) throws RecordNotMadeInFileException;
}
