package variable.neighbour.search;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VNSmain {
    public static void main(String[] args){
        RandomGenerator generator = new RozkladJednostajny();
        double startX1 = generator.getRandomDouble()*5;
        double startX2 = generator.getRandomDouble()*5;
        int deltasAmount;
        System.out.println("x1: " + startX1);
        System.out.println("x2: " + startX2);
    }
}
