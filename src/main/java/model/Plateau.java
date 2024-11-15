package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plateau {
    private final int width;
    private final int height;
    private Map<Integer, Position> roverPositions;

    public Plateau(PlateauSize plateauSize) {
        this.width = plateauSize.getWidth();
        this.height = plateauSize.getHeight();
        this.roverPositions = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Integer, Position> getRoverPositions() {
        return roverPositions;
    }
}
