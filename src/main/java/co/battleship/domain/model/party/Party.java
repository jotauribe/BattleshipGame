package co.battleship.domain.model.party;

import co.battleship.domain.model.player.Player;
import co.battleship.domain.model.player.PlayerId;

import java.util.Set;

/**
 * Created by jotauribe on 13/12/16.
 */
public class Party {

    private PartyId partyId;

    private PartyState state;

    private int turnCounter;

    private Set<Player> contenders;
    
    private PlayerId ownerId;

    public Party(PlayerId playerId, PartyId partyId){

    }

    private void setPartyId(String id){
        this.partyId = PartyId.create();
    }

    public void addContender(PlayerId playerId){

    }

}