package Entity;
import Entity.Creature.Creature;
import Entity.Creature.Predator;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

    private final static int x = 10;
    private final static int y = 5;
    private final static String defaultTexture = " * ";
    private static Map<Coordinates, Creature> listOfCreature = new HashMap<>();

    public static void fillingListOfCreature(){
        Predator predator1 = new Predator(new Coordinates(1, 1));
        Predator predator2 = new Predator(new Coordinates(2, 2));
        Predator predator3 = new Predator(new Coordinates(3, 3));
        listOfCreature.put(predator1.getCoordinates(), predator1);
        listOfCreature.put(predator2.getCoordinates(), predator2);
        listOfCreature.put(predator3.getCoordinates(), predator3);
    }

//    public void createGameMap(){
//        Predator predator1 = new Predator(new Coordinates(1, 1));
//        for(int i = 0; i < y; i++){
//            for(int j = 0; j < x; j++){
//                gameMap.put(predator1.getCoordinates(), predator1);
//            }
//        }
//    }

    public String getTexture(){
        return defaultTexture;
    }

    public static void printGameMap(){
        fillingListOfCreature();
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                boolean drawDefaultTexture = true;
                for(Map.Entry<Coordinates, Creature> creature : listOfCreature.entrySet()){
                    Coordinates coordinates = creature.getKey();
                    if(coordinates.getX() == i && coordinates.getY() == j){
                        drawDefaultTexture = false;
                        System.out.print(creature.getValue().getTexture());
                    }
                }
                if(drawDefaultTexture){
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }


}
