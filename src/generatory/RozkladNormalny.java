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
    public double getRandomDouble(double delta) {
        Random random = new Random();
        double result = random.nextGaussian()*delta;
        return result;
    }

}
