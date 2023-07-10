package Model.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Camel extends Pack {

    protected Integer powerReserveKm = null;;

    public Camel(String nickname, char gander, LocalDate birthday,
                 List<String> commands, Integer speedKmH, Integer powerReserveKm) {

        super(nickname, gander, birthday, commands, speedKmH);

        this.powerReserveKm = powerReserveKm;
    }

    public Integer getPowerReserveKm() {
        return powerReserveKm;
    }

    public void setPowerReserveKm(Integer powerReserveKm) {
        this.powerReserveKm = powerReserveKm;
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
                + "Запас хода по пустыни, км: " + powerReserveKm;
    }
}