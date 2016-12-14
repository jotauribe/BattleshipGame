package co.battleship.domain.model.map;

import co.battleship.domain.model.ship.Ship;

/**
 * Created by jotauribe on 12/12/16.
 */
public class Map {

    private static final int WATER = 0;

    private static final int SHIP = 1;

    private static final int HIT = 2;

    private int length;

    private int width;

    private int[][] map;

    public Map(int length, int width){
        this.length = length;
        this.width = width;
        initMap(length, width);
    }

    private void initMap(int length, int width){
        map = new int[length][width];

        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++)
                map[i][j] = Map.WATER;

    }

    public int area(){
        return length * width;
    }

    public boolean isValidPosition(Position position){
        return (position.verticalPosition() <= length)
                && (position.horizontalPosition() <= width);
    }

    public boolean isFreeSpace(Position origin, int downEnd, int rigthEnd){

            for (int i = origin.verticalPosition(); i <= downEnd; i++)
                for (int j = origin.horizontalPosition(); j <= rigthEnd; j++)
                    if(map[ i ][ j ] != WATER)
                        return false;

        return true;
    }

    private boolean isValidArea(Ship ship, Position position, Direction direction){

        Position topRigthPosition = position;
        int length, width;

        if(direction == Direction.HORIZONTAL)
            if ((position.horizontalPosition() + ship.length()) > this.width
                    || position.verticalPosition() + ship.width() > this.length)
                return false;

        if(direction == Direction.VERTICAL)
            if ((position.horizontalPosition() + ship.width()) > this.width
                    || position.verticalPosition() + ship.length() > this.length)
                return false;

        return true;
    }

    //private void check

    public void placeShip(Ship ship, Position position, Direction direction){

        if(!isValidPosition(position))
            throw new IllegalArgumentException("Origin position is not valid");

        if(!isValidArea(ship, position, direction))
            throw new IllegalArgumentException("Invalid Location");

        if(!isFreeSpace(position, ship.length(), ship.width()))
            throw new IllegalArgumentException("Selected area is not free");

        if(direction == Direction.HORIZONTAL)
            for (int i = position.verticalPosition(); i <= ship.length(); i++)
                for (int j = position.horizontalPosition(); j <= ship.width(); j++)
                    map[ i ][ j ] = SHIP;


        if(direction == Direction.VERTICAL)
            for (int i = position.verticalPosition(); i <= ship.width(); i++)
                for (int j = position.horizontalPosition(); j <= ship.length(); j++)
                    map[ i ][ j ] = SHIP;

    }

}
