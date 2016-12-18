package co.battleship.domain.service;

import co.battleship.domain.model.party.PartyRepository;
import co.battleship.domain.model.player.Player;
import co.battleship.domain.model.player.PlayerId;

/**
 * Created by jotauribe on 16/12/16.
 */
public class CreatePartyService {

    private PartyRepository partyRepository;

    public CreatePartyService(PartyRepository partyRepository){
        this.partyRepository = partyRepository;
    }

    public String execute(PlayerId playerId){
        return null;
    }

}
