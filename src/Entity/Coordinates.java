package Entity;

import java.util.Objects;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates getCoordinates() {
        return new Coordinates(x, y);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSumOfCoordinates() {
        return x + y;
    }
}
