package tags;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Tag("simple")
@Tag("needed")
public class SkippedTests {
    @Test
    @Disabled
    void test1() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    @Tag("prod")
    void test2() {
        assertTrue(false);
    }

}
