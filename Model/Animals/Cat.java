package Model.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Cat extends Pets {

    protected Boolean catchMouse = null;

    public Cat(String nickname, char gander, LocalDate birthday,
               List<String> commands, String placeResidence, Boolean catchMouse) {

        super(nickname, gander, birthday, commands, placeResidence);

        this.catchMouse = catchMouse;
    }

    public Boolean getCatchMouse() {
        return catchMouse;
    }

    public void setCatchMouse(Boolean catchMouse) {
        this.catchMouse = catchMouse;
    }

    @Override
    public String toString() {

        StringBuilder catchMouseAnswer = new StringBuilder();

        StringBuilder allCommand = new StringBuilder();

        if (commands != null) {

            int size = commands.size() - 1;

            for (int i = 0; i < size; i++) {

                allCommand.append(commands.get(i)).append(", ");

            }

            allCommand.append(commands.get(size));

        }
        else {

            allCommand = new StringBuilder("животное не знает не одной комманды");

        }

        if (catchMouse) {

            catchMouseAnswer.append("Ловит");

        }
        else {

            catchMouseAnswer.append("Не ловит");

        }

        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDateBirthday = birthday.format(formatData);

        return "Кличка: " + nickname + " "
                + "Пол: " + gander + " "
                + "День рождения: " + formattedDateBirthday + " "
                + "Команды: " + allCommand + " "
                + "Место содержания/нахождения: " + placeResidence + " "
                + "Ловит мышей: " + catchMouseAnswer;
    }
}