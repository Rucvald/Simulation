package Entity;

import Entity.Creature.Creature;
import Entity.Creature.Herbivore;
import Entity.Creature.Predator;
import Entity.Inanimate.Inanimate;

import java.util.ArrayList;

public class Simulation {

    public static void startSimulation() throws InterruptedException {
        GameMap.fillingListOfCreature();
        GameMap.fillingListOfInanimate();
        GameMap.printGameMap();
        boolean herbivoreExistence = true;
        while (herbivoreExistence) {
            Thread.sleep(3000);
            lifeCycleOfPredator(GameMap.listOfPredators, GameMap.listOfHerbivores);
            lifeCycleOfHerbivore(GameMap.listOfHerbivores, GameMap.listOfGrasses);
            GameMap.printGameMap();
            if (GameMap.listOfHerbivores.isEmpty()) {
                herbivoreExistence = false;
            }
        }
    }

    public static void lifeCycleOfPredator(ArrayList<Creature> listOfPredators, ArrayList<Creature> listOfHerbivores) {
        for (Creature predator : listOfPredators) {
            ((Predator) predator).eat(listOfHerbivores);
            ((Predator) predator).makeMove(listOfHerbivores);
            ((Predator) predator).eat(listOfHerbivores);
        }
    }

    public static void lifeCycleOfHerbivore(ArrayList<Creature> listOfHerbivores, ArrayList<Inanimate> listOfGrasses) {
        for (Creature herbivore : listOfHerbivores) {
            ((Herbivore) herbivore).eat(listOfGrasses);
            ((Herbivore) herbivore).makeMove(listOfGrasses);
            ((Herbivore) herbivore).eat(listOfGrasses);
        }
    }
}
