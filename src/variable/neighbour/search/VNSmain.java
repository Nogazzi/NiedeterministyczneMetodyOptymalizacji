package variable.neighbour.search;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nogaz on 12.03.2017.
 */
public class VNSmain {
    public static void main(String[] args){
        long time = System.currentTimeMillis();
        int iloscEksperymentow = 100;
        double[][] sumaCauchy = new double[iloscEksperymentow][];
        double[][] sumaNormalny = new double[iloscEksperymentow][];
        double[][] sumaJednostajny = new double[iloscEksperymentow][];

        RandomGenerator generator = new RozkladJednostajny();
        double startX1 = generator.getRandomDouble()*5;
        double startX2 = generator.getRandomDouble()*5;
        int k_max = 5;
        VariableNeighbourSearch cauchy;

        VariableNeighbourSearch normalny;

        VariableNeighbourSearch jednostajny;



        for( int i = 0 ; i < iloscEksperymentow ; ++i ){
            cauchy = new VariableNeighbourSearchCauchy(startX1, startX2, k_max);
            cauchy.doSearch();
            sumaCauchy[i] = cauchy.getResultsTab();

            normalny = new VariableNeighbourSearchNormalny(startX1, startX2, k_max);
            normalny.doSearch();
            sumaNormalny[i] = normalny.getResultsTab();

            jednostajny = new VariableNeighbourSearchJednostajny(startX1, startX2, k_max);
            jednostajny.doSearch();
            sumaJednostajny[i] = jednostajny.getResultsTab();
        }

        generateTxtFile(sumaCauchy, "VNS_cauchy.txt");
        generateTxtFile(sumaJednostajny, "VNS_jednostajny.txt");
        generateTxtFile(sumaNormalny, "VNS_normalny.txt");

        generateSimulationSumTxtFile(getSumOfResults(sumaCauchy), "VNS_Suma_Cauchy.txt");
        generateSimulationSumTxtFile(getSumOfResults(sumaJednostajny), "VNS_Suma_Jednostajny.txt");
        generateSimulationSumTxtFile(getSumOfResults(sumaNormalny), "VNS_Suma_Normalny.txt");

        long duration = System.currentTimeMillis() - time;
        System.out.println("Czas obliczeń: " + duration/1000);
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

    public static void generateSimulationSumTxtFile(double[] searchResults, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for( int simulation = 0 ; simulation < searchResults.length ; ++simulation ){
                bw.println(String.format("%.8f", searchResults[simulation]));
                //bw.println(searchResults[simulation]);
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generateTxtFile(double[][] searchResults, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for( int step = 0 ; step < searchResults[0].length ; ++step ){
                for( int simulation = 0 ; simulation < searchResults.length ; ++simulation ){
                    bw.print(String.format("%.8f", searchResults[simulation][step]));
                    bw.print("\t");
                    //bw.print(searchResults[simulation][step] + "\t");
                }
                bw.print("\n");
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
