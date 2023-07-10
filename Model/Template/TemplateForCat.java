package Model.Template;

import Model.Animals.Animals;
import Model.Animals.Cat;

import java.time.LocalDate;
import java.util.List;

public class TemplateForCat extends TemplateForAnimals {

    public Animals templateForReadFileCat(String oneLine) {

        List<Object> templateForAllAnimals = ForReadFile(oneLine);

        return new Cat(
                (String) templateForAllAnimals.get(0),
                (Character) templateForAllAnimals.get(1),
                (LocalDate) templateForAllAnimals.get(2),
                (List<String>) templateForAllAnimals.get(3),
                (String) templateForAllAnimals.get(4),
                Boolean.parseBoolean((String) templateForAllAnimals.get(5)));
    }

    public String templateForWriteFileCat(Cat cat) {

        return( ForWriteFile(cat) + "; "
                + cat.getPlaceResidence() + "; "
                + cat.getCatchMouse()
                );
    }

}
