import exception.InvalidInputException;
import model.MissionControl;
import model.Plateau;
import model.PlateauSize;
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





        // Input: Rover Instruction




        System.out.println("Program End");
    }

}
