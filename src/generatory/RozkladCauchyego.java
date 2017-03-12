package generatory;

import java.util.Random;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladCauchyego implements RandomGenerator {

    @Override
    public double getRandomDouble() {
        Random random = new Random();
        double d = random.nextDouble();
        double result = Math.tan(Math.PI * (d-0.5));
        return result;
    }
    public double getRandomDouble(double delta) {
        Random random = new Random();
        double d = random.nextDouble();
        double result = delta*Math.tan(Math.PI * (d-0.5));
        return result;
    }


}
