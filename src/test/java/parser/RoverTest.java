package parser;

import enumeration.Direction;
import enumeration.RotateInstruction;
import model.Position;
import model.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void testRoverRotate_left() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Left);

        assertEquals(Direction.W, rover.getPosition().getFacing());

    }

    @Test
    void testRoverRotate_right() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.rotate(RotateInstruction.Right);

        assertEquals(Direction.E, rover.getPosition().getFacing());
    }

    @Test
    void testRoverMove_forward() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());

    }

    @Test
    void testRoverMove_backward() {
        Position position = new Position(1, 2, Direction.N);
        Rover rover = new Rover(1, "Rover", position);

        rover.move(-1);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
    }

}
