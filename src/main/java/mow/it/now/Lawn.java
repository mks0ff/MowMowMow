package mow.it.now;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author sofiane
 * @version 1.0
 * this is where the mowers will move
 */
public class Lawn {

    private final int row;
    private final int column;

    public Lawn(int row, int column) {
        checkArgument(0 <= row && 0 <= column);
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean contains(Position position) { // validate a position in the lawn
        return 0 <= position.getX() && position.getX() <= getRow() && 0 <= position.getY() && position.getY() <= getColumn();
    }
}
