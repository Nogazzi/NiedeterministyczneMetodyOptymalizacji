package variable.neighbour.search;

/**
 * Created by Nogaz on 12.03.2017.
 */
public interface VariableNeighbourSearch {
    public Point doSearch();
    public Point shake(Point point, int k);
    public PointAndIndexK neighbourChange(Point point1, Point point2, int k);
    public Point VND(Point point, int k_max);
    public void setDelta(int deltasAmount);
    public double threeHumpCamel(Point point);
    public Point GVNS(Point point, int k_max);
    public Point RVNS(Point point, int k_max);
    public Point bestNeighour(Point point, int k);
    public double[] getResultsTab();
}
