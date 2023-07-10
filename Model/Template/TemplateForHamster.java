package Model.Template;

import Model.Animals.Animals;
import Model.Animals.Hamster;

import java.time.LocalDate;
import java.util.List;

public class TemplateForHamster extends TemplateForAnimals {

    public Animals templateForReadFileHamster(String oneLine) {

        List<Object> templateForAllAnimals = ForReadFile(oneLine);

        return new Hamster(
                (String) templateForAllAnimals.get(0),
                (Character) templateForAllAnimals.get(1),
                (LocalDate) templateForAllAnimals.get(2),
                (List<String>) templateForAllAnimals.get(3),
                (String) templateForAllAnimals.get(4),
                Integer.parseInt((String) templateForAllAnimals.get(5)));
    }

    public String templateForWriteFileHamster(Hamster hamster) {

        return( ForWriteFile(hamster) + "; "
                + hamster.getPlaceResidence() + "; "
                + hamster.getCheekFoodWeightKg()
                );
    }

}
