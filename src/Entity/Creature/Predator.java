package Entity.Creature;

import Entity.Coordinates;
import Entity.Entity;
import Entity.GameMap;

import java.util.ArrayList;
import java.util.Map;

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

    @Override
    public Coordinates searchMeal(Map<Coordinates, Entity> listOfCreature) {
        int distance = 0;
        Coordinates targetCoordinates = coordinates.getCoordinates();
        for (Entity creature : listOfCreature.values()) {
            if (creature instanceof Herbivore) {
                int variableDistance = Math.abs(((Herbivore) creature).getCoordinates().getSumOfCoordinates()
                        - coordinates.getSumOfCoordinates());
                if (variableDistance > distance) {
                    distance = variableDistance;
                    targetCoordinates = ((Herbivore) creature).getCoordinates();
                }
            }
        }
        return targetCoordinates;
    }

    public void takeStep(Coordinates targetCoordinates){
        int distanceX = Math.abs(targetCoordinates.getX() - coordinates.getX());
        int distanceY = Math.abs(targetCoordinates.getY() - coordinates.getY());
        if (distanceX >= distanceY && (distanceX != 0 || distanceY != 0)) {
            if (targetCoordinates.getX() > coordinates.getX()){
                coordinates.setX(coordinates.getX() + speed);
            }
            if (targetCoordinates.getX() < coordinates.getX()){
                coordinates.setX(coordinates.getX() - speed);
            }
        }
        if (distanceY > distanceX ){
            if (targetCoordinates.getY() > coordinates.getY()){
                coordinates.setY(coordinates.getY() + speed);
            }
            if (targetCoordinates.getY() < coordinates.getY()){
                coordinates.setY(coordinates.getY() - speed);
            }
        }
    }

    public Predator(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void makeMove(Map<Coordinates, Entity> listOfEntity) {
        takeStep(searchMeal(GameMap.listOfEntity));
    }

    public void eat(Map<Coordinates, Entity> listOfEntity){
        ArrayList<Coordinates> coordinatesOfPotentialMeal = new ArrayList<>();
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
        coordinatesOfPotentialMeal.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
        for (Entity herbivore : listOfEntity.values()) {
            if (herbivore instanceof Herbivore) {
                for (Coordinates coordinatesOPM : coordinatesOfPotentialMeal) {
                    if (((Herbivore) herbivore).getCoordinates().getX() == coordinatesOPM.getX() &&
                    ((Herbivore) herbivore).getCoordinates().getY() == coordinatesOPM.getY()) {
                        ((Herbivore) herbivore).death(listOfEntity);
                    }
                }
            }
        }
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
