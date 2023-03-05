package model.Test;
import model.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {

    private Wallet w1;

    @BeforeEach
    public void setup() {
        w1 = new Wallet(150);
    }

    @Test
    public void testConstructor() {
        assertEquals(150, w1.getAmount());
        w1.subAmount(50);
        assertEquals(100, w1.getAmount());
        w1.subAmount(50);
        assertEquals(50, w1.getAmount());
        w1.subAmount(50);
        assertEquals(0, w1.getAmount());
        w1.addAmount(4);
        assertEquals(4, w1.getAmount());
        w1.subAmount(5);
        assertEquals(0, w1.getAmount());
    }
}
