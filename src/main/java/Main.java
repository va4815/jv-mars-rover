import exception.InvalidPlateauInputException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wellcome to the Mars Rover!!");

        Scanner scanner = new Scanner(System.in);

        MarsRoverProgram program = new MarsRoverProgram();

        int plateauPosX = -1;
        int plateauPosY = -1;

        do {
            try {

                // Ask user to enter position X of Plateau
                System.out.println("Please enter the position X of Plateau: ");

                String inputPosX = scanner.nextLine();
                int posX = Integer.parseInt(inputPosX);

                if (posX <= 0) {
                    throw new InvalidPlateauInputException("Position should be greater than 0");
                }

                // Ask user to enter position Y of Plateau
                System.out.println("Please enter the position Y of Plateau: ");

                String inputPosY = scanner.nextLine();
                int posY = Integer.parseInt(inputPosY);

                if (posY <= 0) {
                    throw new InvalidPlateauInputException("Position should be greater than 0");
                }

                //
                plateauPosX = posX;
                plateauPosY = posY;

            } catch (NumberFormatException e) {
                System.err.println("Input should be a number and greater than 0.");
            } catch (InvalidPlateauInputException e) {
                System.err.println("Incorrect input: " + e.getMessage());
            }
        } while (plateauPosX != -1);


        System.out.println("Program End");
    }

}
