package Entity.Creature;

import Entity.Coordinates;

public class Predator implements Creature {

    private Coordinates coordinates;

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
