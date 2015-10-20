package mow.it.now;


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
            return current.getDirection().go(current);
        }
    };

    public abstract Position make(Position current);
}
