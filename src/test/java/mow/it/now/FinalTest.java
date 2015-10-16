package mow.it.now;

import com.google.common.collect.Lists;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static mow.it.now.Compass.Direction.*;
import static mow.it.now.Move.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sofiane
 * @version 1.0
 */
public class FinalTest {

    @DataProvider(name = "mower_one_moves_data")
    public Object[][] mower_one_moves_data_provider() {
        return new Object[][] {
           { Lists.newArrayList(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD),
                   new Position(1, 3, NORTH) },
        };
    }

    @Test(dataProvider = "mower_one_moves_data")
    public void mower_one_ok(List<Move> moves, Position expected) {
        final Lawn lawn = new Lawn(5, 5);
        final Position position = new Position(1, 2, NORTH);
        final Mower mower = new Mower(position, lawn);

        assertThat(mower.getLawn()).isEqualTo(lawn);
        assertThat(mower.getPosition()).isEqualTo(position);
        assertThat(mower.execute(moves)).isEqualTo(expected);
    }

    @DataProvider(name = "mower_two_moves_data")
    public Object[][] mower_two_moves_data_provider() {
        return new Object[][] {
                { Lists.newArrayList(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD),
                        new Position(5, 1, EAST) },
        };
    }

    @Test(dataProvider = "mower_two_moves_data")
    public void mower_two_ok(List<Move> moves, Position expected) {
        final Lawn lawn = new Lawn(5, 5);
        final Position position = new Position(3, 3, EAST);
        final Mower mower = new Mower(position, lawn);

        assertThat(mower.getLawn()).isEqualTo(lawn);
        assertThat(mower.getPosition()).isEqualTo(position);
        assertThat(mower.execute(moves)).isEqualTo(expected);
    }
}
