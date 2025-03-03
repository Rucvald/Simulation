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
    public void makeMove(Map<Coordinates, Entity> listOfEntity) {

    }

    @Override
    public void eat(Map<Coordinates, Entity> listOfEntity) {

    }


    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public Coordinates searchMeal(Map<Coordinates, Entity> listOfCreature) {

        return null;
    }

    public void death(Map<Coordinates, Entity> listOfEntity) {
        listOfEntity.remove(coordinates);
    }
}
