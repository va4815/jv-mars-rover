package model;

import enumeration.Direction;
import enumeration.Instruction;
import enumeration.RotateInstruction;
import exception.InvalidInputException;
import parser.InputParser;
import parser.InstructionParser;

import java.util.Scanner;

public class MissionControl {
    private PlateauSize plateauSize;
    private Plateau plateau;
    private Rover rover;
    private static final String EXIT_CMD = "exit";

    public MissionControl() {

    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Rover getRover() {
        return rover;
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
        return new Rover(1, "LandRoverDefender", position);
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
                            System.out.println("DANGER: " + rover.getName() + " detected danger if move forward.");
                            return;
                        }
                        rover.move(1);
                    } else if (facing == Direction.W || facing == Direction.S) {
                        if ((this.plateauSize.getWidth() - currentPosition.getX() - 1) < 0
                                || (this.plateauSize.getHeight() - currentPosition.getY() - 1) < 0
                        ) {
                            System.out.println("DANGER: " + rover.getName() + " detected danger if move forward.");
                            return;
                        }
                        rover.move(1);
                    }

                }
            }

        }


    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        askPlateauSize(scanner);
        askRoverLandingPosition(scanner);

        askRoverInstruction(scanner);

    }

    private void askPlateauSize(Scanner scanner) {

        do {
            try {
                System.out.println("Please enter the Plateau size (eg. \"5 5\"): ");

                String input = scanner.nextLine();
                plateau = setupPlateau(input);

            } catch (NumberFormatException e) {
                System.err.println("Input should be a number and greater than 0.");
            } catch (InvalidInputException e) {
                System.err.println("Incorrect input: " + e.getMessage());
            }
        } while (plateau == null);

    }

    private void askRoverLandingPosition(Scanner scanner) {
        do {
            try {
                System.out.println("Please enter the Rover landing position (eg. \"1 2 N\"): ");

                String input = scanner.nextLine();
                rover = setupRover(input);

            } catch (NumberFormatException e) {
                System.err.println("Input should be a number and greater than 0.");
            } catch (InvalidInputException e) {
                System.err.println("Incorrect input: " + e.getMessage());
            }
        } while (rover == null);
    }

    private void askRoverInstruction(Scanner scanner) {

        String input = "";

        do {
            try {
                System.out.println(rover);
                System.out.println("Please enter the instruction (eg. \"LMR\") , L: Rotate Left | R: Rotate Right | M: Move Forward , type \"exit\" to exit");

                input = scanner.nextLine();

                if (!input.equals(EXIT_CMD)) {
                    commandRoverInstruction(rover, input);
                }

            } catch (NumberFormatException e) {
                System.err.println("Input should be a number and greater than 0.");
            } catch (InvalidInputException e) {
                System.err.println("Incorrect input: " + e.getMessage());
            }
        } while (!input.equals(EXIT_CMD));

    }

}
