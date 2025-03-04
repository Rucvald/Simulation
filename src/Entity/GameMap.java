package Entity;

import Entity.Creature.Creature;
import Entity.Creature.Herbivore;
import Entity.Creature.Predator;
import Entity.Inanimate.Grass;
import Entity.Inanimate.Inanimate;

import java.util.ArrayList;

public class GameMap {

    private final static int x = 10;
    private final static int y = 10;
    private final static String defaultTexture = " * ";
    public static ArrayList<Creature> listOfPredators = new ArrayList<>();
    public static ArrayList<Creature> listOfHerbivores = new ArrayList<>();
    public static ArrayList<Inanimate> listOfGrasses = new ArrayList<>();

    public static void fillingListOfCreature() {
        Predator predator1 = new Predator(new Coordinates(1, 1));
        listOfPredators.add(predator1);

        Herbivore herbivore1 = new Herbivore(new Coordinates(5, 9));
        Herbivore herbivore2 = new Herbivore(new Coordinates(0, 9));
        listOfHerbivores.add(herbivore1);
        listOfHerbivores.add(herbivore2);
    }

    public static void fillingListOfInanimate() {
        Grass grass1 = new Grass(new Coordinates(9, 1));
        listOfGrasses.add(grass1);
    }

//    public void createGameMap(){
//        Predator predator1 = new Predator(new Coordinates(1, 1));
//        for(int i = 0; i < y; i++){
//            for(int j = 0; j < x; j++){
//                gameMap.put(predator1.getCoordinates(), predator1);
//            }
//        }
//    }

    public String getTexture() {
        return defaultTexture;
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
                if (drawDefaultTexture) {
                    for (Inanimate grass : listOfGrasses) {
                        Coordinates coordinates = grass.getCoordinates();
                        if (coordinates.getY() == i && coordinates.getX() == j) {
                            drawDefaultTexture = false;
                            System.out.print(grass.getTexture());
                        }
                    }
                }
                if (drawDefaultTexture) {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("---");
        System.out.println();
    }

    public static void getListOfEntity() {
        for (Entity entity : listOfPredators) {
            System.out.print(entity.toString());
        }
    }


}
