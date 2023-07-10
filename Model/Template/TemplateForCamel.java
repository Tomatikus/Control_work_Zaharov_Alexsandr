package Model.Template;

import Model.Animals.Animals;
import Model.Animals.Camel;

import java.time.LocalDate;
import java.util.List;

public class TemplateForCamel extends TemplateForAnimals {

    public Animals templateForReadFileCamel (String oneLine) {

        List<Object> templateForAllAnimals = ForReadFile(oneLine);

        return new Camel(
                (String) templateForAllAnimals.get(0),
                (Character) templateForAllAnimals.get(1),
                (LocalDate) templateForAllAnimals.get(2),
                (List<String>) templateForAllAnimals.get(3),
                Integer.parseInt((String) templateForAllAnimals.get(4)),
                Integer.parseInt((String) templateForAllAnimals.get(5)));
    }

    public String templateForWriteFileCamel(Camel camel) {

        return( ForWriteFile(camel) + "; "
                + camel.getSpeedKmH() + "; "
                + camel.getPowerReserveKm()
                );
    }

}
