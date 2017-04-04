package funkcje.testowe;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class FunkcjeTestoweMain {
    public static void main(String[] args){
        int experimentsAmount = 100;
        int terminationCondition = 1000;
        final int maxTerminationCondition = 100000;
        FunkcjeTestowe funkcjeTestoweAckley = new FunkcjeAckley();
        double[] ackleyResults = new double[5];
        double ackleyResultQ = 0;

        System.out.println("########################");
        System.out.println("#########ACKLEY#########");
        System.out.println("########################");
        //petla dla n==2
        for( int exp = 0 ; exp < experimentsAmount ; ++exp ){
            funkcjeTestoweAckley.doSimulation(2, 1000);
            ackleyResultQ += funkcjeTestoweAckley.getBestResult();
        }
        ackleyResultQ = ackleyResultQ/experimentsAmount;


        //petle dla n==4,6,8,10
        double ackleyResult;
        int[] ackleyBudgets = new int[4];
        for( int n = 4 ; n <= 10 ; n+=2 ) {
            terminationCondition = 1000;
            while ( terminationCondition <= maxTerminationCondition ) {
                funkcjeTestoweAckley = new FunkcjeAckley();
                ackleyResult = 0;
                for( int j = 0 ; j < experimentsAmount ; ++j ) {
                    //100 eksperymentow dla kazdego n = 2, 4, 6, 8, 10
                    funkcjeTestoweAckley.doSimulation(n, terminationCondition);
                    ackleyResult += funkcjeTestoweAckley.getBestResult();
                    //System.out.println(String.format("%.18f", funkcjeTestoweAckley.getBestResult()));
                    //ackleyResults[n/2-1] += funkcjeTestoweAckley.getBestResult();
                }
                ackleyResult = ackleyResult/experimentsAmount;
                System.out.println(ackleyResult);

                if( resultNotEqualsEnough(ackleyResultQ, ackleyResult) ){
                    terminationCondition += 1000;
                }else{
                    //wyniki Q są podobne
                    ackleyBudgets[n/2-2] = terminationCondition;
                    break;
                }
            }
        }
        for(int i = 0 ; i < ackleyBudgets.length ; ++i ){
            System.out.println(ackleyBudgets[i]);
        }


        System.out.println("########################");
        System.out.println("########WHITLEY#########");
        System.out.println("########################");
        //whitley

        FunkcjeTestowe funkcjeWhitley = new FunkcjeWhitley();
        double[] whitleyResults = new double[5];
        double whitleyResultQ = 0;

        //petla dla n==2
        for( int exp = 0 ; exp < experimentsAmount ; ++exp ){
            funkcjeWhitley.doSimulation(2, 1000);
            whitleyResultQ += funkcjeWhitley.getBestResult();
        }
        whitleyResultQ = whitleyResultQ/experimentsAmount;


        //petle dla n==4,6,8,10
        double whitleyResult;
        int[] whitleyBudgets = new int[4];
        for( int n = 4 ; n <= 10 ; n+=2 ) {
            terminationCondition = 1000;
            while ( terminationCondition <= maxTerminationCondition ) {
                funkcjeWhitley = new FunkcjeWhitley();
                whitleyResult = 0;
                for( int j = 0 ; j < experimentsAmount ; ++j ) {
                    //100 eksperymentow dla kazdego n = 2, 4, 6, 8, 10
                    funkcjeWhitley.doSimulation(n, terminationCondition);
                    whitleyResult += funkcjeWhitley.getBestResult();
                    //System.out.println(String.format("%.18f", funkcjeWhitley.getBestResult()));
                    //ackleyResults[n/2-1] += funkcjeTestoweAckley.getBestResult();
                }
                whitleyResult = whitleyResult/experimentsAmount;
                System.out.println(whitleyResult);
                if( resultNotEqualsEnough(whitleyResultQ, whitleyResultQ) ){
                    terminationCondition += 1000;
                }else{
                    //wyniki Q są podobne
                    whitleyBudgets[n/2-2] = terminationCondition;
                    break;
                }
            }
        }
        for(int i = 0 ; i < whitleyBudgets.length ; ++i ){
            System.out.println(whitleyBudgets[i]);
        }


        //levy
        System.out.println("########################");
        System.out.println("######### LEVY #########");
        System.out.println("########################");
        FunkcjeTestowe funkcjeLevy = new FunkcjeLevy();
        double[] levyResults = new double[5];
        double levyResultQ = 0;

        //petla dla n==2
        for( int exp = 0 ; exp < experimentsAmount ; ++exp ){
            funkcjeLevy.doSimulation(2, 1000);
            levyResultQ += funkcjeLevy.getBestResult();
        }
        levyResultQ = levyResultQ/experimentsAmount;


        //petle dla n==4,6,8,10
        double levyResult;
        int[] levyyBudgets = new int[4];
        for( int n = 4 ; n <= 10 ; n+=2 ) {
            terminationCondition = 1000;
            while ( terminationCondition <= maxTerminationCondition ) {
                funkcjeLevy = new FunkcjeLevy();
                levyResult = 0;
                for( int j = 0 ; j < experimentsAmount ; ++j ) {
                    //100 eksperymentow dla kazdego n = 2, 4, 6, 8, 10
                    funkcjeLevy.doSimulation(n, terminationCondition);
                    levyResult += funkcjeLevy.getBestResult();
                    //System.out.println(String.format("%.18f", funkcjeLevy.getBestResult()));
                    //ackleyResults[n/2-1] += funkcjeTestoweAckley.getBestResult();
                }
                levyResult = levyResult/experimentsAmount;
                System.out.println(levyResult);
                if( resultNotEqualsEnough(levyResultQ, levyResult) ){
                    terminationCondition += 1000;
                }else{
                    //wyniki Q są podobne
                    levyyBudgets[n/2-2] = terminationCondition;
                    break;
                }
            }
        }
        for(int i = 0 ; i < levyyBudgets.length ; ++i ){
            System.out.println(levyyBudgets[i]);
        }
    }

    private static boolean resultNotEqualsEnough(double resultN2, double resultNx){
        double difference = Math.log10(resultN2/resultNx);
        if(Math.abs(difference) < 2){
            return false;
        }
        return true;
    }

    private void increaseTerminationCondition(int x){
        x += 1000;

    }
}
