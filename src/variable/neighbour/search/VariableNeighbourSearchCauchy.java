package variable.neighbour.search;

import generatory.RozkladCauchyego;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchCauchy extends VariableNeighbourSearchImpl {

    /*public VariableNeighbourSearchCauchy(){
        super();
        generator = new RozkladCauchyego();
    }*/
    public VariableNeighbourSearchCauchy(double x1, double x2, int liczbaOdcinkow){
        super(x1, x2, liczbaOdcinkow);
        generator = new RozkladCauchyego();
    }
}
