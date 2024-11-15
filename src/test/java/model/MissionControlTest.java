package model;

import enumeration.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    @Test
    void testSetupPlateau() {
        String inputPlateauSize = "5 5";

        MissionControl missionControl = new MissionControl();
        Plateau actual = missionControl.setupPlateau(inputPlateauSize);

        PlateauSize plateauSize = new PlateauSize(5, 5);
        Plateau expected = new Plateau(plateauSize);

        assertEquals(expected.getWidth(), actual.getWidth());
        assertEquals(expected.getHeight(), actual.getHeight());

    }

    @Test
    void testSetupRover() {
        String inputRoverPosition = "1 2 N";

        MissionControl missionControl = new MissionControl();
        Rover actual = missionControl.setupRover(inputRoverPosition);

        Position position = new Position(1, 2, Direction.N);
        Rover expected = new Rover(1, "Rover 1", position);

        assertEquals(expected.getPosition().toString(), actual.getPosition().toString());
    }

    @Test
    void testCommandRoverInstruction_OneInstruction() {
        String inputPlateauSize = "5 5";
        String inputRoverPosition = "1 2 N";

        MissionControl missionControl = new MissionControl();
        Plateau plateau = missionControl.setupPlateau(inputPlateauSize);
        Rover actual = missionControl.setupRover(inputRoverPosition);

        Position position = new Position(3, 3, Direction.N);
        Rover expected = new Rover(1, "Rover 1", position);

        String input = "RMMLM";
        missionControl.commandRoverInstruction(actual, input);

        assertEquals(expected.getPosition().toString(), actual.getPosition().toString());

    }

    @Test
    void testCommandRoverInstruction_TwoInstruction() {
        String inputPlateauSize = "5 5";
        String inputRoverPosition = "1 2 N";

        MissionControl missionControl = new MissionControl();
        Plateau plateau = missionControl.setupPlateau(inputPlateauSize);
        Rover actual = missionControl.setupRover(inputRoverPosition);

        Position position = new Position(2, 3, Direction.S);
        Rover expected = new Rover(1, "Rover 1", position);

        String input1 = "RMMLM";
        String input2 = "LML";
        missionControl.commandRoverInstruction(actual, input1);
        missionControl.commandRoverInstruction(actual, input2);

        assertEquals(expected.getPosition().toString(), actual.getPosition().toString());

    }

    @Test
    void testCommandRoverInstruction_TwoInstructionWithOutOfPlateauSize() {
        String inputPlateauSize = "5 5";
        String inputRoverPosition = "1 2 N";

        MissionControl missionControl = new MissionControl();
        Plateau plateau = missionControl.setupPlateau(inputPlateauSize);
        Rover actual = missionControl.setupRover(inputRoverPosition);

        Position position = new Position(5, 3, Direction.E);
        Rover expected = new Rover(1, "Rover 1", position);

        String input1 = "RMMLM";
        String input2 = "RMMML";
        missionControl.commandRoverInstruction(actual, input1);
        missionControl.commandRoverInstruction(actual, input2);

        assertEquals(expected.getPosition().toString(), actual.getPosition().toString());

    }

}