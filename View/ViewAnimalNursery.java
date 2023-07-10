package View;

import Controller.ControllerAnimalNursery;
import Model.Animals.*;
import Model.LibraryExceptionForFile.NotInitializationFileException;
import Model.LibraryExceptionForFile.ReadingNotMadeInFileException;
import Model.LibraryExceptionForFile.RecordNotMadeInFileException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewAnimalNursery {

    private ControllerAnimalNursery controllerAnimalNursery;

    private ValidationFIO validationFIO;

    private ValidationGender validationGender;

    private ValidationData validationData;

    private ValidationNamber validationNamber;


    public ViewAnimalNursery(ControllerAnimalNursery controllerAnimalNursery,
                             ValidationFIO validationFIO,
                             ValidationGender validationGender,
                             ValidationData validationData,
                             ValidationNamber validationNamber) {

        this.controllerAnimalNursery = controllerAnimalNursery;

        this.validationFIO = validationFIO;

        this.validationGender = validationGender;

        this.validationData = validationData;

        this.validationNamber = validationNamber;
    }

    public void menu() {

        Commands managementCommands;

        viewHi();

        while (true) {

            String command = viewPrompt("Введите команду: ");


            try {

                managementCommands = Commands.valueOf(command.toUpperCase());

                switch (managementCommands) {
                    case HELP:
                        viewAllCommands();
                        break;
                    case VIEW_ALL_ANIMALS:
                        viewAllAnimals();
                        break;
                    case ADD_ANIMAL:
                        viewAddOneAnimals();
                        break;
                    case ADD_COMMAND_FOR_ANIMAL:
                        viewAddOneCommandForAnimals();
                        break;
                    case DELL_ANIMAL:
                        viewDellOneAnimal();
                        break;
                    case EXIT:
                        viewExit();
                        return;
                }
            }
            catch (Exception ex) {

                viewErrorMessage(ex.getMessage());
            }
        }
    }


    private void viewErrorMessage(String textError) {

        boolean flagMessage = textError.contains("No enum constant");

        if (flagMessage) {

            System.out.println("Комманда не найдена");
        }
        else {

            System.out.println(textError);
        }
    }


    private void viewHi() {

        System.out.print("\n" + "Начни работу с команды HELP" + "\n"
                + "Регистр при вводе команд значения не имеет" + "\n"+ "\n");

    }


    private String viewPrompt(String message) {

        Scanner in = new Scanner(System.in);

        System.out.print(message);

        return in.nextLine();
    }


    private void viewAllCommands() {

        Commands[] arrayCommand = Commands.values();

        System.out.print("""

                Список имеющихся команд:
                """);

        for (Commands item: arrayCommand) {

            System.out.println(item);

        }

        System.out.print("\n");

    }


    private void viewAllAnimals() {

        List<Animals> allAnimals = new ArrayList<>();

        try {

            allAnimals = controllerAnimalNursery.controllerGetAllAnimals();

        }
        catch (ReadingNotMadeInFileException | NotInitializationFileException message) {

            message.printStackTrace();

        }

        if (!allAnimals.isEmpty()) {

            System.out.print("\n");

            int count = 1;

            for (Animals animal : allAnimals) {

                System.out.println(count + "#- " + animal.getClass().getSimpleName()  + "- " +  animal);

                count++;

            }

            System.out.print("\n");
        }
        else {

            System.out.print("В питомнике нет животных"+"\n");

        }
    }

    /*
    Метод реализовал не доконца из-за нехватки времени:
    1) можно добавить животных только двух типов
    (собаку и верблюда).
    Для ввода остальных не успел написать соовующие методы исключения.

    2) Данный метод необходимо разбить на несколько подметодов
    (он слишком длинный и поэтому его сложно читать/воспринимать)
    чего не было сделано также из-за нехватки времени.
    */
    private void viewAddOneAnimals() {

        boolean stopFlag = true;

        Integer speedKmH = null;

        String newAnimal = null;

        String placeResidence = null;

        while (stopFlag) {

            System.out.print("\n" + "Можно добавить: Собаку, Верблюда" + "\n");

            System.out.print("\n" + "Регистр при вводе команд значения не имеет" + "\n" + "\n");

            newAnimal = viewPrompt("Какое животное хотите добавить: ").toUpperCase();

            if (newAnimal.equals("СОБАКУ") | newAnimal.equals("ВЕРБЛЮДА") ) {

                stopFlag = false;
            }

        }

        String nickname = viewСheckNickname("Введите кличку: ");

        char gender = viewСheckGender("Пол (M-мужской/Ж-женский): ").charAt(0);

        LocalDate birthday = LocalDate.parse(viewСheckData("Введите дату в формате dd-mm-yyyy: "),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        if (newAnimal.equals("СОБАКУ")) {

            placeResidence = viewСheckNickname("Введите место проживания: ");

        } else {

            speedKmH =
                    Integer.valueOf(
                            viewСheckNamber("Скорость с которой передвигается животное, км/ч: "));
        }

            /*
            Ввод команд для животного -> commands "не обвязан исключениями" так как больше нет времени
            работать над данным зананием/программой.
            */

        String[] commands =
                viewPrompt("Введите через запятую команды (в формате команда1, команда2): ").split(", ");

        List<String> comnandsForAnimal = new ArrayList<>(Arrays.asList(commands));

        Animals animal = null;

        switch (newAnimal) {
            case "СОБАКУ" -> {
                String purposeBree =
                        viewСheckNickname("Предназначение породы собаки (боевая/сторожевая): ");
                animal = new Dog(nickname, gender, birthday, comnandsForAnimal,
                        placeResidence, purposeBree);
            }
            case "ВЕРБЛЮДА" -> {
                Integer powerReserveKm =
                        Integer.valueOf(
                                viewСheckNamber("Введите запас хода по пустыне, км: "));
                animal = new Camel(nickname, gender, birthday, comnandsForAnimal,
                        speedKmH, powerReserveKm);
            }
        }

        try {

            controllerAnimalNursery.controllerAddOneAnimals(animal);

        }
        catch (NotInitializationFileException
             | RecordNotMadeInFileException
             | ReadingNotMadeInFileException message) {

            message.printStackTrace();

        }
    }

    private void viewAddOneCommandForAnimals()  {

        List<Animals> allAnimals = new ArrayList<>();

        try {

            allAnimals = controllerAnimalNursery.controllerGetAllAnimals();

        }
        catch (ReadingNotMadeInFileException
             | NotInitializationFileException message) {

            message.printStackTrace();

        }

        if (allAnimals.size() >= 1) {

            int namberAnimals;

            String command;

            while (true) {

                namberAnimals = Integer.parseInt(viewСheckNamber("Номер животного в списке: "));

                namberAnimals--;

                if (namberAnimals >= 0 && namberAnimals <= (allAnimals.size() - 1)) {

                    command = viewСheckNickname("Команда: ");

                    break;
                }
            }

            Animals animal = allAnimals.get(namberAnimals);

            animal.addOneCommand(command);

            try {

                controllerAnimalNursery.controllerSaveAllAnimals(allAnimals);

            }

            catch (RecordNotMadeInFileException |
                   NotInitializationFileException message) {

                message.printStackTrace();

            }

        } else {
            System.out.println("В питомнике нет животных ");
        }

    }

    private void viewDellOneAnimal() {

        List<Animals> allAnimals = new ArrayList<>();

        try {

            allAnimals = controllerAnimalNursery.controllerGetAllAnimals();

        }
        catch (ReadingNotMadeInFileException
               | NotInitializationFileException message) {

            message.printStackTrace();

        }

        if (allAnimals.size() >= 1) {

            int namberAnimals;

            while (true) {

                namberAnimals = Integer.parseInt(viewСheckNamber("Номер животного в списке: "));

                namberAnimals--;

                if (namberAnimals >= 0 && namberAnimals <= (allAnimals.size() - 1)) {

                    break;
                }
            }

            allAnimals.remove(namberAnimals);

            try {

                controllerAnimalNursery.controllerSaveAllAnimals(allAnimals);

            }

            catch (RecordNotMadeInFileException |
                   NotInitializationFileException message) {

                message.printStackTrace();

            }

        } else {
            System.out.println("В питомнике нет животных ");
        }

    }


    private void viewExit() {

        System.out.println("Приходите снова в наш питомник !");
    }

    private String viewСheckNickname(String textForUser) {

        String data = "";

        while (true) {
            try {
                data = viewPrompt(textForUser);
                validationFIO.inputData(data);
                return data;
            }
            catch(RuntimeException message) {
                System.out.println(message.getMessage());
            }
        }
    }

    private String viewСheckGender(String textForUser) {

        String data = "";

        while (true) {
            try {
                data = viewPrompt(textForUser);
                validationGender.inputData(data);
                return data;
            }
            catch(RuntimeException message) {
                System.out.println(message.getMessage());
            }
        }
    }

    private String viewСheckData(String textForUser) {

        String data = "";

        while (true) {
            try {
                data = viewPrompt(textForUser);
                validationData.inputData(data);
                return data;
            }
            catch(RuntimeException message) {
                System.out.println(message.getMessage());
            }
        }
    }

    private String viewСheckNamber(String textForUser) {

        String data = "";

        while (true) {
            try {
                data = viewPrompt(textForUser);
                validationNamber.inputData(data);
                return data;
            }
            catch(RuntimeException message) {
                System.out.println(message.getMessage());
            }
        }
    }

}
