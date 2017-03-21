package simulated.annealing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Nogaz on 19.03.2017.
 */
public class SimulatedAnnealingMain {
    public static void main(String[] args){
        Random random = new Random();
        int numberOfExperiments = 100;
        int iterationsInExperiment = 1000;
        double[][] results = new double[numberOfExperiments][iterationsInExperiment];
        double x1 = random.nextDouble()*10-5;
        double x2 = random.nextDouble()*10-5;
        for( int i = 0 ; i < numberOfExperiments ; ++i ){
            SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(iterationsInExperiment, x1, x2);
            simulatedAnnealing.simulateAnnealing();
            results[i] = simulatedAnnealing.getResults();
        }

        saveArray(getSumOfResults(results), "sumOfSimulatedAnnealing.txt");
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
}
