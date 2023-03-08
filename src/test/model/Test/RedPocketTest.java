package model.Test;
import model.RedPocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedPocketTest {

    private RedPocket rp1;

    @BeforeEach
    public void setup() {
        rp1 = new RedPocket(0);
    }

    @Test
    public void testConstructor() {
        int timesChanged = 0;
        int lastStatus = rp1.getAmount();
        for (int i = 0; i < 100; i++) {
            RedPocket rp1 = new RedPocket(20);
            assertTrue(0 <= rp1.getAmount() || rp1.getAmount() <= 301);

            if (lastStatus != rp1.getAmount()) {
                timesChanged ++;
                lastStatus = rp1.getAmount();
            }
        }

        assertFalse(timesChanged == 0);
    }

    // Test by making sure that the random will return two different numbers
    @Test
    public void testGetAmount() {
        int test;
        for (int i = 0; i < 301; i++) {
            test = rp1.getAmount();
            if (test < 0 || test > 301) {
                fail("Red pocket produced a number outside of range");
            }
        }
    }
}
