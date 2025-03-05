package Entity.Inanimate;

import Entity.Coordinates;

public class Grass implements Inanimate {

    private Coordinates coordinates;
    private final String texture = " G ";

    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
