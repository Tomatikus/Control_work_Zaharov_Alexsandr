package Model.Template;

import Model.Animals.Animals;
import Model.Animals.Donkey;

import java.time.LocalDate;
import java.util.List;

public class TemplateForDonkey extends TemplateForAnimals {

    public Animals templateForReadFileDonkey (String oneLine) {

        List<Object> templateForAllAnimals = ForReadFile(oneLine);

        return new Donkey(
                (String) templateForAllAnimals.get(0),
                (Character) templateForAllAnimals.get(1),
                (LocalDate) templateForAllAnimals.get(2),
                (List<String>) templateForAllAnimals.get(3),
                Integer.parseInt((String) templateForAllAnimals.get(4)),
                Integer.parseInt((String) templateForAllAnimals.get(5)));
    }

    public String templateForWriteFileDonkey(Donkey donkey) {

        return( ForWriteFile(donkey) + "; "
                + donkey.getSpeedKmH() + "; "
                + donkey.getLoadCapacityKg()
                );
    }

}
