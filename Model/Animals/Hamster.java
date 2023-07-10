package Model.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hamster extends Pets {

    protected Integer cheekFoodWeightG = null;

    public Hamster(String nickname, char gander, LocalDate birthday,
                   List<String> commands, String placeResidence, Integer cheekFoodWeightKg) {

        super(nickname, gander, birthday, commands, placeResidence);

        this.cheekFoodWeightG = cheekFoodWeightKg;
    }

    public Integer getCheekFoodWeightKg() {
        return cheekFoodWeightG;
    }

    public void setCheekFoodWeightKg(Integer cheekFoodWeightKg) {
        this.cheekFoodWeightG = cheekFoodWeightKg;
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
                + "Вес еды за щекой, г: " + cheekFoodWeightG;
    }
}