package funkcje.testowe;

import generatory.MainManager;

import java.util.Random;

import static java.lang.Math.*;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class Individual {

    protected final int n;
    protected double[] xTab;
    protected double minX;
    protected double maxX;
    protected double result;

    public Individual(int n, double bound){
        this.n = n;
        xTab = new double[n];
        this.minX = (-1)*abs(bound);
        this.maxX = abs(bound);
        Random random = new Random();
        for( int i = 0 ; i < n ; ++i ){
            xTab[i] = random.nextDouble()*2.0d*maxX-maxX;
        }
    }

    public Individual(Individual individual, double bound, double sigma){
        double[] tab = individual.getxTab();
        n = tab.length;
        xTab = new double[n];
        this.minX = (-1)*abs(bound);
        this.maxX = abs(bound);
        Random generator = new Random();
        for(int i = 0 ; i < n ; ++i ){
            xTab[i] =  tab[i] + generator.nextGaussian()*sigma;
        }
    }

    public void setResult(double result){
        this.result = result;
    }
    public void evaluateByAckley(){
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
    }

    public void evaluateByWhitley(){
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
    }

    public void evaluateByLevy(){
        double a = 1.0d;
        double k = 10.d;
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
    }

    public double getResult(){
        return this.result;
    }

    public void setBounds(double bound){
        this.minX = (-1)*abs(bound);
        this.maxX = abs(bound);
    }

    protected double getXi(int i){
        return 1 + (xTab[i]-1)/4;
    }

    public  double[] getxTab(){
        return xTab;
    }

}
