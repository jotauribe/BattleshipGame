package co.battleship.domain.model.party;

import co.battleship.domain.model.player.PlayerId;

import java.util.Set;

/**
 * Created by jotauribe on 13/12/16.
 */
public class Party {

    private PartyId partyId;

    private PartyState state;

    private int turnCounter;

    private Set<PlayBoard> contenders;
    
    private PlayerId ownerId;

    private Party(PlayerId ownerId){
        partyId = PartyId.generate();
        state = PartyState.CREATED;
        setOwnerId(ownerId);
    }

    private void setOwnerId(PlayerId ownerId){
        if(ownerId == null)
            throw new IllegalArgumentException("A non null Owner Id must be provided");
        this.ownerId = ownerId;
    }

    public static Party create(PlayerId ownerId){
        return new Party(ownerId);
    }

    public void addContender(PlayerId playerId){

    }

}