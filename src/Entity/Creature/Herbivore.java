package Entity.Creature;

import Entity.Coordinates;
import Entity.Entity;

import java.util.Map;

public class Herbivore implements Creature {

    private Coordinates coordinates;
    private final int speed = 1;
    private final String texture = " H ";

    public Herbivore(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void makeMove(Map<Coordinates, Entity> listOfCreature) {

    }

    @Override
    public void eat() {

    }

    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public Coordinates searchMeal(Map<Coordinates, Entity> listOfCreature) {

        return null;
    }
}
