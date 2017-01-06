package co.battleship.domain.model.grid;

/**
 * Created by jotauribe on 13/12/16.
 */
public class Coordinate {

    private int horizontalPosition;

    private int verticalPosition;

    public Coordinate(int x, int y){
        horizontalPosition = x;
        verticalPosition = y;
    }

    public int verticalPosition(){
        return verticalPosition;
    }

    public int horizontalPosition(){
        return horizontalPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate coordinate = (Coordinate) o;

        if (horizontalPosition != coordinate.horizontalPosition) return false;
        return verticalPosition == coordinate.verticalPosition;

    }

    @Override
    public int hashCode() {
        int result = horizontalPosition;
        result = 31 * result + verticalPosition;
        return result;
    }
}
