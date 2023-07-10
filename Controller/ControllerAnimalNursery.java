package Controller;

import Model.AnimalNursery;
import Model.Animals.Animals;
import Model.LibraryExceptionForFile.NotInitializationFileException;
import Model.LibraryExceptionForFile.ReadingNotMadeInFileException;
import Model.LibraryExceptionForFile.RecordNotMadeInFileException;

import java.util.List;


public class ControllerAnimalNursery {

    private AnimalNursery animalNursery;

    public ControllerAnimalNursery(AnimalNursery animalNursery) {

        this.animalNursery = animalNursery;

    }

    public List<Animals> controllerGetAllAnimals()
            throws ReadingNotMadeInFileException,
                   NotInitializationFileException {

        return animalNursery.getAllAnimals();
    }

    public void controllerAddOneAnimals(Animals animal)
            throws NotInitializationFileException,
                   RecordNotMadeInFileException,
                   ReadingNotMadeInFileException {

        List<Animals> allAnimal = animalNursery.getAllAnimals();

        allAnimal.add(animal);

        animalNursery.setAllAnimals(allAnimal);
    }

    public void controllerSaveAllAnimals(List<Animals> allAnimal)
            throws NotInitializationFileException,
                   RecordNotMadeInFileException {

        animalNursery.setAllAnimals(allAnimal);
    }

}
