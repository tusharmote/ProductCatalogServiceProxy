import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomNumberTest {
    @Test
    public void testRandomNumber() {
        Random random = new Random();
        int n = random.nextInt(10);
        assert (n < 5);
    }
}
