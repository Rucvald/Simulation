package Entity;

import Entity.Creature.Creature;
import Entity.Creature.Predator;

import java.util.ArrayList;

public class Simulation {

    public static void startSimulation() throws InterruptedException {
        GameMap.fillingListOfCreature();
        GameMap.fillingListOfInanimate();
        GameMap.printGameMap();
//        boolean herbivoreExistence = true;
//        while (herbivoreExistence) {
//            Thread.sleep(3000);
//            lifeCycleOfPredator(GameMap.listOfPredators, GameMap.listOfHerbivores);
//            GameMap.printGameMap();
//            if (GameMap.listOfHerbivores.isEmpty()) {
//                herbivoreExistence = false;
//            }
//        }
    }

    public static void lifeCycleOfPredator(ArrayList<Creature> listOfPredators, ArrayList<Creature> listOfHerbivores) {
        for (Creature predator : listOfPredators) {
            ((Predator) predator).makeMove(listOfHerbivores);
            predator.eat(listOfHerbivores);
        }
    }


}
