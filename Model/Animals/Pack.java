package Model.Animals;

import java.time.LocalDate;
import java.util.List;

public abstract class Pack extends Animals {

    protected Integer speedKmH = null;

    public Pack(String nickname, char gander, LocalDate birthday,
                List<String> commands, Integer speedKmH) {

        super(nickname, gander, birthday, commands);

        this.speedKmH = speedKmH;

    }

    public Integer getSpeedKmH() {
        return speedKmH;
    }

    public void setSpeedKmH(Integer speedKmH) {
        this.speedKmH = speedKmH;
    }
}