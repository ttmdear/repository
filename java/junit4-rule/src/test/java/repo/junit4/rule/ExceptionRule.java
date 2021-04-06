package repo.junit4.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ExceptionRule implements TestRule {
    private Class expected;

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            Throwable error = null;

            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } catch (Throwable throwable) {
                    error = throwable;
                }

                if (expected != null && (error == null || !error.getClass().equals(expected))) {
                    throw new Exception("No exception assertion");
                } else if (expected == null && error != null) {
                    throw new Exception("No exception assertion");
                }
            }
        };
    }

    public void setExpected(Class expected) {
        this.expected = expected;
    }
}
