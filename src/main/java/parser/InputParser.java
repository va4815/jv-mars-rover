package parser;

import exception.InvalidInputException;
import model.Plateau;
import model.PlateauSize;
import model.Position;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static PlateauSize parsePlateauSize(String input) {
        PlateauSize output = null;

        if (input == null) {
            return output;
        }

        String regex = "^[0-9] [0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            return output;
        }

        String[] split = input.split(" ");
        int width = Integer.parseInt(split[0]);
        int height = Integer.parseInt(split[1]);

        output = new PlateauSize(width, height);

        return output;
    }

    public static Position parseRoverLandingPosition(String input) {
        // TODO: convert input to a Position class
        //  example: "1 2 N"
        //  x position: 1, y position: 2, direction: N

        return null;
    }

}
