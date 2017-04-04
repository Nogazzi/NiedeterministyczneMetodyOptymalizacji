package funkcje.testowe;

import static java.lang.Math.*;

/**
 * Created by Nogaz on 04.04.2017.
 */
public class Ackeleca {
    public static void main(String[] args){
        evaluateByAckley();
        evaluateByLevy();
        evaluateByWhitley();
    }

    public static void evaluateByAckley(){
        double result;
        int n = 2;
        double[] xTab = {-3, 1};
        /*for(int i = 0 ; i < n ; i++){
            if( xTab[i] < minX){
                xTab[i] = minX;
            }
            if( xTab[i] > maxX){
                xTab[i] = maxX;
            }
        }*/
        double sumaXi = 0;
        for( int i = 0 ; i < n ; ++i ){
            sumaXi += xTab[i]*xTab[i];
        }
        double sumaCos = 0;
        for( int i = 0 ; i < n ; ++i ){
            sumaCos += cos(2*Math.PI*xTab[i]);
        }

        result = -20.0d * exp(-0.2d * sqrt(sumaXi/(double)n) ) - (exp(sumaCos/(double)n)) + 20 + E;
        System.out.println(result);
    }

    public static void evaluateByLevy(){
        int n = 2;
        double result;
        double[] xTab = {-3, 1};
        double a = 1.0d;
        double k = 10.d;
        /*for(int i = 0 ; i < n ; i++){
            if( xTab[i] < minX){
                xTab[i] = minX;
            }
            if( xTab[i] > maxX){
                xTab[i] = maxX;
            }
        }*/
        double sumaYi = 0;
        for( int i = 0 ; i < n-1 ; ++i ){
            sumaYi += pow((1 + (xTab[i]-1)/4) - a,2) * (1+k*pow(sin(PI*(1 + (xTab[i+1]-1)/4)),2));
        }

        result = PI/n * (k * pow(sin(PI*(1 + (xTab[0]-1)/4)), 2)) + sumaYi + pow((1 + (xTab[n-1]-1)/4) - a, 2);
        System.out.println(result);
    }

    public static double getXi(double[] tab, int i){

        return 1 + (tab[i]-1)/4;
    }

    public static void evaluateByWhitley(){
        int n = 2;
        double result = 0;
        double[] xTab = {-3, 1};

        for( int i = 0 ; i < n ; ++i ){
            for( int j = 0 ; j < n ; ++j ){

                result += pow(100*pow(pow(xTab[i], 2) - xTab[j], 2) + pow(1-xTab[j],2),2 )/4000.0d - cos(100*pow(pow(xTab[i],2)-xTab[j],2) + pow(1-xTab[j], 2)) + 1;
            }
        }
        System.out.println(result);
    }
}
