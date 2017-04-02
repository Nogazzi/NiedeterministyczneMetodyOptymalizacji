package funkcje.testowe;

import static java.lang.Math.cos;
import static java.lang.Math.pow;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class IndividualWhitley extends Individual {
    public IndividualWhitley(int n) {
        super(n);
        minX = -10.24d;
        maxX = 10.24d;
    }

    @Override
    public double testFunction() {
        double result = 0;
        for(int i = 0 ; i < n ; i++){
            if( xTab[i] < minX){
                xTab[i] = minX;
            }
            if( xTab[i] > maxX){
                xTab[i] = maxX;
            }
        }

        for( int i = 0 ; i < n ; ++i ){
            for( int j = 0 ; j < n ; ++j ){

                result += pow(100*pow(pow(xTab[i], 2) - xTab[j], 2) + pow(1-xTab[j],2),2 )/4000.0d - cos(100*pow(pow(xTab[i],2)-xTab[j],2) + pow(1-xTab[j], 2)) + 1;
            }
        }

        return result;
    }
}
