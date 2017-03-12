package variable.neighbour.search;

/**
 * Created by Nogaz on 12.03.2017.
 */
public interface VariableNeighbourSearch {
    public void doSearch();
    public Point shake(Point point, double delta);
    public void neighbourChange();
    public void variableNeighbourDescent();
    public void setDelta(int deltasAmount);
    public double threeHumpCamel(double x1, double x2) throws VariableNeighbourSearchImpl.ThreeHumpCamelInputException;
}
