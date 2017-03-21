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
    double a = (T1 - Tn)*(N + 1)/N;
    private double Lk = 5;
    private double Tk;
    private double alfa = 0.97;

    Point pointX;
    Point pointY;

    private int iterationsNumber;

    Random random = new Random();
    double results[];


    public SimulatedAnnealing(int iterationsNumber, double x1, double x2){
        k = 1;
        this.iterationsNumber = iterationsNumber;
        results = new double[iterationsNumber];
        pointX = new Point(x1, x2);
    }

    public void simulateAnnealing(){
        int i = 0;
        k = 1;
        while( i < iterationsNumber ){ //repeat until termination condition met
            for( int k = 0 ; k < N ; ++k) {
                for (int l = 0; l < Lk; ++l) {
                    //select  y among N(x)
                    pointY = generateNeighour(pointX);
                    //if f(y) <= f(x): x=y
                    if (threeHumpCamel(pointY) <= threeHumpCamel(pointX)) {
                        pointX = pointY;
                    } else {
                        //if exp(...)>U(0,1): x=y
                        if (Math.exp(threeHumpCamel(pointX) - threeHumpCamel(pointY) / Tk) > random.nextDouble()) {
                            pointX = pointY;
                        }
                    }
                }
                //Lk = calculateLength(Lk);
                Tk = computeTk(k);

            }
            results[i] = threeHumpCamel(pointX);
            ++i;
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
        return Tk*alfa;
    }

    public double computeTk(int k){
        double Tk = a / (k+1) + T1 - a;
        return Tk;
    }

    public Point generateNeighour(Point point) {
        int pointsAmout = 10;
        Point[] points = new Point[pointsAmout];
        for( int i = 0 ; i < points.length ; ++i ){
            points[i] = new Point(point.getX1() + random.nextDouble()*2-1, point.getX2() + random.nextDouble()*2-1);
        }


        return points[(int)random.nextDouble()*pointsAmout];
    }

    public double[] getResults(){
        return this.results;
    }
}
