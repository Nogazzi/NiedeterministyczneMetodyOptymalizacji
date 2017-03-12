package generatory;

import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladNormalny implements  RandomGenerator {
    @Override
    public double getRandomDouble() {
        Random random = new Random();
        double result = random.nextGaussian();

        return result;
    }

    @Override
    public double getRandomDouble(double ceil) {
        Random random = new Random();
        double result = random.nextGaussian()*ceil;
        return result;
    }

    @Override
    public int getRandomInteger() {
        Random random = new Random();
        int result = (int)random.nextGaussian();
        return result;
    }

    @Override
    public int getRandomInteger(int ceil) {
        Random random = new Random();
        int result = (int)random.nextGaussian();
        return result;
    }
}
