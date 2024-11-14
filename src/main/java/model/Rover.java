package model;

import enumeration.RotateInstruction;

public class Rover implements Movable, Rotatable {
    private String name;
    private Position position;

    public Rover(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void move() {

    }

    @Override
    public void rotate(RotateInstruction instruction) {

    }

    @Override
    public String toString() {
        return "Rover " + name + " is at the position ("
                + position.getX() + ", "
                + position.getY() + " "
                + position.getFacing() + " )";
    }
}
