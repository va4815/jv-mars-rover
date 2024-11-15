package model;

import exception.InvalidInputException;
import parser.InputParser;

public class MissionControl {
    private PlateauSize plateauSize;

    public MissionControl(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
}
