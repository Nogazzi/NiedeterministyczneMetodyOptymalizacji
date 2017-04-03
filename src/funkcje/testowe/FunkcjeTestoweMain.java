package funkcje.testowe;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class FunkcjeTestoweMain {
    public static void main(String[] args){
        int experimentsAmount = 100;
        FunkcjeTestowe funkcjeTestoweAckley = new FunkcjeAckley(experimentsAmount);
        double[] ackleyResults = new double[5];
        for( int i = 2 ; i <= 10 ; i+=2 ) {
            for( int j = 0 ; j < experimentsAmount ; ++j ) {
                //100 eksperymentow dla kazdego n = 2, 4, 6, 8, 10
                funkcjeTestoweAckley.doSimulation(i);
                ackleyResults[i/2] += funkcjeTestoweAckley.getBestResult();
            }
            ackleyResults[i/2] = ackleyResults[i/2]/5;
        }

        FunkcjeTestowe funkcjeTestoweWhitley = new FunkcjeWhitley(experimentsAmount);
        double[] whitleyResults = new double[5];
        for( int i = 2 ; i <= 10 ; i+=2 ) {
            for( int j = 0 ; j < experimentsAmount ; ++j ) {
                //100 eksperymentow dla kazdego n = 2, 4, 6, 8, 10
                funkcjeTestoweWhitley.doSimulation(i);
                whitleyResults[i/2] += funkcjeTestoweWhitley.getBestResult();
            }
            whitleyResults[i/2] = whitleyResults[i/2]/5;
        }

        FunkcjeTestowe funkcjeTestoweLevy = new FunkcjeLevy(experimentsAmount);
        double[] levyResults = new double[5];
        for( int i = 2 ; i <= 10 ; i+=2 ) {
            for( int j = 0 ; j < experimentsAmount ; ++j ) {
                //100 eksperymentow dla kazdego n = 2, 4, 6, 8, 10
                funkcjeTestoweLevy.doSimulation(i);
                levyResults[i/2] += funkcjeTestoweLevy.getBestResult();
            }
            levyResults[i/2] = levyResults[i/2]/5;
        }
    }
}
