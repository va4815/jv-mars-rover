package model;

import exception.InvalidInputException;
import parser.InputParser;

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

        return new Rover(1, "Rover 1", position);
    }

}
