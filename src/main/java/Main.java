import exception.InvalidInputException;
import model.*;
import parser.InputParser;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wellcome to the Mars Rover!!");



        // Input: Plateau Size
        String inputPlateauSize = "5 5";
        PlateauSize plateauSize = InputParser.parsePlateauSize(inputPlateauSize);

        if (plateauSize == null) {
            throw new InvalidInputException("Incorrect input format of plateau size");
        }

        Plateau plateau = new Plateau(plateauSize);
        MissionControl missionControl = new MissionControl(plateauSize);

        // Input: Landing position
        String inputRoverPosition = "1 2 N";
        Position position = InputParser.parseRoverLandingPosition(inputRoverPosition);

        if (position == null) {
            throw new InvalidInputException("Incorrect input format of Rover position");
        }

        Rover rover = new Rover(1, "Rover 1", position);


        // Input: Rover Instruction




        System.out.println("Program End");
    }

}
