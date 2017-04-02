package funkcje.testowe;

import static java.lang.Math.*;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class IndividualAckley extends Individual {
    public IndividualAckley(int n) {
        super(n);
        minX = -32.768d;
        maxX = 32.768d;
    }

    @Override
    public double testFunction() {
        double result;
        for(int i = 0 ; i < n ; i++){
            if( xTab[i] < minX){
                xTab[i] = minX;
            }
            if( xTab[i] > maxX){
                xTab[i] = maxX;
            }
        }

        double sumaXi = 0;
        for( int i = 0 ; i < n ; ++i ){
            sumaXi += xTab[i]*xTab[i];
        }
        double sumaCos = 0;
        for( int i = 0 ; i < n ; ++i ){
            sumaCos += cos(2*Math.PI*xTab[i]);
        }

        result = -20.0d * exp(-0.2d * sqrt(sumaXi/(double)n) ) - (exp(sumaCos/(double)n)) + 20 + E;

        return result;
    }
}
