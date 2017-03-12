package generatory;

import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladCauchyego implements RandomGenerator {
    double sigma = 1.0;
    @Override
    public double getRandomDouble() {
        Random random = new Random();
        double d = random.nextDouble();
        double result = Math.tan(Math.PI * (d-0.5));
        return result;
    }
    public double getRandomDouble(double ceil) {
        Random random = new Random();
        double d = random.nextDouble();
        double result = ceil*Math.tan(Math.PI * (d-0.5));
        return result;
    }


}
