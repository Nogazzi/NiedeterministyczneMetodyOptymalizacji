package variable.neighbour.search;

import generatory.RozkladCauchyego;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchCauchy extends VariableNeighbourSearchImpl {

    public VariableNeighbourSearchCauchy(){
        super();
        generator = new RozkladCauchyego();
    }
    public VariableNeighbourSearchCauchy(int liczbaOdcinkow){
        super(liczbaOdcinkow);
        generator = new RozkladCauchyego();
    }
}
