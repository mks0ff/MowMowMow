package mow.it.now;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author sofiane
 * @version 1.0
 * simulate a compass with all directions
 */
public class Compass {

    /**
     *     N
     * W - |- E
     *     S
     */
    private static final List<Direction> directions = Lists.newArrayList(Direction.values());

    public static Direction right(Direction direction) {
        int idx = directions.indexOf(direction);
        return (idx < 0 || idx+1 == directions.size()) ? directions.get(0) : directions.get(idx + 1);
    }

    public static Direction left(Direction direction) {
        int idx = directions.indexOf(direction);
        return (idx <= 0) ? directions.get(directions.size()-1) : directions.get(idx - 1);
    }

    public enum Direction {
        NORTH {
            @Override
            public Position go(Position current) {
                return new Position(current.getX(), current.getY() + 1, current.getDirection());
            }
        }, EAST {
            @Override
            public Position go(Position current) {
                return new Position(current.getX() + 1, current.getY(), current.getDirection());
            }
        }, SOUTH {
            @Override
            public Position go(Position current) {
                return new Position(current.getX(), current.getY() - 1, current.getDirection());
            }
        }, WEST {
            @Override
            public Position go(Position current) {
                return new Position(current.getX() - 1, current.getY(), current.getDirection());
            }
        };

        public abstract Position go(Position current);
    }
}
