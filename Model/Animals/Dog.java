package Model.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Dog extends Pets {

    private String purposeBree = null;

    public Dog(String nickname, char gander, LocalDate birthday,
               List<String> commands, String placeResidence, String purposeBree) {

        super(nickname, gander, birthday, commands, placeResidence);

        this.purposeBree = purposeBree;
    }

    public String getPurposeBree() {
        return purposeBree;
    }

    public void setPurposeBree(String purposeBree) {
        this.purposeBree = purposeBree;
    }

    @Override
    public String toString() {

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

        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDateBirthday = birthday.format(formatData);

        return "Кличка: " + nickname + " "
                + "Пол: " + gander + " "
                + "День рождения: " + formattedDateBirthday + " "
                + "Команды: " + allCommand + " "
                + "Место содержания/нахождения: " + placeResidence + " "
                + "Предназначение породы пса: " + purposeBree;
    }
}