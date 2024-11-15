package parser;

import enumeration.Instruction;
import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    void testParseRoverInstruction_normalInstruction() {
        Instruction[] expected = new Instruction[] {
            Instruction.L, Instruction.M, Instruction.R, Instruction.M
        };
        Instruction[] actual = InstructionParser.parseRoverInstruction("LMRM");

        assertArrayEquals(expected, actual);
    }

    @Test
    void testParseRoverInstruction_nullInstruction() {
        assertEquals(
                null,
                InstructionParser.parseRoverInstruction(null)
        );
    }

    @Test
    void testParseRoverInstruction_invalidInput() {
        assertEquals(
                null,
                InstructionParser.parseRoverInstruction("L9MR")
        );
    }

}