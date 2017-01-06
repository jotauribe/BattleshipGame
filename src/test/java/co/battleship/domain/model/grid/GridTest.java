package co.battleship.domain.model.grid;

import co.battleship.domain.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jotauribe on 13/12/16.
 */
public class GridTest {

    private Grid grid;

    private Ship ship;

    private Coordinate coordinate;


    @Before
    public void beforeTest(){
        grid = new Grid(10, 10);
        ship = new Ship(5, 2);
        coordinate = new Coordinate(0, 0);
    }

    @Test
    public void placeShip_GivenAValidLocation_ShipCorrectlyLocated(){
         grid.placeShip(ship, coordinate, Orientation.HORIZONTAL);
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void placeShip_GivenAInvalidLocation_ExceptionThrown(){
        Coordinate secondCoordinate = new Coordinate(1,2);
        grid.placeShip(ship, coordinate, Orientation.HORIZONTAL);
        grid.placeShip(ship, secondCoordinate, Orientation.VERTICAL);
    }

}