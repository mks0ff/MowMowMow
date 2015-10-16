package mow.it.now;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static mow.it.now.Compass.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sofiane
 * @version 1.0
 */
public class MoveTest {

    @DataProvider(name = "go_forward_data")
    public Object[][] go_forward_data_provider() {
        return new Object[][] {
                { new Position(1, 1, NORTH), new Position(1, 2, NORTH) },
                { new Position(1, 1, EAST), new Position(2, 1, EAST) },
                { new Position(1, 1, SOUTH), new Position(1, 0, SOUTH) },
                { new Position(1, 1, WEST), new Position(0, 1, WEST) },
        };
    }

    @Test(dataProvider = "go_forward_data")
    public void go_forward_ok(Position current, Position expected) {
        assertThat(Move.FORWARD.make(current)).isEqualTo(expected);
    }

    @DataProvider(name = "turn_left_data")
    public Object[][] turn_left_data_provider() {
        return new Object[][] {
                { new Position(1, 1, NORTH), new Position(1, 1, WEST) },
                { new Position(1, 1, EAST), new Position(1, 1, NORTH) },
                { new Position(1, 1, SOUTH), new Position(1, 1, EAST) },
                { new Position(1, 1, WEST), new Position(1, 1, SOUTH) },
        };
    }

    @Test(dataProvider = "turn_left_data")
    public void turn_left_ok(Position current, Position expected) {
        assertThat(Move.LEFT.make(current)).isEqualTo(expected);
    }

    @DataProvider(name = "turn_right_data")
    public Object[][] turn_right_data_provider() {
        return new Object[][] {
                { new Position(1, 1, NORTH), new Position(1, 1, EAST) },
                { new Position(1, 1, EAST), new Position(1, 1, SOUTH) },
                { new Position(1, 1, SOUTH), new Position(1, 1, WEST) },
                { new Position(1, 1, WEST), new Position(1, 1, NORTH) },
        };
    }

    @Test(dataProvider = "turn_right_data")
    public void turn_right_ok(Position current, Position expected) {
        assertThat(Move.RIGHT.make(current)).isEqualTo(expected);
    }
}
