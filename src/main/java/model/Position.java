package model;

import enumeration.CompassDirection;

public class Position {
    private int x;
    private int y;
    private CompassDirection facing;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CompassDirection getFacing() {
        return facing;
    }
}
