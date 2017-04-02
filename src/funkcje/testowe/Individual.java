package funkcje.testowe;

import generatory.MainManager;

import java.util.Random;

import static java.lang.Math.*;

/**
 * Created by Nogaz on 02.04.2017.
 */
public abstract class Individual implements TestFunctionInterface {

    protected final int n;
    protected double[] xTab;
    protected double minX;
    protected double maxX;
    private final double result;

    public Individual(int n){
        this.n = n;
        xTab = new double[n];
        Random random = new Random();
        for( int i = 0 ; i < n ; ++i ){
            xTab[i] = random.nextDouble()*2*maxX-maxX;
        }
        this.result = testFunction();
    }

    protected double getXi(int i){
        return 1 + (xTab[i]-1)/4;
    }

}
