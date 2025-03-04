package Entity.Creature;

import Entity.Coordinates;
import Entity.Entity;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void makeMove(ArrayList<Creature> listOfEntity) {

    }

    @Override
    public void eat(ArrayList<Creature> listOfEntity) {

    }


    @Override
    public String getTexture() {
        return texture;
    }

    public Coordinates searchMeal(ArrayList<Entity> listOfEntity) {

        return null;
    }

    public void death(ArrayList<Herbivore> listOfHerbivores, Coordinates coordinatesOfPotentialMeal) {
        Iterator<Herbivore> iterator = listOfHerbivores.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCoordinates().equals(coordinatesOfPotentialMeal)) {
                iterator.remove();
            }
        }
    }
}
