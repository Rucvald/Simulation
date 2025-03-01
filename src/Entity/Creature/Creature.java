package Entity.Creature;

import Entity.Entity;

public interface Creature extends Entity {
    public void makeMove();
    public void eat();
    public String getTexture();
    public void searchMeal();
}
