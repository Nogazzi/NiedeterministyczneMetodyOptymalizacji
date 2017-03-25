package evolutionary.computation;

/**
 * Created by Nogaz on 25.03.2017.
 */
public class Individual {
    private double x1;
    private double x2;
    private double result;

    public Individual(double x1, double x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    private void computeResult(){

    }

    public double getX1(){ return x1; }
    public double getX2(){ return x2; }
    public double getResult(){ return result; }
}
