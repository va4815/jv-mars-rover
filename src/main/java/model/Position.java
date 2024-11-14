package model;

import enumeration.Direction;

public class Position {
    private int x;
    private int y;
    private Direction facing;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }
}
