package Model.Template;

import Model.Animals.Animals;
import Model.Animals.Horse;

import java.time.LocalDate;
import java.util.List;

public class TemplateForHorse extends TemplateForAnimals {

    public Animals templateForReadFileHorse (String oneLine) {

        List<Object> templateForAllAnimals = ForReadFile(oneLine);

        return new Horse(
                (String) templateForAllAnimals.get(0),
                (Character) templateForAllAnimals.get(1),
                (LocalDate) templateForAllAnimals.get(2),
                (List<String>) templateForAllAnimals.get(3),
                Integer.parseInt((String) templateForAllAnimals.get(4)),
                Boolean.parseBoolean((String) templateForAllAnimals.get(5)));
    }

    public String templateForWriteFileHorse(Horse horse) {

        return( ForWriteFile(horse) + "; "
                + horse.getSpeedKmH() + "; "
                + horse.getHorseshoe()
                );
    }

}
