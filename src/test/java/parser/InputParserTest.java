package parser;

import enumeration.Direction;
import model.PlateauSize;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    void testParsePlateauSize_normalInput() {
        PlateauSize expected = new PlateauSize(5, 5);
        PlateauSize actual = InputParser.parsePlateauSize("5 5");

        assertEquals(expected.getWidth(), actual.getWidth());
        assertEquals(expected.getHeight(), actual.getHeight());

    }

    @Test
    void testParsePlateauSize_nullInput() {
        assertEquals(
            null,
            InputParser.parsePlateauSize(null)
        );
    }

    @Test
    void testParsePlateauSize_invalidInput() {
        assertEquals(
                null,
                InputParser.parsePlateauSize("5Ad")
        );
    }

    @Test
    void testParseRoverLandingPosition_normalInput() {
        Position expected = new Position(1, 2, Direction.N);
        Position actual = InputParser.parseRoverLandingPosition("1 2 N");

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testParseRoverLandingPosition_nullInput() {
        assertEquals(
                null,
                InputParser.parseRoverLandingPosition(null)
        );
    }

    @Test
    void testParseRoverLandingPosition_invalidInputFormat() {
        assertEquals(
                null,
                InputParser.parseRoverLandingPosition("5qd")
        );
    }

    @Test
    void testParseRoverLandingPosition_incorrectDirectionChar() {
        assertEquals(
                null,
                InputParser.parseRoverLandingPosition("5 3 Q")
        );
    }

    @Test
    void testParseRoverLandingPosition_incorrectFormatOfPositionX() {
        assertEquals(
                null,
                InputParser.parseRoverLandingPosition("A 3 N")
        );
    }

    @Test
    void testParseRoverLandingPosition_incorrectFormatOfPositionY() {
        assertEquals(
                null,
                InputParser.parseRoverLandingPosition("7 E N")
        );
    }

}