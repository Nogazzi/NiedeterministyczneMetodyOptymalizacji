package variable.neighbour.search;

import generatory.RandomGenerator;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchImpl implements VariableNeighbourSearch{

    double startX1;
    double startX2;
    RandomGenerator generator;
    int liczbaOdcinkow = 2;
    double[] deltaTab;

    public VariableNeighbourSearchImpl(){
        setDelta(this.liczbaOdcinkow);
    }
    public VariableNeighbourSearchImpl(double x1, double x2, int liczbaOdcinkow){
        this.liczbaOdcinkow = liczbaOdcinkow;
        setDelta(this.liczbaOdcinkow);
        this.startX1 = x1;
        this.startX2 = x2;
    }

    @Override
    public void doSearch() {

    }

    @Override
    public Point shake(Point point, double delta) {
        double x1 = point.getX1() + generator.getRandomDouble(delta);
        double x2 = point.getX2() + generator.getRandomDouble(delta);
        return new Point(x1, x2);
    }

    @Override
    public void neighbourChange() {

    }

    @Override
    public void variableNeighbourDescent() {

    }

    @Override
    public void setDelta(int deltasAmount) {
        this.deltaTab = new double[deltasAmount];
        double deltaTmp = 1/(double)deltasAmount;
        System.out.println("Podzielono na " + deltasAmount + " odcinków");
        for(int i = deltasAmount-1 ; i >= 0 ; --i ){
            this.deltaTab[i] = (i+1)*deltaTmp;
            System.out.println(this.deltaTab[i]);
        }
    }

    @Override
    public double threeHumpCamel(double x1, double x2) {
        if( x1 < -5.0d || x1 > 5.0d || x2 < -5.0d || x2 > 5.0d ){
            throw new ThreeHumpCamelInputException();
        }
        double result = 2.0d*x1*x1 - 1.05d*x1*x1*x1*x1 + (x1*x1*x1*x1*x1*x1)/6.0d + x1*x2 + x2*x2;
        return result;
    }

    public class ThreeHumpCamelInputException extends RuntimeException{};

}
