package tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Tag("simple")
@Tag("negative")
public class NegativeTests {
    @Test
    void test1() {
        assertTrue(false);
    }

    @Test
    @Tag("smoke")
    void test2() {
        assertTrue(false);
    }

    @Test
    void test3() {
        assertTrue(false);
    }

    @Test
    @Tag("smoke")
    void test4() {
        assertTrue(false);
    }

}