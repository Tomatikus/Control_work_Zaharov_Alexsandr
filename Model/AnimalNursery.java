package Model;

import Model.Animals.*;
import Model.LibraryExceptionForFile.NotInitializationFileException;
import Model.LibraryExceptionForFile.ReadingNotMadeInFileException;
import Model.LibraryExceptionForFile.RecordNotMadeInFileException;
import Model.Template.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalNursery {

    private final FileOperator fileOperator;
    private final TemplateForCat templateForCat;
    private final TemplateForDog templateForDog;
    private final TemplateForHamster templateForHamster;
    private final TemplateForHorse templateForHorse;
    private final TemplateForDonkey templateForDonkey;
    private final TemplateForCamel templateForCamel;


    public AnimalNursery(FileOperator fileOperator,
                         TemplateForDog templateForDog,
                         TemplateForCat templateForCat,
                         TemplateForHamster templateForHamster,
                         TemplateForHorse templateForHorse,
                         TemplateForDonkey templateForDonkey,
                         TemplateForCamel templateForCamel) {

        this.fileOperator = fileOperator;
        this.templateForDog = templateForDog;
        this.templateForCat = templateForCat;
        this.templateForHamster = templateForHamster;
        this.templateForHorse = templateForHorse;
        this.templateForDonkey = templateForDonkey;
        this.templateForCamel = templateForCamel;
    }


    public List<Animals> getAllAnimals()
            throws NotInitializationFileException,
                   ReadingNotMadeInFileException {

        fileOperator.initWorkFiles();

        return sortReadData(fileOperator.readAllFiles());

    }

    public void setAllAnimals(List<Animals> animals)
            throws NotInitializationFileException,
                   RecordNotMadeInFileException {

        fileOperator.initWorkFiles();

        fileOperator.writeAllFile(sortWriteata(animals));

    }

    private List<Animals> sortReadData(List<List<String>> allLinesReadFromAllFile) {

        List<Animals> allAnimals = new ArrayList<>();

        int countAnimal = 1;

        for (List<String> linesReadFromOneFile : allLinesReadFromAllFile) {

            for (String oneLineFromOneFile : linesReadFromOneFile) {

                switch (countAnimal) {
                    case 1:
                        allAnimals.add(templateForDog.templateForReadFileDog(oneLineFromOneFile));
                        break;
                    case 2:
                        allAnimals.add(templateForCat.templateForReadFileCat(oneLineFromOneFile));
                        break;
                    case 3:
                        allAnimals.add(templateForHamster.templateForReadFileHamster(oneLineFromOneFile));
                        break;
                    case 4:
                        allAnimals.add(templateForHorse.templateForReadFileHorse(oneLineFromOneFile));
                        break;
                    case 5:
                        allAnimals.add(templateForDonkey.templateForReadFileDonkey(oneLineFromOneFile));
                        break;
                    case 6:
                        allAnimals.add(templateForCamel.templateForReadFileCamel(oneLineFromOneFile));
                        break;
                }

            }

            countAnimal++;

        }

        return allAnimals;

    }


    private List<List<String>> sortWriteata(List<Animals> animals) {

        int numberAnimalTypes = fileOperator.countFile();

        List<List<Animals>> allListAnimals = new ArrayList<>();

        List<List<String>> allLinesWriteFromFile = new ArrayList<>();

        for (int i = 1; i <= numberAnimalTypes; i++) {

            List<Animals> byffer = new ArrayList<>();

            for (Animals animal : animals) {

                String className = animal.getClass().getSimpleName();

                switch (i) {
                    case 1:
                        if (className.equals("Dog")) {
                            byffer.add(animal);
                        }
                        break;
                    case 2:
                        if (className.equals("Cat")) {
                            byffer.add(animal);
                        }
                        break;
                    case 3:
                        if (className.equals("Hamster")) {
                            byffer.add(animal);
                        }
                        break;
                    case 4:
                        if (className.equals("Horse")) {
                            byffer.add(animal);
                        }
                        break;
                    case 5:
                        if (className.equals("Donkey")) {
                            byffer.add(animal);
                        }
                        break;
                    case 6:
                        if (className.equals("Camel")) {
                            byffer.add(animal);
                        }
                        break;
                }
            }

            allListAnimals.add(byffer);
        }

        for (List<Animals> listAnimals : allListAnimals) {

            List<String> byffer = new ArrayList<>();

            for (Animals animal : listAnimals) {

                String className = animal.getClass().getSimpleName();

                switch (className) {
                    case "Dog":
                        byffer.add(templateForDog.templateForWriteFileDog((Dog) animal));
                        break;
                    case "Cat":
                        byffer.add(templateForCat.templateForWriteFileCat((Cat) animal));
                        break;
                    case "Hamster":
                        byffer.add(templateForHamster.templateForWriteFileHamster((Hamster) animal));
                        break;
                    case "Horse":
                        byffer.add(templateForHorse.templateForWriteFileHorse((Horse) animal));
                        break;
                    case "Donkey":
                        byffer.add(templateForDonkey.templateForWriteFileDonkey((Donkey) animal));
                        break;
                    case "Camel":
                        byffer.add(templateForCamel.templateForWriteFileCamel((Camel) animal));
                        break;
                }
            }

            allLinesWriteFromFile.add(byffer);

        }

        return allLinesWriteFromFile;

    }
}