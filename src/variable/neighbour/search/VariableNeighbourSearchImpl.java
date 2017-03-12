package variable.neighbour.search;

import generatory.RandomGenerator;

/**
 * Created by Nogaz on 12.03.2017.
 */
public abstract class VariableNeighbourSearchImpl implements VariableNeighbourSearch{

    RandomGenerator generator;
    int liczbaOdcinkow = 2;
    double[] deltaTab;

    public VariableNeighbourSearchImpl(){
        setDelta(this.liczbaOdcinkow);
    }
    public VariableNeighbourSearchImpl(int liczbaOdcinkow){
        this.liczbaOdcinkow = liczbaOdcinkow;
        setDelta(this.liczbaOdcinkow);
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
}
