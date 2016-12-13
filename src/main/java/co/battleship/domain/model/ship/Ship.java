package co.battleship.domain.model.ship;

/**
 * Created by jotauribe on 11/12/16.
 */
public class Ship {

    private static final int MAX_LENGTH = 7;

    private static final int MAX_WIDTH = 2;

    private int length;

    private int width;

    public Ship(int length, int width){
        setLength(length);
        setWidth(width);
    }

    private void setLength(int length){
        if(length > MAX_LENGTH)
            throw new IllegalArgumentException("Ship maximum length exceeded");
        this.length = length;
    }

    private void setWidth(int width){
        if(width > MAX_WIDTH)
            throw new IllegalArgumentException("Ship maximum width exceeded");
        this.width = width;
    }

    public int length(){
        return length;
    }

    public int width(){
        return width;
    }

    public int area(){
        return length * width;
    }


}