import java.awt.Color;
import java.util.Random;

public class Tiger extends Critter {
    private int moves;
    private Color currentColor;

    public Tiger() {
        // Initially pick a random color
        pickNewColor();
        moves = 0;
    }

    // This helper method picks a random color out of RED, GREEN, or BLUE
    private void pickNewColor() {
        Random rand = new Random();
        int colorChoice = rand.nextInt(3);
        if (colorChoice == 0) {
            currentColor = Color.RED;
        } else if (colorChoice == 1) {
            currentColor = Color.GREEN;
        } else {
            currentColor = Color.BLUE;
        }
    }

    @Override
    public Color getColor() {
        // Change color every 3 moves
        if (moves % 3 == 0) {
            pickNewColor();
        }
        return currentColor;
    }

    @Override
    public String toString() {
        return "TGR";
    }

    @Override
    public Action getMove(CritterInfo info) {
        moves++;  // Increment move counter

        // Always infect if an enemy is in front
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // If a wall is in front or to the right, turn left
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }
        // If a fellow Tiger is in front, turn right
        else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }
        // Otherwise, hop
        else {
            return Action.HOP;
        }
    }
}
