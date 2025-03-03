package Entity;
import Entity.Creature.Herbivore;
import Entity.Creature.Predator;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

    private final static int x = 10;
    private final static int y = 10;
    private final static String defaultTexture = " * ";
    public static Map<Coordinates, Entity> listOfEntity = new HashMap<>();

    public static void fillingListOfCreature(){
        Predator predator1 = new Predator(new Coordinates(1, 1));
        Predator predator2 = new Predator(new Coordinates(2, 2));
        Predator predator3 = new Predator(new Coordinates(3, 3));
        listOfEntity.put(predator1.getCoordinates(), predator1);
        listOfEntity.put(predator2.getCoordinates(), predator2);
        listOfEntity.put(predator3.getCoordinates(), predator3);

        Herbivore herbivore1 = new Herbivore(new Coordinates(5, 9));
        listOfEntity.put(herbivore1.getCoordinates(), herbivore1);
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
                for(Map.Entry<Coordinates, Entity> creature : listOfEntity.entrySet()){
                    Coordinates coordinates = creature.getKey();
                    if(coordinates.getY() == i && coordinates.getX() == j){
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

    public static void getListOfCreature(){
        fillingListOfCreature();
        for(Map.Entry<Coordinates, Entity> creature : listOfEntity.entrySet()){
            String str = creature.getValue().getTexture();
            System.out.print(str);
        }
    }


}
