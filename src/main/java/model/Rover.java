package model;

import enumeration.Direction;
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
        int posX = position.getX();
        int posY = position.getY();
        Direction direction = position.getFacing();

        switch (direction) {
            case N -> posY = Math.max(0, posY + step);
            case E -> posX = Math.max(0, posX + step);
            case S -> posY = Math.max(0, posY - step);
            case W -> posX = Math.max(0, posX - step);
        }

        position.setX(posX);
        position.setY(posY);

    }

    @Override
    public void rotate(RotateInstruction instruction) {
        Direction roverDirection = position.getFacing();
        Direction newDirection = null;

        switch (instruction) {
            case Left -> {
                switch (roverDirection) {
                    case N -> newDirection = Direction.W;
                    case E -> newDirection = Direction.N;
                    case S -> newDirection = Direction.E;
                    case W -> newDirection = Direction.S;
                }
            }
            case Right -> {
                switch (roverDirection) {
                    case N -> newDirection = Direction.E;
                    case E -> newDirection = Direction.S;
                    case S -> newDirection = Direction.W;
                    case W -> newDirection = Direction.N;
                }
            }
        }
        position.setFacing(newDirection);

    }

    @Override
    public String toString() {
        return "Rover " + name + " ("
                + id
                + ") is at the position ("
                + position.getX() + " "
                + position.getY() + " "
                + position.getFacing() + ")";
    }
}
