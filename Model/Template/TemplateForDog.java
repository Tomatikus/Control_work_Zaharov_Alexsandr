package Model.Template;

import Model.Animals.Animals;
import Model.Animals.Dog;

import java.time.LocalDate;
import java.util.List;

public class TemplateForDog extends TemplateForAnimals {

    public Animals templateForReadFileDog(String oneLine) {

        List<Object> templateForAllAnimals = ForReadFile(oneLine);

        return new Dog(
                (String) templateForAllAnimals.get(0),
                (Character) templateForAllAnimals.get(1),
                (LocalDate) templateForAllAnimals.get(2),
                (List<String>) templateForAllAnimals.get(3),
                (String) templateForAllAnimals.get(4),
                (String) templateForAllAnimals.get(5));
    }

    public String templateForWriteFileDog(Dog dog) {

        return( ForWriteFile(dog) + "; "
                + dog.getPlaceResidence() + "; "
                + dog.getPurposeBree()
                );
    }

}
