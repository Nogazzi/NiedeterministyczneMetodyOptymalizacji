package variable.neighbour.search;

import generatory.RozkladNormalny;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchNormalny extends VariableNeighbourSearchImpl{
    public VariableNeighbourSearchNormalny(){
        super();
        generator = new RozkladNormalny();
    }
    public VariableNeighbourSearchNormalny(int liczbaOdcinkow){
        super(liczbaOdcinkow);
        generator = new RozkladNormalny();
    }
}
