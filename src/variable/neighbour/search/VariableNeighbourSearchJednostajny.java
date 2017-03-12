package variable.neighbour.search;

import generatory.RozkladJednostajny;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchJednostajny extends VariableNeighbourSearchImpl {
    public VariableNeighbourSearchJednostajny(){
        super();
        generator = new RozkladJednostajny();
    }
    public VariableNeighbourSearchJednostajny(double x1, double x2, int liczbaOdcinkow){
        super(x1, x2, liczbaOdcinkow);
        generator = new RozkladJednostajny();
    }
}
