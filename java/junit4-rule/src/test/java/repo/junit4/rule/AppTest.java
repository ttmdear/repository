package repo.junit4.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Rule
    public ExceptionRule exceptionRule = new ExceptionRule();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        exceptionRule.setExpected(RuntimeException.class);

        // ...
        if (true) {
            throw new IllegalArgumentException("Error");
        }

        assertTrue(true);
    }
}
