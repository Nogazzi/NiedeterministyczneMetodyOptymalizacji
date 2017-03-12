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
    public VariableNeighbourSearchJednostajny(int liczbaOdcinkow){
        super(liczbaOdcinkow);
        generator = new RozkladJednostajny();
    }
}
