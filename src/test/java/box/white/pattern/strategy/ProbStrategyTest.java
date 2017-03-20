package box.white.pattern.strategy;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class ProbStrategyTest {

    @Test
    public void getSumCuntTest() throws Exception {

        ProbStrategy testSuite = new ProbStrategy();
        Method method = testSuite.getClass().getDeclaredMethod("getSum", int.class);
        method.setAccessible(true);
        int actual = (int) method.invoke(testSuite, 2);
        int expected = 3;

        assertEquals(expected, actual);
    }

}
