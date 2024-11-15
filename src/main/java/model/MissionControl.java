package model;

import enumeration.Instruction;
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

        // TODO: convert Rover to a new position
        
    }

}
