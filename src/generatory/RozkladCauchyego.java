package generatory;

/**
 * Created by Nogaz on 27.02.2017.
 */
public class RozkladCauchyego implements RandomGenerator {
    double sigma = 2.0;
    @Override
    public double getRandomDouble() {
        RandomGenerator jednostajny = new RozkladJednostajny();
        double d = jednostajny.getRandomDouble();
        double result = sigma*Math.tan(Math.PI * (d-0.5));

        return result;
    }

    @Override
    public int getRandomInteger() {
        return 0;
    }

    @Override
    public int getRandomInteger(int ceil) {
        return 0;
    }
}
