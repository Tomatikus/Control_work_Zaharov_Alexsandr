package Model.Template;

import Model.Animals.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TemplateForAnimals {

    protected List <Object> ForReadFile(String oneLine) {

        List<Object> templateForAllAnimals = new ArrayList<>();

        String[] partsForAnimal = oneLine.split("; ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(partsForAnimal[2], formatter);

        String[] commands = partsForAnimal[3].split(", ");

        List<String> comnandsForAnimal = new ArrayList<>(Arrays.asList(commands));

        templateForAllAnimals.add(partsForAnimal[0]);
        templateForAllAnimals.add(partsForAnimal[1].charAt(0));
        templateForAllAnimals.add(date);
        templateForAllAnimals.add(comnandsForAnimal);
        templateForAllAnimals.add(partsForAnimal[4]);
        templateForAllAnimals.add(partsForAnimal[5]);

        return templateForAllAnimals;

    }

    public String ForWriteFile(Animals animal) {

        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDateBirthday = animal.getBirthday().format(formatData);

        StringBuilder allCommand = new StringBuilder();

        if (animal.getCommands() != null) {

            int size = animal.getCommands().size() - 1;

            for (int i = 0; i < size; i++) {

                allCommand.append(animal.getCommands().get(i)).append(", ");

            }

            allCommand.append(animal.getCommands().get(size));

        }

        else {

            allCommand = new StringBuilder();

        }

        return(   animal.getNickname() + "; "
                + animal.getGander() + "; "
                + formattedDateBirthday + "; "
                + allCommand
                );
    }
}
