package Entity.Inanimate;

import Entity.Coordinates;

public class Rock implements Inanimate {

    private Coordinates coordinates;
    private final String texture = " R ";

    public Rock(Coordinates coordinates) {
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
