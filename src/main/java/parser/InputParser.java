package parser;

import enumeration.Direction;
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
        int width = Integer.parseInt(split[0]) + 1;
        int height = Integer.parseInt(split[1]) + 1;

        output = new PlateauSize(width, height);

        return output;
    }

    public static Position parseRoverLandingPosition(String input) {
        Position output = null;

        if (input == null) {
            return output;
        }

        String regex = "^[0-9] [0-9] [NESW]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            return output;
        }

        String[] split = input.split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        Direction facing = Direction.valueOf(split[2]);

        output = new Position(x, y, facing);

        return output;
    }

}
