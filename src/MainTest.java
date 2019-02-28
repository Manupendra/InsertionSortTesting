import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MainTest {
    Solver solver;

    @Before
    public void setUp() {
        solver = new Solver();
    }


    @Test
    public void test() {
        assertArrayEquals(new int[]{22,44,55,97},solver.solve(new int[]{97,55,22,44}));
    }
}
