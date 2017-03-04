package localsearch;

/**
 * Created by Nogaz on 04.03.2017.
 */
public interface LocalSearch {
    public void doLocalSearch();
    public void generateNeighbour();
    public double calculatePointValue(double x1, double x2);
    public double[] getResultsList();

}
