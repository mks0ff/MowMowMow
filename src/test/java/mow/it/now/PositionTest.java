package mow.it.now;

import org.testng.annotations.Test;

import static mow.it.now.Compass.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sofiane
 * @version 1.0
 */
public class PositionTest {

    @Test
    public void hash_ok() {
        Position pos1 = new Position(2, 4, WEST);
        Position pos2 = new Position(2, 4, WEST);

        assertThat(pos1.equals(pos2) && pos2.equals(pos1)).isTrue();
        assertThat(pos1.hashCode() == pos2.hashCode()).isTrue();
    }
}
