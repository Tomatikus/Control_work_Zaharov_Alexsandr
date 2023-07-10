package Model.Animals;

import java.time.LocalDate;
import java.util.List;

public abstract class Pets extends Animals {

    protected String placeResidence = null;

    public Pets(String nickname, char gander, LocalDate birthday,
                List<String> commands, String placeResidence) {

        super(nickname, gander, birthday, commands);

        this.placeResidence = placeResidence;

    }

    public String getPlaceResidence() {
        return placeResidence;
    }

    public void setPlaceResidence(String placeResidence) {
        this.placeResidence = placeResidence;
    }
}