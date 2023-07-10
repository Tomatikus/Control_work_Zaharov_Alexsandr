package Model.Animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Horse extends Pack {

    protected Boolean horseshoe = null;

    public Horse(String nickname, char gander, LocalDate birthday,
                 List<String> commands, Integer speedKmH, Boolean horseshoe) {

        super(nickname, gander, birthday, commands, speedKmH);

        this.horseshoe = horseshoe;
    }

    public Boolean getHorseshoe() {
        return horseshoe;
    }

    public void setHorseshoe(Boolean horseshoe) {
        this.horseshoe = horseshoe;
    }

    @Override
    public String toString() {

        StringBuilder allCommand = new StringBuilder();

        StringBuilder horseshoeAnswer = new StringBuilder();

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

        if (horseshoe) {

            horseshoeAnswer.append("Подкована");

        }
        else {

            horseshoeAnswer.append("Не подкована");

        }

        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDateBirthday = birthday.format(formatData);

        return "Кличка: " + nickname + " "
                + "Пол: " + gander + " "
                + "День рождения: " + formattedDateBirthday + " "
                + "Команды: " + allCommand + " "
                + "Скорость передвижения, км/ч: " + speedKmH + " "
                + "Подкована лошадь или нет: " + horseshoeAnswer;
    }
}