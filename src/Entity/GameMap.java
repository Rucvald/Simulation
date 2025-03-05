package Entity;

import Entity.Creature.Creature;
import Entity.Creature.Herbivore;
import Entity.Creature.Predator;
import Entity.Inanimate.Grass;
import Entity.Inanimate.Inanimate;
import Entity.Inanimate.Rock;

import java.util.ArrayList;

public class GameMap {

    private final static int x = 10;
    private final static int y = 10;
    private final static String defaultTexture = " * ";
    public static ArrayList<Predator> listOfPredators = new ArrayList<>();
    public static ArrayList<Herbivore> listOfHerbivores = new ArrayList<>();
    public static ArrayList<Grass> listOfGrasses = new ArrayList<>();
    public static ArrayList<Rock> listOfRocks = new ArrayList<>();
    public static ArrayList<Entity> listOfEntity = new ArrayList<>();

    public static void fillingListOfCreature() {
        Predator predator1 = new Predator(Coordinates.setCoordinates());
        listOfPredators.add(predator1);

        Herbivore herbivore1 = new Herbivore(Coordinates.setCoordinates());
        Herbivore herbivore2 = new Herbivore(Coordinates.setCoordinates());
        listOfHerbivores.add(herbivore1);
        listOfHerbivores.add(herbivore2);
    }

    public static void fillingListOfInanimate() {
        Grass grass1 = new Grass(Coordinates.setCoordinates());
        Grass grass2 = new Grass(Coordinates.setCoordinates());
        Grass grass3 = new Grass(Coordinates.setCoordinates());
        Grass grass4 = new Grass(Coordinates.setCoordinates());
        listOfGrasses.add(grass1);
        listOfGrasses.add(grass2);
        listOfGrasses.add(grass3);
        listOfGrasses.add(grass4);

        Rock rock1 = new Rock(Coordinates.setCoordinates());
        Rock rock2 = new Rock(Coordinates.setCoordinates());
        Rock rock3 = new Rock(Coordinates.setCoordinates());
        Rock rock4 = new Rock(Coordinates.setCoordinates());
        listOfRocks.add(rock1);
        listOfRocks.add(rock2);
        listOfRocks.add(rock3);
        listOfRocks.add(rock4);
    }

    public static void printGameMap() {
        System.out.println();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                boolean drawDefaultTexture = true;
                for (Entity predator : listOfPredators) {
                    Coordinates coordinates = predator.getCoordinates();
                    if (coordinates.getY() == i && coordinates.getX() == j) {
                        drawDefaultTexture = false;
                        System.out.print(predator.getTexture());
                    }
                }
                for (Creature herbivore : listOfHerbivores) {
                    Coordinates coordinates = herbivore.getCoordinates();
                    if (coordinates.getY() == i && coordinates.getX() == j) {
                        drawDefaultTexture = false;
                        System.out.print(herbivore.getTexture());
                    }
                }
                for (Inanimate grass : listOfGrasses) {
                    Coordinates coordinates = grass.getCoordinates();
                    if (coordinates.getY() == i && coordinates.getX() == j) {
                        drawDefaultTexture = false;
                        System.out.print(grass.getTexture());
                    }
                }
                for (Inanimate rock : listOfRocks) {
                    Coordinates coordinates = rock.getCoordinates();
                    if (coordinates.getY() == i && coordinates.getX() == j) {
                        drawDefaultTexture = false;
                        System.out.print(rock.getTexture());
                    }
                }
                if (drawDefaultTexture) {
                    System.out.print(defaultTexture);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("---");
        System.out.println();
    }

    public static ArrayList<Entity> getListOfEntity() {
        listOfEntity.addAll(listOfPredators);
        listOfEntity.addAll(listOfHerbivores);
        listOfEntity.addAll(listOfGrasses);
        listOfEntity.addAll(listOfRocks);
        return listOfEntity;
    }

    public static void clearListOfEntity() {
        listOfEntity.clear();
    }

}
