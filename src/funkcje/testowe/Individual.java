package funkcje.testowe;

import generatory.MainManager;
import static java.lang.Math.*;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class Individual {

    private final int n;
    private double[] xTab;
    private double[] yTab;
    public Individual(int xAmount){
        n = xAmount;
        xTab = new double[xAmount];
        yTab = new double[xAmount];
    }

    private double ackleyFunction(){
        double result;
        for(int i = 0 ; i < n ; i++){
            if( xTab[i] < -32.768d){
                xTab[i] = -32.768d;
            }
            if( xTab[i] > 32.768d){
                xTab[i] = 32.768d;
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

    private double whitleyFunction(){
        double result = 0;
        for(int i = 0 ; i < n ; i++){
            if( xTab[i] < -10.24d){
                xTab[i] = -10.24d;
            }
            if( xTab[i] > 10.24d){
                xTab[i] = 10.24d;
            }
        }

        for( int i = 0 ; i < n ; ++i ){
            for( int j = 0 ; j < n ; ++j ){

                result += pow(100*pow(pow(xTab[i], 2) - xTab[j], 2) + pow(1-xTab[j],2),2 )/4000.0d - cos(100*pow(pow(xTab[i],2)-xTab[j],2) + pow(1-xTab[j], 2)) + 1;
            }
        }

        return result;
    }

    private double levy07Function(){
        double a = 1.0d;
        double k = 10.d;
        double result = 0;
        for(int i = 0 ; i < n ; i++){
            if( xTab[i] < -10.0d){
                xTab[i] = -10.0d;
            }
            if( xTab[i] > 10.0d){
                xTab[i] = 10.0d;
            }
        }
        double sumaYi = 0;
        for( int i = 0 ; i < n-1 ; ++i ){
            sumaYi += pow(getXi(i) - a,2) * (1+k*pow(sin(PI*getXi(i+1)),2));
        }

        result = PI/n * (k * pow(sin(PI*getXi(0)), 2) + sumaYi + pow(getXi(n-1) - a, 2));

        return result;
    }

    private double getXi(int i){
        return 1 + (xTab[i]-1)/4;
    }
}
