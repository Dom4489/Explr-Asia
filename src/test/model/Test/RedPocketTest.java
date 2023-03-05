package model.Test;
import model.RedPocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class RedPocketTest {

    private RedPocket rp1;

    @BeforeEach
    public void setup() {
        rp1 = new RedPocket(0);
    }

    @Test
    public void testConstructor() {
        int test;
        for (int i = 0; i < 301; i++) {
            test = rp1.getAmount();
            if (test < 0 || test > 301) {
                fail("Red pocket produced a number outside of range");
            }
        }
    }

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
