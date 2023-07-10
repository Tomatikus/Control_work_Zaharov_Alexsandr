package Model.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Donkey extends Pack {

    protected Integer loadCapacityKg = null;;

    public Donkey(String nickname, char gander, LocalDate birthday,
                  List<String> commands, Integer speedKmH, Integer loadCapacityKg) {

        super(nickname, gander, birthday, commands, speedKmH);

        this.loadCapacityKg = loadCapacityKg;
    }

    public Integer getLoadCapacityKg() {
        return loadCapacityKg;
    }

    public void setLoadCapacityKg(Integer loadCapacityKg) {
        this.loadCapacityKg = loadCapacityKg;
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
                + "Скорость передвижения, км/ч: " + speedKmH + " "
                + "Грузоподъемность, кг: " + loadCapacityKg;
    }
}