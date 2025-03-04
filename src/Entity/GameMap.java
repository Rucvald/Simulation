package Entity;

import Entity.Creature.Creature;
import Entity.Creature.Herbivore;
import Entity.Creature.Predator;

import java.util.ArrayList;

public class GameMap {

    private final static int x = 10;
    private final static int y = 10;
    private final static String defaultTexture = " * ";
    public static ArrayList<Creature> listOfPredators = new ArrayList<>();
    public static ArrayList<Creature> listOfHerbivores = new ArrayList<>();

    public static void fillingListOfEntity() {
        Predator predator1 = new Predator(new Coordinates(1, 1));
        //Predator predator2 = new Predator(new Coordinates(2, 2));
        //Predator predator3 = new Predator(new Coordinates(3, 3));
        listOfPredators.add(predator1);
        //listOfPredators.put(predator2.getCoordinates(), predator2);
        //listOfPredators.put(predator3.getCoordinates(), predator3);

        Herbivore herbivore1 = new Herbivore(new Coordinates(5, 9));
        Herbivore herbivore2 = new Herbivore(new Coordinates(0, 9));
        listOfHerbivores.add(herbivore1);
        listOfHerbivores.add(herbivore2);
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
                for (Entity creature : listOfPredators) {
                    Coordinates coordinates = creature.getCoordinates();
                    if (coordinates.getY() == i && coordinates.getX() == j) {
                        drawDefaultTexture = false;
                        System.out.print(creature.getTexture());
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
