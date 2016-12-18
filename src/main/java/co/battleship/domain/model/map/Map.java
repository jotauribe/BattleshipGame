package co.battleship.domain.model.map;

import co.battleship.domain.model.ship.Ship;

import java.util.Hashtable;

/**
 * Created by jotauribe on 12/12/16.
 */
public class Map {

    private static final int WATER = 0;

    private static final int SHIP = 1;

    private static final int HIT = 2;

    private int length;

    private int width;

    private int[][] grid;

    private Hashtable<Integer, Integer> shipLifeCounters;

    public Map(int length, int width){
        this.length = length;
        this.width = width;
        initMap(length, width);
        shipLifeCounters = new Hashtable<>();
    }

    private void initMap(int length, int width){
        grid = new int[length][width];

        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++)
                grid[i][j] = Map.WATER;

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
                    if(grid[ i ][ j ] != WATER)
                        return false;

        return true;
    }

    private boolean isValidArea(Ship ship, Position position, Orientation orientation){

        Position topRigthPosition = position;
        int length, width;

        if(orientation == Orientation.HORIZONTAL)
            if ((position.horizontalPosition() + ship.length()) > this.width
                    || position.verticalPosition() + ship.width() > this.length)
                return false;

        if(orientation == Orientation.VERTICAL)
            if ((position.horizontalPosition() + ship.width()) > this.width
                    || position.verticalPosition() + ship.length() > this.length)
                return false;

        return true;
    }

    private void addLifeCounter(int identifier, int life){
        shipLifeCounters.put(identifier, life);
    }

    public void placeShip(Ship ship, Position position, Orientation orientation){

        if(!isValidPosition(position))
            throw new IllegalArgumentException("Origin position is not valid");

        if(!isValidArea(ship, position, orientation))
            throw new IllegalArgumentException("Invalid Location");

        if(!isFreeSpace(position, ship.length(), ship.width()))
            throw new IllegalArgumentException("Selected area is not free");

        int identifier = shipLifeCounters.size()*100;

        if(orientation == Orientation.HORIZONTAL)
            for (int i = position.verticalPosition(); i <= ship.length(); i++)
                for (int j = position.horizontalPosition(); j <= ship.width(); j++)
                    grid[ i ][ j ] = identifier;

        if(orientation == Orientation.VERTICAL)
            for (int i = position.verticalPosition(); i <= ship.width(); i++)
                for (int j = position.horizontalPosition(); j <= ship.length(); j++)
                    grid[ i ][ j ] = identifier;

        addLifeCounter(identifier, ship.totalLife());

    }

}
