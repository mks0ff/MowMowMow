package mow.it.now;

import com.google.common.collect.Lists;

import java.util.List;

import static mow.it.now.Compass.Direction.*;

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
    public enum Direction { NORTH, EAST, SOUTH, WEST }
    private static final List<Direction> directions = Lists.newArrayList(NORTH, EAST, SOUTH, WEST);

    public static Direction right(Direction direction) {
        int idx = directions.indexOf(direction);
        return (idx < 0 || idx+1 == directions.size()) ? directions.get(0) : directions.get(idx + 1);
    }

    public static Direction left(Direction direction) {
        int idx = directions.indexOf(direction);
        return (idx <= 0) ? directions.get(directions.size()-1) : directions.get(idx - 1);
    }
}
