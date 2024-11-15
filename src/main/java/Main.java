import enumeration.Instruction;
import exception.InvalidInputException;
import model.*;
import parser.InputParser;
import parser.InstructionParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wellcome to the Mars Rover!!");

        MissionControl missionControl = new MissionControl();

        missionControl.start();

        System.out.println("\nFinal position:");
        System.out.println(missionControl.getRover());

        System.out.println("Program End");
    }

}
