import model.Plateau;
import model.Rover;

import java.util.LinkedList;
import java.util.List;

public class MarsRoverProgram {
    private Plateau plateau;
    private List<Rover> roverList = new LinkedList<>();

    public void init(int plateauPositionX, int plateauPositionY, int numOfRover) {

        plateau = new Plateau(plateauPositionX, plateauPositionY);

        for (int i = 0; i < numOfRover; i++) {
            String roverName = "Rover " + (i+1);
            Rover rover = new Rover(roverName);

            roverList.add(rover);
        }

    }

}
