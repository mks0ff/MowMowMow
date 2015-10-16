package mow.it.now;

import com.google.common.collect.Lists;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static mow.it.now.Compass.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sofiane
 * @version 1.0
 */
public class MowerTest {

    @DataProvider(name = "mower_data")
    public Object[][] mower_data_provider() {
        return new Object[][] {
                { Move.LEFT, new Position(1, 1, WEST) },
                { Move.RIGHT, new Position(1, 1, EAST) },
                { Move.FORWARD, new Position(1, 2, NORTH) },
        };
    }

    @Test(dataProvider = "mower_data")
    public void mower_move_ok(Move move, Position expected) {
        final Mower mower = new Mower(new Position(1, 1, NORTH), new Lawn(4, 4));
        assertThat(mower.execute(move)).isEqualTo(expected);
    }

    @DataProvider(name = "mower_moves_data")
    public Object[][] mower_moves_data_provider() {
        return new Object[][] {
                { Lists.newArrayList(Move.LEFT, Move.FORWARD, Move.RIGHT, Move.FORWARD), new Position(0, 2, NORTH) },
        };
    }

    @Test(dataProvider = "mower_moves_data")
    public void mower_moves_ok(List<Move> moves, Position expected) {
        final Lawn lawn = new Lawn(4, 4);
        final Position position = new Position(1, 1, NORTH);
        final Mower mower = new Mower(position, lawn);

        assertThat(mower.getLawn()).isEqualTo(lawn);
        assertThat(mower.getPosition()).isEqualTo(position);
        assertThat(mower.execute(moves)).isEqualTo(expected);
    }

}
