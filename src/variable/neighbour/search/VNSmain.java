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
        int deltasAmount = 5;
        VariableNeighbourSearch jednostajny = new VariableNeighbourSearchJednostajny(startX1, startX2, deltasAmount);
        System.out.println(jednostajny.doSearch());
    }
}
