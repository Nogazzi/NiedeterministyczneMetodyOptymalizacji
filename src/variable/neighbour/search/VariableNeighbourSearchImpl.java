package variable.neighbour.search;

import generatory.RandomGenerator;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VariableNeighbourSearchImpl implements VariableNeighbourSearch{

    private double startX1;
    private double startX2;
    protected RandomGenerator generator;
    private int k_max = 2;
    private double[] deltaTab;
    private int actualDeltaIndex = 0;
    private final int iloscProb = 1000;
    private final Point initPoint;
/*
    public VariableNeighbourSearchImpl(){
        setDelta(this.k_max);
    }*/
    public VariableNeighbourSearchImpl(double x1, double x2, int k_max){
        this.k_max = k_max;
        setDelta(this.k_max);
        this.startX1 = x1;
        this.startX2 = x2;
        initPoint = new Point(x1, x2);
    }

    @Override
    public Point doSearch() {
        return GVNS(initPoint, k_max);
    }

    @Override
    public Point shake(Point point, int k) {
        double x1 = point.getX1() + generator.getRandomDouble(deltaTab[k]);
        double x2 = point.getX2() + generator.getRandomDouble(deltaTab[k]);
        return new Point(x1, x2);
    }

    @Override
    public PointAndIndexK neighbourChange(Point point1, Point point2, int k) {
        if( threeHumpCamel(point2) < threeHumpCamel(point1) ){
            point1 = point2;
            k = 0;
        }else{
            k += 1;
        }
        return new PointAndIndexK(point1, k);
    }

    @Override
    public Point VND(Point point, int k_max) {
        Point point2 = null;
        int k = 0;
        while( k < k_max ){
            point2 = bestNeighour(point);
            PointAndIndexK pointAndIndexK = neighbourChange(point, point2, k);
            point = pointAndIndexK.getPoint();
            k = pointAndIndexK.getIndexK();
        }
        return point;
    }

    @Override
    public void setDelta(int deltasAmount) {
        this.deltaTab = new double[deltasAmount];
        double deltaTmp = 1/(double)deltasAmount;
        System.out.println("Podzielono na " + deltasAmount + " odcinków");
        for(int i = deltasAmount-1 ; i >= 0 ; --i ){
            this.deltaTab[i] = (i+1)*deltaTmp;
            System.out.println(this.deltaTab[i]);
        }
    }

    @Override
    public double threeHumpCamel(Point point) {
        double x1 = point.getX1();
        double x2 = point.getX2();
        /*System.out.println("Three hump camel:");
        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);*/
        /*if( x1 < -5.0d || x1 > 5.0d || x2 < -5.0d || x2 > 5.0d ){
            throw new ThreeHumpCamelInputException();
        }*/
        double result = 2.0d*x1*x1 - 1.05d*x1*x1*x1*x1 + (x1*x1*x1*x1*x1*x1)/6.0d + x1*x2 + x2*x2;
        return result;
    }

    @Override
    public Point GVNS(Point point, int k_max) {
        point = RVNS(point, k_max);
        Point point1;
        Point point2;
        for( int i = 0 ; i < iloscProb ; ++i ){
            int k = 0;
            while( k < k_max ){
                point1 = shake(point, k);
                point2 = VND(point1, k_max);

                PointAndIndexK pointAndIndexK = neighbourChange(point, point2, k);

                point = pointAndIndexK.getPoint();
                k = pointAndIndexK.getIndexK();
            }
        }

        return point;
    }

    @Override
    public Point RVNS(Point point, int k_max) {
        Point point1;
        int k = 0;
        while( k < k_max ){
            point1 = shake(point, k);

            PointAndIndexK pointAndIndexK = neighbourChange(point, point1, k);
            point = pointAndIndexK.getPoint();
            k = pointAndIndexK.getIndexK();
        }
        return point;
    }

    @Override
    public Point bestNeighour(Point point) {
        Point point2;
        for( int i = 0 ; i < 1000 ; ++i ){
            double x1_2 = point.getX1() + generator.getRandomDouble();
            double x2_2 = point.getX1() + generator.getRandomDouble();
            point2 = new Point(x1_2, x2_2);
            if( threeHumpCamel(point2) < threeHumpCamel(point) ){
                point = point2;
            }
        }
        return point;
    }


    public class ThreeHumpCamelInputException extends RuntimeException{};

}
