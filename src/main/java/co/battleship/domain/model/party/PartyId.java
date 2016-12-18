package co.battleship.domain.model.party;

import java.util.Random;
import java.util.UUID;

/**
 * Created by jotauribe on 14/12/16.
 */
public class PartyId {

    private String id;

    public PartyId(String id){
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

    public static PartyId create(){
        return new PartyId( UUID.randomUUID().toString() );
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartyId)) return false;

        PartyId partyId = (PartyId) o;

        return id.equals(partyId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
