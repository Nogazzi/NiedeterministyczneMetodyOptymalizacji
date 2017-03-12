package localsearch;

import generatory.RandomGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nogaz on 04.03.2017.
 */
public abstract class LocalSearchImpl implements LocalSearch {

    private double x1;
    private double x2;
    private int critSTOP = 1000;
    private double x1Init = -10;
    private double x2Init = -10;
    double x1tmp;
    double x2tmp;
    RandomGenerator generator;
    double[] resultsList;


    public LocalSearchImpl(){

    }

    @Override
    public void doLocalSearch() {
        int counter = 0;
        resultsList = new double[critSTOP];
        x1 = x1Init;
        x2 = x2Init;

        double tmpResult = calculatePointValue(x1,x2);
        //resultsList.add(tmpResult);
        resultsList[0] = tmpResult;
        double newNeighbour;
        for( int i = 1 ; i < critSTOP ; ++i ){
            x1tmp = x1 + generator.getRandomDouble();
            x2tmp = x2 + generator.getRandomDouble();
            newNeighbour = calculatePointValue(x1tmp, x2tmp);
            if( newNeighbour < tmpResult ){
                tmpResult = newNeighbour;
                x1 = x1tmp;
                x2 = x2tmp;
            }
            resultsList[i] = tmpResult;
            //System.out.println(tmpResult);
        }

    }

    @Override
    public void generateNeighbour() {

    }

    @Override
    public double calculatePointValue(double x1, double x2) {
        return x1*x1 + x2*x2;
    }

    public double[] getResultsList(){
        return this.resultsList;
    }



}
