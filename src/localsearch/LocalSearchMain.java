package localsearch;

import gnuplot.GraphPloter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Nogaz on 04.03.2017.
 */
public class LocalSearchMain {

    private final static int iterationsNumber = 100;

    public static void main(String[] args){

        LocalSearch normalSearch = new LocalSearchNormal();
        double[][] normalDistributionSearchResults = new double[iterationsNumber][];

        LocalSearch uniformSearch = new LocalSearchUniform();
        double[][] uniformDistributionSearchResults = new double[iterationsNumber][];

        LocalSearch cauchySearch = new LocalSearchCauchy();
        double[][] cauchyDistributionSearchResults = new double[iterationsNumber][];

        for( int i = 0 ; i < iterationsNumber ; ++i ){
            normalSearch.doLocalSearch();
            normalDistributionSearchResults[i] = normalSearch.getResultsList();

            uniformSearch.doLocalSearch();
            uniformDistributionSearchResults[i] = uniformSearch.getResultsList();

            cauchySearch.doLocalSearch();
            cauchyDistributionSearchResults[i] = cauchySearch.getResultsList();
        }
        //rysuj wykresy dla sum losowan, wszystkich rozkladow
        GraphPloter.createGraph(getSumOfResults(normalDistributionSearchResults), "suma symulacji o rozkladzie normalnym");
        generateSimulationSumTxtFile(getSumOfResults(normalDistributionSearchResults), "sumaSymRozklNormalny.txt");
        GraphPloter.createGraph(getSumOfResults(uniformDistributionSearchResults), "suma symulacji o rozkladzie jednostajnym");
        generateSimulationSumTxtFile(getSumOfResults(uniformDistributionSearchResults), "sumaSymRozklJednostajny.txt");
        GraphPloter.createGraph(getSumOfResults(cauchyDistributionSearchResults), "suma symulacji o rozkladzie cauchyego");
        generateSimulationSumTxtFile(getSumOfResults(cauchyDistributionSearchResults), "sumaSymRozklCauchyego.txt");

        //rysuj wykresy dla poszczegolnych wszystkich losowan i rozkladow
        GraphPloter.createGraph(normalDistributionSearchResults, "symulacja o rozkladzie normalnym");
        generateTxtFile(normalDistributionSearchResults, "symRozklNormalny.txt");
        GraphPloter.createGraph(uniformDistributionSearchResults, "symulacja o rozkladzie jednostajnym");
        generateTxtFile(uniformDistributionSearchResults, "symRozklJednostajny.txt");
        GraphPloter.createGraph(cauchyDistributionSearchResults, "symulacja o rozkladzie cauchyego");
        generateTxtFile(cauchyDistributionSearchResults, "symRozklCauchyego.txt");
    }

    public static void saveArray(double[] array, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for (double line: array) {
                //System.out.println(line);
                bw.println(String.format("%.8f", line));
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double[] getSumOfResults(double[][] searchResults){
        double[] stepsSums = new double[searchResults[0].length];
        for(int i = 0 ; i < searchResults.length ; ++i ){
            //stepsSums[i] = 0;
            for( int j = 0 ; j < searchResults[0].length ; ++j ){
                stepsSums[j] += searchResults[i][j];
            }
        }
        return stepsSums;
    }

    public static void generateTxtFile(double[][] searchResults, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for( int step = 0 ; step < searchResults[0].length ; ++step ){
                for( int simulation = 0 ; simulation < searchResults.length ; ++simulation ){

                    bw.print(searchResults[simulation][step] + "\t");
                }
                bw.print("\n");
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generateSimulationSumTxtFile(double[] searchResults, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for( int simulation = 0 ; simulation < searchResults.length ; ++simulation ){

                bw.println(searchResults[simulation]);
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
