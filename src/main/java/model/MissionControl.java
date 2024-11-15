package model;

import enumeration.Direction;
import enumeration.Instruction;
import enumeration.RotateInstruction;
import exception.InvalidInputException;
import parser.InputParser;
import parser.InstructionParser;

public class MissionControl {
    private PlateauSize plateauSize;

    public MissionControl() {

    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public Plateau setupPlateau(String inputPlateauSize) {
        PlateauSize plateauSize = InputParser.parsePlateauSize(inputPlateauSize);

        if (plateauSize == null) {
            throw new InvalidInputException("Incorrect input format of plateau size");
        }

        this.plateauSize = plateauSize;

        return new Plateau(plateauSize);
    }

    public Rover setupRover(String inputRoverPosition) {
        Position position = InputParser.parseRoverLandingPosition(inputRoverPosition);

        if (position == null) {
            throw new InvalidInputException("Incorrect input format of Rover position");
        }

        // TODO: hardcoded id and name
        return new Rover(1, "Rover 1", position);
    }

    public void commandRoverInstruction(Rover rover, String inputInstruction) {
        Instruction[] instructions = InstructionParser.parseRoverInstruction(inputInstruction);

        if (instructions == null) {
            throw new InvalidInputException("Incorrect input format of Rover instruction");
        }

        for (Instruction instruction : instructions) {
            switch (instruction) {
                case L -> rover.rotate(RotateInstruction.Left);
                case R -> rover.rotate(RotateInstruction.Right);
                case M -> {
                    Position currentPosition = rover.getPosition();
                    Direction facing = currentPosition.getFacing();

                    if (facing == Direction.N || facing == Direction.E) {
                        if (currentPosition.getX() + 1 > this.plateauSize.getWidth()
                                || currentPosition.getY() + 1 > this.plateauSize.getHeight()
                        ) {
                            System.out.println("DANGER: " + rover.getName() + " detected on the edge of the Plateau, stop action");
                            System.out.println(rover);
                            return;
                        }
                        rover.move(1);
                    } else if (facing == Direction.W || facing == Direction.S) {
                        if ((this.plateauSize.getWidth() - currentPosition.getX() - 1) < 0
                                || (this.plateauSize.getHeight() - currentPosition.getY() - 1) < 0
                        ) {
                            System.out.println("DANGER: " + rover.getName() + " detected on the edge of the Plateau, stop action");
                            System.out.println(rover);
                            return;
                        }
                        rover.move(1);
                    }

                }
            }

        }


    }

}
