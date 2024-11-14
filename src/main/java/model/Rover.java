package model;

import enumeration.RotateInstruction;

public class Rover implements Movable, Rotatable {
    private int id;
    private String name;
    private Position position;

    public Rover(int id, String name, Position position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void move(int step) {

    }

    @Override
    public void rotate(RotateInstruction instruction) {

    }

    @Override
    public String toString() {
        return "Rover " + name + " ("
                + id
                + ") is at the position ("
                + position.getX() + ", "
                + position.getY() + " "
                + position.getFacing() + " )";
    }
}
