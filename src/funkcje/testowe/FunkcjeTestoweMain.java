package funkcje.testowe;

/**
 * Created by Nogaz on 02.04.2017.
 */
public class FunkcjeTestoweMain {
    public static void main(String[] args){
        int experimentsAmount = 100;
        FunkcjeTestowe funkcjeTestowe = new FunkcjeTestowe(experimentsAmount);
        funkcjeTestowe.doSimulation();
    }
}
