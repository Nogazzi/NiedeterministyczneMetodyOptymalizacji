package localsearch;

import generatory.RandomGenerator;

/**
 * Created by Nogaz on 04.03.2017.
 */
public class LocalSearchImpl implements LocalSearch {

    private double x1;
    private double x2;
    private int critSTOP = 1000;
    private double x1Init = -10;
    private double x2Init = -10;
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
            x1 = x1 + generator.getRandomDouble();
            x2 = x2 + generator.getRandomDouble();
            newNeighbour = calculatePointValue(x1, x2);
            if( newNeighbour < tmpResult ){
                tmpResult = newNeighbour;
            }
            resultsList[i] = tmpResult;
            //System.out.println(tmpResult);
        }
        /*while(counter < critSTOP ){
            x1 = x1 + generator.getRandomDouble();
            x2 = x2 + generator.getRandomDouble();
            newNeighbour = calculatePointValue(x1, x2);
            if( newNeighbour < tmpResult ){
                tmpResult = newNeighbour;
            }
            //resultsList.add(tmpResult);
            resultsList[i] = tmpResult;
            System.out.println(tmpResult);
            counter++;
        }*/
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
