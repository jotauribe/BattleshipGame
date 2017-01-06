package co.battleship.domain.model.party;

import co.battleship.domain.model.grid.Coordinate;
import co.battleship.domain.model.grid.Grid;
import co.battleship.domain.model.player.PlayerId;

/**
 * Created by jotauribe on 14/12/16.
 */
public class PlayBoard {

    private PlayerId ownerId;

    private Grid grid;

    private PlayBoard(PlayerId ownerId, Grid grid){
        setOwnerId(ownerId);
        setGrid(grid);
    }

    private void setOwnerId(PlayerId ownerId){
        if(ownerId == null)
            throw new IllegalArgumentException("PlayerId can not be null");
        this.ownerId = ownerId;
    }

    private void setGrid(Grid grid){
        if(grid == null)
            throw new IllegalArgumentException("Fleet Grid can not be null");
        this.grid = grid;
    }

    public PlayBoard create(PlayerId ownerId){
        Grid defaultDimensionsGrid = Grid.create();
        return  new PlayBoard(ownerId, defaultDimensionsGrid);
    }

    public boolean shootAt(Coordinate coordinate){
        return true;
    }


}
