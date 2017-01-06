package co.battleship.domain.model.grid;

import co.battleship.domain.model.party.DefaultSettings;
import co.battleship.domain.model.ship.Ship;

import java.util.Hashtable;

/**
 * Created by jotauribe on 12/12/16.
 */
public class Grid {

    private static final int WATER = 0;

    private int length;

    private int width;

    private int[][] grid;

    private Hashtable<Integer, Integer> shipLifeCounters;

    public Grid(int length, int width){
        this.length = length;
        this.width = width;
        initMap(length, width);
        shipLifeCounters = new Hashtable<>();
    }

    private void initMap(int length, int width){
        grid = new int[length][width];

        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++)
                grid[i][j] = Grid.WATER;

    }

    public static Grid create(){
        return new Grid(DefaultSettings.GRID_LENGTH, DefaultSettings.GRID_WIDTH);
    }

    public int area(){
        return length * width;
    }

    public boolean isValidPosition(Coordinate coordinate){
        return (coordinate.verticalPosition() <= length)
                && (coordinate.horizontalPosition() <= width);
    }

    public boolean isFreeSpace(Coordinate origin, int downEnd, int rigthEnd){

            for (int i = origin.verticalPosition(); i <= downEnd; i++)
                for (int j = origin.horizontalPosition(); j <= rigthEnd; j++)
                    if(grid[ i ][ j ] != WATER) return false;

        return true;
    }

    private boolean isValidArea(Ship ship, Coordinate coordinate, Orientation orientation){

        Coordinate topRigthCoordinate = coordinate;
        int length, width;

        if(orientation == Orientation.HORIZONTAL)
            if ((coordinate.horizontalPosition() + ship.length()) > this.width
                    || coordinate.verticalPosition() + ship.width() > this.length)
                return false;

        if(orientation == Orientation.VERTICAL)
            if ((coordinate.horizontalPosition() + ship.width()) > this.width
                    || coordinate.verticalPosition() + ship.length() > this.length)
                return false;

        return true;
    }

    private void addLifeCounter(int identifier, int life){
        shipLifeCounters.put(identifier, life);
    }

    public void placeShip(Ship ship, Coordinate coordinate, Orientation orientation){

        if(!isValidPosition(coordinate))
            throw new IllegalArgumentException("Origin coordinate is not valid");

        if(!isValidArea(ship, coordinate, orientation))
            throw new IllegalArgumentException("Invalid Location");

        if(!isFreeSpace(coordinate, ship.length(), ship.width()))
            throw new IllegalArgumentException("Selected area is not free");

        int identifier = shipLifeCounters.size()*100;

        if(orientation == Orientation.HORIZONTAL)
            for (int i = coordinate.verticalPosition(); i <= ship.length(); i++)
                for (int j = coordinate.horizontalPosition(); j <= ship.width(); j++)
                    grid[ i ][ j ] = identifier;

        if(orientation == Orientation.VERTICAL)
            for (int i = coordinate.verticalPosition(); i <= ship.width(); i++)
                for (int j = coordinate.horizontalPosition(); j <= ship.length(); j++)
                    grid[ i ][ j ] = identifier;

        addLifeCounter(identifier, ship.totalLife());

    }

}
