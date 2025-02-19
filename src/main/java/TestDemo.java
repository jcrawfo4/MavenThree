import java.util.Random;

public class TestDemo {
    public int addPositive(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
        return a + b;
    }

    public Integer randomNumberSquared(int a) {
        Integer result = getRandomInt();
        if (a < 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        return result * result;
    }

    public Integer getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) +1;
    }
}
