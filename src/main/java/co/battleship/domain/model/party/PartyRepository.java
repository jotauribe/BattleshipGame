package co.battleship.domain.model.party;

/**
 * Created by jotauribe on 16/12/16.
 */
public interface PartyRepository {


    public Party partyOfId();

    public void save(Party party);

}
