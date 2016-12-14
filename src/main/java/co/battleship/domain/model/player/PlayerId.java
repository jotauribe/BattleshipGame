package co.battleship.domain.model.player;

import java.util.Random;

/**
 * Created by jotauribe on 13/12/16.
 */
public class PlayerId {

    private String id;

    private PlayerId(){
        id = new Random().toString(); // TODO Change
    }

    public PlayerId(String id){
        setId(id);
    }

    private void setId(String id){
        if(id == null)
            throw new IllegalArgumentException("Id can not be null");
        this.id = id;
    }

    public String asString(){
        return id;
    }

    public static PlayerId Random(){
        int i = new Random().nextInt();
        return new PlayerId(i+"");
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerId)) return false;

        PlayerId playerId = (PlayerId) o;

        return id.equals(playerId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
