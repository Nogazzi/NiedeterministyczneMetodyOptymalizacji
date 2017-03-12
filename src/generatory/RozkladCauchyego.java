package generatory;

import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladCauchyego implements RandomGenerator {
    double sigma = 2.0;
    @Override
    public double getRandomDouble() {
        Random random = new Random();
        double d = random.nextDouble();
        double result = this.sigma*Math.tan(Math.PI * (d-0.5));
        return result;
    }
    public double getRandomDouble(double sigma) {
        Random random = new Random();
        double d = random.nextDouble();
        double result = this.sigma*Math.tan(Math.PI * (d-0.5));
        return result;
    }


}
