package generatory;

import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladJednostajny implements RandomGenerator {
    @Override
    public double getRandomDouble() {
        Random random = new Random();
        double result = (random.nextDouble()*2)-1;
        return result;
    }

    @Override
    public int getRandomInteger() {
        Random random = new Random();
        int result = random.nextInt();
        return result;
    }

    @Override
    public int getRandomInteger(int ceil) {
        Random random = new Random();
        int result = random.nextInt(ceil);
        return result;
    }
}
