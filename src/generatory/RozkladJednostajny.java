package generatory;

import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladJednostajny implements RandomGenerator {
    @Override
    public double getRandomDouble() {
        Random random = new Random();
        double result = (random.nextDouble()*2.0d) - 1.0d;
        return result;
    }

    @Override
    public double getRandomDouble(double delta) {
        Random random = new Random();
        double result = ((random.nextDouble()*2.0d) - 1.0d )*delta;
        return result;
    }

}
