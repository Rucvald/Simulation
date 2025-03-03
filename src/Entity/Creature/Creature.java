package Entity.Creature;

import Entity.Entity;
import Entity.Coordinates;

import java.util.Map;

public interface Creature extends Entity {
    public void makeMove(Map<Coordinates, Entity> listOfEntity);
    public void eat(Map<Coordinates, Entity> listOfEntity);
    public String getTexture();
    public Coordinates searchMeal(Map<Coordinates, Entity> listOfEntity);
}
