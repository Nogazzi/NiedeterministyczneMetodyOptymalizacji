package simulated.annealing;

import generatory.RandomGenerator;
import variable.neighbour.search.Point;

import java.util.Random;

/**
 * Created by Nogaz on 18.03.2017.
 */
public class SimulatedAnnealing {

    private int k;
    private int N = 50;
    private double T1 = 100.0d;
    private double Tn = 1.0d;

    private int Lk;
    private int Tk;

    Point pointX;
    Point pointY;

    private int iterationsNumber;

    Random random = new Random();



    public SimulatedAnnealing(int iterationsNumber){
        k = 1;
        this.iterationsNumber = iterationsNumber;
    }

    public void simulateAnnealing(){
        while( k <= iterationsNumber ){ //repeat until termination condition met

            for( int l = 0 ; l < Lk ; ++l ){
                //select  y among N(x)

                //if f(y) <= f(x): x=y
                if( threeHumpCamel(pointY) < threeHumpCamel(pointX) ){
                    pointX = pointY;
                }else{
                    //if exp(...)>U(0,1): x=y
                    if( Math.exp( threeHumpCamel(pointX)-threeHumpCamel(pointY) / Tk) > random.nextDouble() ){
                        pointX = pointY;
                    }
                }
            }
            Lk = calculateLength(Lk);
            Tk = calculateControl(Tk);

            k++;
        }
    }


    public double threeHumpCamel(Point point) {
        double x1 = point.getX1();
        double x2 = point.getX2();
        if( x1 < -5 ){
            x1 = -5;
        }
        if( x1 > 5 ){
            x1 = 5;
        }
        if( x2 < -5 ){
            x2 = -5;
        }
        if( x2 > 5 ){
            x2 = 5;
        }
        double result = 2.0d*x1*x1 - 1.05d*x1*x1*x1*x1 + (x1*x1*x1*x1*x1*x1)/6.0d + x1*x2 + x2*x2;
        return result;
    }

    public double calculateLength(double Lk){
        double result = 0;

        return result;
    }

    public double calculateControl(double Tk){

        double a = (T1 - Tn)(N + 1)/N;
        double Tk = T1 - Math.pow(k, a);



        return Tk;
    }
}
