package co.battleship.domain.model.player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jotauribe on 13/12/16.
 */
public class Nickname {

    private static final String NICKNAME_REGULAR_EXPRESSION = "\\w{2,16}";

    private String nickname;

    public Nickname(String nickname){
        setNickname(nickname);
    }

    private boolean isAValidNickname(String string){
        return string.matches(NICKNAME_REGULAR_EXPRESSION);
    }

    private void setNickname(String nickname){
        if(nickname == null)
            throw new IllegalArgumentException("Nickname can not be null");

        if(!isAValidNickname(nickname))
            throw new IllegalArgumentException("Invalid nickname");

        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nickname)) return false;

        Nickname nickname1 = (Nickname) o;

        return nickname.equals(nickname1.nickname);

    }

    @Override
    public int hashCode() {
        return nickname.hashCode();
    }

    @Override
    public String toString() {
        return nickname;
    }
}

