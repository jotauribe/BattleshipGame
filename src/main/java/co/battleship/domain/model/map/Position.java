package co.battleship.domain.model.map;

/**
 * Created by jotauribe on 13/12/16.
 */
public class Position {

    private int horizontalPosition;

    private int verticalPosition;

    public Position(int x, int y){
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
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (horizontalPosition != position.horizontalPosition) return false;
        return verticalPosition == position.verticalPosition;

    }

    @Override
    public int hashCode() {
        int result = horizontalPosition;
        result = 31 * result + verticalPosition;
        return result;
    }
}
