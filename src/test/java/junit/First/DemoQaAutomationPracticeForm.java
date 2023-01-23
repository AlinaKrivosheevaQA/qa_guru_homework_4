package junit.First;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
    }
}
