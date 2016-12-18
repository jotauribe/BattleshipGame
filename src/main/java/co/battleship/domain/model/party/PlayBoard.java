package co.battleship.domain.model.party;

import co.battleship.domain.model.map.Map;
import co.battleship.domain.model.map.Position;
import co.battleship.domain.model.player.PlayerId;
import co.battleship.domain.model.ship.Ship;

import java.util.List;

/**
 * Created by jotauribe on 14/12/16.
 */
public class PlayBoard {

    private PlayerId ownerId;

    private Map fleetMap;

    public PlayBoard(PlayerId ownerId, Map fleetMap){
        setOwnerId(ownerId);
        setFleetMap(fleetMap);
    }

    public void setOwnerId(PlayerId ownerId){
        if(ownerId == null)
            throw new IllegalArgumentException("PlayerId can not be null");
        this.ownerId = ownerId;
    }

    public void setFleetMap(Map fleetMap){
        if(fleetMap == null)
            throw new IllegalArgumentException("Fleet Map can not be null");
        this.fleetMap = fleetMap;
    }

    public boolean shootAt(Position position){
        return true;
    }


}
