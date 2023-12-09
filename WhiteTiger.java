import java.awt.Color;

public class WhiteTiger extends Tiger {
    private boolean hasInfected;

    public WhiteTiger() {
        super();  // Call the constructor of the Tiger class
        hasInfected = false;
    }

    @Override
    public Color getColor() {
        return Color.WHITE; // WhiteTigers are always white
    }

    @Override
    public String toString() {
        // Return "TGR" if it has infected another Critter, "tgr" otherwise
        return hasInfected ? "TGR" : "tgr";
    }

    @Override
    public Action getMove(CritterInfo info) {
        // Call the getMove method from the Tiger class
        Action action = super.getMove(info);

        // If the action is INFECT, it means the WhiteTiger has infected another Critter
        if (action == Action.INFECT) {
            hasInfected = true;
        }

        return action;
    }
}
