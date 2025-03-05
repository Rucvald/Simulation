package Entity;

import Entity.Creature.Herbivore;
import Entity.Creature.Predator;
import Entity.Inanimate.Grass;

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

    public static void lifeCycleOfPredator(ArrayList<Predator> listOfPredators, ArrayList<Herbivore> listOfHerbivores) {
        for (Predator predator : listOfPredators) {
            predator.eat(listOfHerbivores);
            predator.makeMove(listOfHerbivores);
            predator.eat(listOfHerbivores);
        }
    }

    public static void lifeCycleOfHerbivore(ArrayList<Herbivore> listOfHerbivores, ArrayList<Grass> listOfGrasses) {
        for (Herbivore herbivore : listOfHerbivores) {
            herbivore.eat(listOfGrasses);
            herbivore.makeMove(listOfGrasses);
            herbivore.eat(listOfGrasses);
        }
    }
}
