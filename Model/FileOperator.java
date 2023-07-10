package Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.LibraryExceptionForFile.NotInitializationFileException;
import Model.LibraryExceptionForFile.ReadingNotMadeInFileException;
import Model.LibraryExceptionForFile.RecordNotMadeInFileException;

public class FileOperator implements FileOperatorMethods {

    private List<String> fileNames;

    public FileOperator(String fileNameDog, String fileNameCat, String fileNameHamster,
                        String fileNameHorse, String fileNameDonkey, String fileNameCamel) {

        List<String> fileNames = null;

        try {

            String formatFile = ".txt";

            Path dirForPets = Files.createDirectories(Paths.get("src", "Animals storage", "Pets"));

            Path dirForPack = Files.createDirectories(Paths.get("src", "Animals storage", "Pack animals"));

            fileNames = Arrays.asList(
                    dirForPets + "/" + fileNameDog + formatFile,
                    dirForPets + "/" + fileNameCat + formatFile,
                    dirForPets + "/" + fileNameHamster + formatFile,
                    dirForPack + "/" + fileNameHorse + formatFile,
                    dirForPack + "/" + fileNameDonkey + formatFile,
                    dirForPack + "/" + fileNameCamel + formatFile);

        }
        catch (IOException message) {

            System.out.println("Ошибка в имени файла !");

        }

        this.fileNames = fileNames;

    }

    @Override
    public void initWorkFiles() throws NotInitializationFileException {

        for(String fileName: fileNames) {

            try (FileWriter toСreateFile = new FileWriter(fileName, true)) {

                toСreateFile.flush();

            } catch (IOException message) {

                throw new NotInitializationFileException(fileName);

            }
        }
    }

    @Override
    public List<List<String>> readAllFiles() throws ReadingNotMadeInFileException {

        List<List<String>> allList = new ArrayList<>();

        for(String fileName: fileNames) {

            List<String> allLinesFromFile = new ArrayList<>();

            try (FileReader readFile = new FileReader(fileName)) {

                BufferedReader forReadOneLine = new BufferedReader(readFile);

                String line = forReadOneLine.readLine();

                if (line != null) {

                    allLinesFromFile.add(line);

                }
                while (line != null) {

                    line = forReadOneLine.readLine();

                    if (line != null) {

                        allLinesFromFile.add(line);
                    }
                }

                forReadOneLine.close();

            } catch (IOException ex) {

                throw new ReadingNotMadeInFileException(fileName);

            }

            allList.add(allLinesFromFile);
        }
        return allList;
    }

    @Override
    public void writeAllFile(List<List<String>> allList) throws RecordNotMadeInFileException {

        for (int i = 0; i < fileNames.size(); i++) {

            try (FileWriter fileToWrite = new FileWriter(fileNames.get(i), false)) {

                for (String line:  allList.get(i)) {
                    fileToWrite.write(line + "\n");
                }
                fileToWrite.flush();
            }
            catch (IOException ex) {

                throw new RecordNotMadeInFileException(fileNames.get(i));
            }
        }
    }

    public int countFile() {
        return fileNames.size();
    }

}