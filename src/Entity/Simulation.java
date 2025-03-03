package Entity;

import Entity.Creature.Predator;

import java.util.Map;

public class Simulation {

    public static void startSimulation() {
        GameMap.printGameMap();
        //GameMap.getListOfCreature();
    }
    public void lifeCycleOfPredator(Map<Coordinates, Entity> listOfEntity){
        for(Map.Entry<Coordinates, Entity> predator : listOfEntity.entrySet()){
            if (predator instanceof Predator){
                ((Predator) predator).makeMove(listOfEntity);
                ((Predator) predator).eat(listOfEntity);
            }
        }
    }
}
