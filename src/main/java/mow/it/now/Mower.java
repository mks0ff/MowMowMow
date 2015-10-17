package mow.it.now;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author sofiane
 * @version 1.0
 */
public class Mower {

    private Position position; // has a
    private Lawn lawn; // belongs to

    public Mower(Position position, Lawn lawn) {
        this.position = checkNotNull(position);
        this.lawn = checkNotNull(lawn);
        validate(position, lawn);
    }

    private void validate(Position position, Lawn lawn) {
        checkArgument(lawn.contains(position), "The position of the mower should be in the lawn.");
    }

    public Position getPosition() {
        return position;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public Position execute(Move move) {
        Position next = move.make(position); // make a move to this position
        return lawn.contains(next) ? next : position;
    }

    public Position execute(List<Move> moves) {
        return moves.stream().reduce(position, (pos, m) -> pos = lawn.contains(m.make(pos)) ? m.make(pos) : pos, (pos1, pos2) -> pos2 = pos1); // foldl
    }
}
