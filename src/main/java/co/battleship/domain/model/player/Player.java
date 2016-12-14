package co.battleship.domain.model.player;

/**
 * Created by jotauribe on 13/12/16.
 */
public class Player {

    private static final int NICKNAME_MAX_LENGTH = 16;

    private PlayerId id;

    private Nickname nickname;

    public Player(String nickname){
        this.nickname = new Nickname(nickname);
        id = PlayerId.Random();
    }

    public Nickname nickname(){
        return nickname;
    }

    public PlayerId playerId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        return id.equals(player.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
