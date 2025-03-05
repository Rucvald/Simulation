package Entity.Creature;

import Entity.Coordinates;
import Entity.Entity;
import Entity.Inanimate.Inanimate;
import Entity.GameMap;

import java.util.ArrayList;
import java.util.Iterator;

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

    //@Override
    public void makeMove(ArrayList<Inanimate> listOfGrasses) {
        takeStep(searchMeal(listOfGrasses));
    }

    //@Override
    public void eat(ArrayList<Inanimate> listOfGrasses) {
        ArrayList<Coordinates> coordinatesOfPotentialMeal = new ArrayList<>();
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        Iterator<Inanimate> iterator = listOfGrasses.iterator();
        while (iterator.hasNext()) {
            Inanimate grass = iterator.next();
            for (Coordinates coordinatesOPM : coordinatesOfPotentialMeal) {
                if (grass.getCoordinates().getX() == coordinatesOPM.getX() &&
                        grass.getCoordinates().getY() == coordinatesOPM.getY()) {
                    iterator.remove();
                    System.out.println("Herbivore eats grass");
                    break;
                }
            }
        }
    }


    @Override
    public String getTexture() {
        return texture;
    }

    public Coordinates searchMeal(ArrayList<Inanimate> listOfGrass) {
        int numberOfSteps = Integer.MAX_VALUE;
        Coordinates targetCoordinates = coordinates.getCoordinates();
        for (Inanimate grass : listOfGrass) {
            int variablenumberOfSteps = Math.abs(grass.getCoordinates().getSumOfCoordinates()
                    - coordinates.getSumOfCoordinates());
            if (variablenumberOfSteps < numberOfSteps) {
                numberOfSteps = variablenumberOfSteps;
                targetCoordinates = grass.getCoordinates();
            }
        }
        return targetCoordinates;
    }

    public void takeStep(Coordinates targetCoordinates) {
        int distanceX = Math.abs(targetCoordinates.getX() - coordinates.getX());
        int distanceY = Math.abs(targetCoordinates.getY() - coordinates.getY());
        if (distanceX >= distanceY && (distanceX != 0 || distanceY != 0)) {
            if (targetCoordinates.getX() > coordinates.getX()) {
                if (checkRoadForBlock(new Coordinates(coordinates.getX() + speed, coordinates.getY()))) {
                    coordinates.setX(coordinates.getX() + speed);
                }
                else{
                    if (targetCoordinates.getY() > coordinates.getY()){
                        coordinates.setY(coordinates.getY() + speed);
                    }
                    if (targetCoordinates.getY() < coordinates.getY()){
                        coordinates.setY(coordinates.getY() - speed);
                    }
                }
            }
            if (targetCoordinates.getX() < coordinates.getX()) {
                if (checkRoadForBlock(new Coordinates(coordinates.getX() - speed, coordinates.getY()))) {
                    coordinates.setX(coordinates.getX() - speed);
                }
                else{
                    if (targetCoordinates.getY() > coordinates.getY()){
                        coordinates.setY(coordinates.getY() + speed);
                    }
                    if (targetCoordinates.getY() < coordinates.getY()){
                        coordinates.setY(coordinates.getY() - speed);
                    }
                }
            }
        }
        if (distanceY > distanceX) {
            if (targetCoordinates.getY() > coordinates.getY()) {
                if (checkRoadForBlock(new Coordinates(coordinates.getX(), coordinates.getY() + speed ))) {
                    coordinates.setY(coordinates.getY() + speed);
                }
                else{
                    if (targetCoordinates.getX() > coordinates.getX()){
                        coordinates.setX(coordinates.getX() + speed);
                    }
                    if (targetCoordinates.getX() < coordinates.getX()){
                        coordinates.setX(coordinates.getX() - speed);
                    }
                }
            }
            if (targetCoordinates.getY() < coordinates.getY()) {
                if (checkRoadForBlock(new Coordinates(coordinates.getX(), coordinates.getY() - speed ))) {
                    coordinates.setY(coordinates.getY() - speed);
                }
                else{
                    if (targetCoordinates.getX() > coordinates.getX()){
                        coordinates.setX(coordinates.getX() + speed);
                    }
                    if (targetCoordinates.getX() < coordinates.getX()){
                        coordinates.setX(coordinates.getX() - speed);
                    }
                }
            }
        }
    }

    public void death(ArrayList<Herbivore> listOfHerbivores, Coordinates coordinatesOfPotentialMeal) {
        Iterator<Herbivore> iterator = listOfHerbivores.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCoordinates().equals(coordinatesOfPotentialMeal)) {
                iterator.remove();
            }
        }
    }

    public boolean checkRoadForBlock(Coordinates coordinatesOfPotentialBlock) {
        ArrayList<Entity> listOfEntity = GameMap.getListOfEntity();
        for (Entity entity : listOfEntity) {
            if (entity.getCoordinates().getX() == coordinatesOfPotentialBlock.getX()
                    && entity.getCoordinates().getY() == coordinatesOfPotentialBlock.getY()) {
                GameMap.clearListOfEntity();
                return false;
            }
        }
        GameMap.clearListOfEntity();
        return true;
    }
}
