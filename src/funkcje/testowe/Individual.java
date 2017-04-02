package funkcje.testowe;

import generatory.MainManager;
import static java.lang.Math.*;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class Individual {

    int n;
    double[] xTab;
    public Individual(){

    }

    private double ackleyFunction(){
        double result;

        double sumaXi = 0;
        for( int i = 0 ; i < n ; ++i ){
            sumaXi += xTab[i]*xTab[i];
        }
        double sumaCos = 0;
        for( int i = 0 ; i < n ; ++i ){
            sumaCos += cos(2*Math.PI*xTab[i]);
        }

        result = -20.0d * exp(-0.2d * sqrt(sumaXi/(double)n) ) - (exp(sumaCos/(double)n)) + E;

        return result;
    }

    private double whitleyFunction(){
        double result = 0;

        for( int i = 0 ; i < n ; ++i ){
            for( int j = 0 ; j < n ; ++j ){

                result += (100*pow(pow(xTab[i], 2) - xTab[j], 2) + pow(pow(1-xTab[j],2),2) ) - cos(100*pow(pow(xTab[i],2)-xTab[j],2) + pow(1-xTab[j], 2)) + 1;
            }
        }

        return result;
    }
}
