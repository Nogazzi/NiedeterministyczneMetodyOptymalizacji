package variable.neighbour.search;

import generatory.RozkladNormalny;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchNormalny extends VariableNeighbourSearchImpl{
    /*public VariableNeighbourSearchNormalny(){
        super();
        generator = new RozkladNormalny();
    }*/
    public VariableNeighbourSearchNormalny(double x1, double x2, int liczbaOdcinkow){
        super(x1, x2, liczbaOdcinkow);
        generator = new RozkladNormalny();
    }
}
