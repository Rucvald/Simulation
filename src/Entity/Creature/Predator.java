package Entity.Creature;

import Entity.Coordinates;
import Entity.Entity;
import Entity.GameMap;

import java.util.ArrayList;
import java.util.Iterator;

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

    public Coordinates searchMeal(ArrayList<Creature> listOfHerbivores) {
        int distance = Integer.MAX_VALUE;
        Coordinates targetCoordinates = coordinates.getCoordinates();
        for (Creature herbivore : listOfHerbivores) {
            int variableDistance = Math.abs(herbivore.getCoordinates().getSumOfCoordinates()
                    - coordinates.getSumOfCoordinates());
            if (variableDistance < distance) {
                distance = variableDistance;
                targetCoordinates = herbivore.getCoordinates();
            }
        }
        System.out.println(distance);
        return targetCoordinates;
    }

    public void takeStep(Coordinates targetCoordinates) {
        int distanceX = Math.abs(targetCoordinates.getX() - coordinates.getX());
        int distanceY = Math.abs(targetCoordinates.getY() - coordinates.getY());
        if (distanceX >= distanceY && (distanceX != 0 || distanceY != 0)) {
            if (targetCoordinates.getX() > coordinates.getX()) {
                coordinates.setX(coordinates.getX() + speed);
            }
            if (targetCoordinates.getX() < coordinates.getX()) {
                coordinates.setX(coordinates.getX() - speed);
            }
        }
        if (distanceY > distanceX) {
            if (targetCoordinates.getY() > coordinates.getY()) {
                coordinates.setY(coordinates.getY() + speed);
            }
            if (targetCoordinates.getY() < coordinates.getY()) {
                coordinates.setY(coordinates.getY() - speed);
            }
        }
    }

    public Predator(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    //@Override
    public void makeMove(ArrayList<Creature> listOfHerbivores) {
        takeStep(searchMeal(listOfHerbivores));
    }

    public void eat(ArrayList<Creature> listOfHerbivores) {
        ArrayList<Coordinates> coordinatesOfPotentialMeal = new ArrayList<>();
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        Iterator<Creature> iterator = listOfHerbivores.iterator();
        while (iterator.hasNext()) {
            Creature herbivore = iterator.next();
            for (Coordinates coordinatesOPM : coordinatesOfPotentialMeal) {
                if (herbivore.getCoordinates().getX() == coordinatesOPM.getX() &&
                        herbivore.getCoordinates().getY() == coordinatesOPM.getY()) {
                    iterator.remove();
                    System.out.println("Predator eats herbivore");
                    break;
                }
            }
        }
    }

    public void attack() {

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return texture + ": X - " + coordinates.getX() + " Y - " + coordinates.getY() + " \n";
    }
}
