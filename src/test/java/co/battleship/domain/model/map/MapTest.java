package co.battleship.domain.model.map;

import co.battleship.domain.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jotauribe on 13/12/16.
 */
public class MapTest {

    private Map map;

    private Ship ship;

    private Position position;


    @Before
    public void beforeTest(){
        map = new Map(10, 10);
        ship = new Ship(5, 2);
        position = new Position(0, 0);
    }

    @Test
    public void placeShip_GivenAValidLocation_ShipCorrectlyLocated(){
         map.placeShip(ship, position, Plane.HORIZONTAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void placeShip_GivenAInvalidLocation_ThrowsException(){
        Position secondPosition = new Position(1,2);
        map.placeShip(ship, position, Plane.HORIZONTAL);
        map.placeShip(ship, secondPosition, Plane.VERTICAL);
    }

}