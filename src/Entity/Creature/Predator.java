package Entity.Creature;

import Entity.Coordinates;
import Entity.Entity;

public class Predator implements Creature {

    private Coordinates coordinates;
    private final int speed = 1;
    private final String texture = " P ";

    public int getSpeed() {
        return speed;
    }

    public String getTexture() {
        return texture;
    }

    public Predator(Coordinates coordinates) {
        this.coordinates = coordinates;
    }



    @Override
    public void makeMove() {

    }

    @Override
    public void eat() {

    }

    public void attack(){

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
