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
        evaluate();
    }

    private void evaluate(){
        result = 2.0d*x1*x1 - 1.05d*x1*x1*x1*x1 + (x1*x1*x1*x1*x1*x1)/6.0d + x1*x2 + x2*x2;
    }

    public double getX1(){ return x1; }
    public double getX2(){ return x2; }
    public double getResult(){ return result; }
    public void mutate(){

    }
    @Override
    public String toString() {
        return "X1: " + x1 + ", X2: " + x2 + ", result: " + result;
    }
}
