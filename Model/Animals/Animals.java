package Model.Animals;

import java.time.LocalDate;
import java.util.List;

public abstract class Animals {

    protected String nickname  = null;
    protected Character gander  = null;

    protected LocalDate birthday = null;

    protected List<String> commands = null;


    public Animals(String nickname, char gander,
                   LocalDate birthday, List<String> commands) {

        this.nickname = nickname;
        this.gander = gander;
        this.birthday = birthday;
        this.commands = commands;

    }

    public void addOneCommand(String oneCommand) {

        commands.add(oneCommand);
    }

    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public char getGander() {
        return gander;
    }

    public void setGander(char gander) {
        this.gander = gander;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
