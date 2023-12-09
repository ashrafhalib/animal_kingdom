import java.awt.Color;

public class Giant extends Critter {
    private int moves;
    private String[] words = {"fee", "fie", "foe", "fum"};
    private int wordIndex;

    public Giant() {
        // Initialize move counter and word index
        moves = 0;
        wordIndex = 0;
    }

    @Override
    public Color getColor() {
        return Color.GRAY; // Giants are always gray
    }

    @Override
    public String toString() {
        // Update the word index every 6 moves
        if (moves % 6 == 0 && moves != 0) {
            wordIndex = (wordIndex + 1) % words.length;
        }
        return words[wordIndex];
    }

    @Override
    public Action getMove(CritterInfo info) {
        // Increment the move counter
        moves++;

        // Always infect if an enemy is in front
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // If the front is empty, hop
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        // Otherwise, turn right
        else {
            return Action.RIGHT;
        }
    }
}
