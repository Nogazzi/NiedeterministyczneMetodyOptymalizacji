package evolutionary.computation;

import generatory.RandomGenerator;
import generatory.RozkladJednostajny;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Nogaz on 25.03.2017.
 */
public class EvolutionaryComputationMain {


    public static void main(String[] args){

        final int experimentsAmount = 100;
        final int populationSize = 20;
        int longestResultTabSize = 0;
        int shortestResultTabSize = Integer.MAX_VALUE;
        ArrayList<Double>[] resultsTab = new ArrayList[experimentsAmount];
        for( int i = 0 ; i < experimentsAmount ; ++i ){
            EvolutionComputingSimulator experiment = new EvolutionComputingSimulator(populationSize);
            experiment.doSimulation();
            resultsTab[i] = experiment.getExperimentResult();
            if( resultsTab[i].size() > longestResultTabSize ){
                longestResultTabSize = resultsTab[i].size();
            }
            System.out.println("size: " + resultsTab[i].size());
            if( resultsTab[i].size() < shortestResultTabSize ){
                shortestResultTabSize = resultsTab[i].size();
            }
        }
        System.out.println("Longest result tab:" + longestResultTabSize);
        System.out.println("Shortest result tab: " + shortestResultTabSize);
        try {
            saveArray(getSumofResultsLists(resultsTab), "evolutionaryComputing.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void saveArray(ArrayList<Double> arrayList, String filename){
        PrintWriter bw;
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            bw = new PrintWriter(fw);
            for (double line: arrayList) {
                //System.out.println(line);
                bw.println(String.format("%.8f", line));
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] getSumofResultsLists(ArrayList<Double>[] listsArray) throws Exception {
        int shortestList = listsArray[0].size();
        int longestList = listsArray[0].size();
        for( int i = 0 ; i < listsArray.length ; ++i ){
            if( listsArray[i].size() < shortestList){
                shortestList = listsArray[i].size();
            }
            if( listsArray[i].size() > longestList ){
                longestList = listsArray[i].size();
            }
        }
        if( shortestList != longestList ){
            throw new Exception("lists sizes are not equal!");
        }
        double[] resultsSums = new double[listsArray.length];
        for( int i = 0 ; i < resultsSums.length ; ++i ){
            for( int j = 0 ; j < shortestList ; ++j ){
                resultsSums[j] += listsArray[i].get(j);
            }
        }
        return resultsSums;
    }

}
