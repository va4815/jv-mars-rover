package parser;

import enumeration.Instruction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionParser {

    public static Instruction[] parseRoverInstruction(String input) {
        Instruction[] outputs = null;

        if (input == null) {
            return outputs;
        }

        String regex = "^[LMR]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            return outputs;
        }

        outputs = new Instruction[input.length()];

        for (int i = 0; i < input.length(); i++) {
            String inStr = input.substring(i, i+1);
            Instruction instruction = Instruction.valueOf(inStr);

            outputs[i] = instruction;
        }

        return outputs;
    }

}
