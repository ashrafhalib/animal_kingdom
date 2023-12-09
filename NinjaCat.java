import java.awt.Color;

public class NinjaCat extends Critter {
    private int moves;

    public NinjaCat() {
        // NinjaCat specific initialization can go here
        moves = 0;
    }

    @Override
    public Color getColor() {
        // Ninjas typically wear black for stealth
        return Color.BLACK;
    }

    @Override
    public String toString() {
        // Use a ninja star symbol to represent the NinjaCat
        return "★";
    }

    @Override
    public Action getMove(CritterInfo info) {
        moves++;

        // NinjaCat attacks strategically:
        // It waits for one move before attacking to catch the enemy by surprise.
        if (moves % 2 == 0 && info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // NinjaCat moves stealthily - it doesn't move if an enemy is behind, simulating stealth.
        else if (info.getBack() == Neighbor.OTHER) {
            return Action.LEFT;
        }
        // If there is a wall or a fellow NinjaCat nearby, the NinjaCat moves away to avoid collision and maintain stealth.
        else if (info.getRight() == Neighbor.WALL || info.getRight() == Neighbor.SAME) {
            return Action.LEFT;
        } 
        else if (info.getLeft() == Neighbor.WALL || info.getLeft() == Neighbor.SAME) {
            return Action.RIGHT;
        }
        // Otherwise, the NinjaCat hops forward to move around the simulation quietly and efficiently.
        else {
            return Action.HOP;
        }
    }
}
