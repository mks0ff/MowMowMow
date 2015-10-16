package mow.it.now;

import static mow.it.now.Compass.Direction.*;

/**
 * @author sofiane
 * @version 1.0
 */
public enum Move {
    LEFT {
        @Override
        public Position make(Position current) {
            return new Position(current.getX(), current.getY(), Compass.left(current.getDirection()));
        }
    },
    RIGHT {
        @Override
        public Position make(Position current) {
            return new Position(current.getX(), current.getY(), Compass.right(current.getDirection()));
        }
    },
    FORWARD {
        @Override
        public Position make(Position current) {
            return moveForward(current);
        }
    };

    private static Position moveForward(Position current) {
        if (NORTH == current.getDirection()) {
            return new Position(current.getX(), current.getY() + 1, current.getDirection());
        }
        if (EAST == current.getDirection()) {
            return new Position(current.getX() + 1, current.getY(), current.getDirection());
        }
        if (SOUTH == current.getDirection()) {
            return new Position(current.getX(), current.getY() - 1, current.getDirection());
        }
        // WEST
        return new Position(current.getX() - 1, current.getY(), current.getDirection());
    }

    public abstract Position make(Position current);

}
