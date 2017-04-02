package funkcje.testowe;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class IndividualLevy07 extends Individual {
    public IndividualLevy07(int n) {
        super(n);
        minX = -10.0d;
        maxX = 10.0d;
    }

    @Override
    public double testFunction() {
        double a = 1.0d;
        double k = 10.d;
        double result = 0;
        for(int i = 0 ; i < n ; i++){
            if( xTab[i] < minX){
                xTab[i] = minX;
            }
            if( xTab[i] > maxX){
                xTab[i] = maxX;
            }
        }
        double sumaYi = 0;
        for( int i = 0 ; i < n-1 ; ++i ){
            sumaYi += pow(getXi(i) - a,2) * (1+k*pow(sin(PI*getXi(i+1)),2));
        }

        result = PI/n * (k * pow(sin(PI*getXi(0)), 2) + sumaYi + pow(getXi(n-1) - a, 2));

        return result;
    }
}
