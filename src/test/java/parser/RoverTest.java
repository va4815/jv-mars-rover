package parser;

import enumeration.Direction;
import enumeration.RotateInstruction;
import model.Position;
import model.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void testRoverRotate_leftFromN2E() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Left);

        assertEquals(Direction.W, rover.getPosition().getFacing());

    }

    @Test
    void testRoverRotate_leftFromE2N() {
        Position position = new Position(1, 2, Direction.E);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Left);

        assertEquals(Direction.N, rover.getPosition().getFacing());

    }

    @Test
    void testRoverRotate_leftFromS2E() {
        Position position = new Position(1, 2, Direction.S);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Left);

        assertEquals(Direction.E, rover.getPosition().getFacing());

    }


    @Test
    void testRoverRotate_leftFromW2S() {
        Position position = new Position(1, 2, Direction.W);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Left);

        assertEquals(Direction.S, rover.getPosition().getFacing());

    }

    @Test
    void testRoverRotate_rightFromN2E() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Right);

        assertEquals(Direction.E, rover.getPosition().getFacing());
    }

    @Test
    void testRoverRotate_rightFromE2S() {
        Position position = new Position(1, 2, Direction.E);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Right);

        assertEquals(Direction.S, rover.getPosition().getFacing());
    }

    @Test
    void testRoverRotate_rightFromS2W() {
        Position position = new Position(1, 2, Direction.S);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Right);

        assertEquals(Direction.W, rover.getPosition().getFacing());
    }

    @Test
    void testRoverRotate_rightFromW2N() {
        Position position = new Position(1, 2, Direction.W);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Right);

        assertEquals(Direction.N, rover.getPosition().getFacing());
    }

    @Test
    void testRoverMove_forwardFacingN() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());

    }

    @Test
    void testRoverMove_forwardFacingN_2steps() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(2);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(4, rover.getPosition().getY());

    }

    @Test
    void testRoverMove_forwardFacingE() {
        Position position = new Position(1, 2, Direction.E);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(1);

        assertEquals(2, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());

    }

    @Test
    void testRoverMove_forwardFacingS() {
        Position position = new Position(1, 2, Direction.S);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());

    }

    @Test
    void testRoverMove_forwardFacingW() {
        Position position = new Position(1, 2, Direction.W);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(1);

        assertEquals(0, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());

    }

    @Test
    void testRoverMove_backwardFacingN() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(-1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
    }

    @Test
    void testRoverMove_backwardFacingN_2steps() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(-1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
    }

    @Test
    void testRoverMove_backwardFacingE() {
        Position position = new Position(1, 2, Direction.E);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(-1);

        assertEquals(0, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
    }

    @Test
    void testRoverMove_backwardFacingS() {
        Position position = new Position(1, 2, Direction.S);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(-1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
    }

    @Test
    void testRoverMove_backwardFacingW() {
        Position position = new Position(1, 2, Direction.W);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(-1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
    }

}
