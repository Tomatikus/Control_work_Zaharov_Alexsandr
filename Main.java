import Controller.ControllerAnimalNursery;
import Model.*;
import Model.Template.*;
import View.*;


public class Main {
    public static void main(String[] args) {

        FileOperator fileOperator =
                new FileOperator("Dog", "Cat" ,"Hamster",
                                "Horse","Donkey", "Camel");

        TemplateForCat templateForCat = new TemplateForCat();
        TemplateForDog templateForDog = new TemplateForDog();
        TemplateForHamster templateForHamster = new TemplateForHamster();
        TemplateForHorse templateForHorse = new TemplateForHorse();
        TemplateForDonkey templateForDonkey = new TemplateForDonkey();
        TemplateForCamel templateForCame = new TemplateForCamel();

        AnimalNursery animalNursery = new AnimalNursery(fileOperator,
                                                        templateForDog,
                                                        templateForCat,
                                                        templateForHamster,
                                                        templateForHorse,
                                                        templateForDonkey,
                                                        templateForCame);

        ControllerAnimalNursery controllerAnimalNursery = new ControllerAnimalNursery(animalNursery);

        ValidationFIO validationFIO = new ValidationFIO();
        ValidationGender validationGender = new ValidationGender();
        ValidationData validationData = new ValidationData();
        ValidationNamber validationNamber = new ValidationNamber();

        ViewAnimalNursery viewAnimalNursery = new ViewAnimalNursery(controllerAnimalNursery,
                                                                    validationFIO,
                                                                    validationGender,
                                                                    validationData,
                                                                    validationNamber);

        viewAnimalNursery.menu();
    }
}