import enumeration.Instruction;
import exception.InvalidInputException;
import model.*;
import parser.InputParser;
import parser.InstructionParser;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wellcome to the Mars Rover!!");

        MissionControl missionControl = new MissionControl();

        // Input: Plateau Size
        String inputPlateauSize = "5 5";
        Plateau plateau = missionControl.setupPlateau(inputPlateauSize);

        // Input: Landing position
        String inputRoverPosition = "1 2 N";
        Rover rover = missionControl.setupRover(inputRoverPosition);

        // Input: Rover Instruction


        System.out.println("Program End");
    }

}
