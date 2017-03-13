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
        RandomGenerator generator = new RozkladJednostajny();
        double startX1 = generator.getRandomDouble()*5;
        double startX2 = generator.getRandomDouble()*5;
        int k_max = 5;
        VariableNeighbourSearch cauchy = new VariableNeighbourSearchCauchy(startX1, startX2, k_max);
        System.out.println(cauchy.doSearch());

        VariableNeighbourSearch normalny = new VariableNeighbourSearchNormalny(startX1, startX2, k_max);
        System.out.println(normalny.doSearch());

        VariableNeighbourSearch jednostajny = new VariableNeighbourSearchJednostajny(startX1, startX2, k_max);
        System.out.println(jednostajny.doSearch());

        long duration = System.currentTimeMillis() - time;
        System.out.println("Czas obliczeń: " + duration/1000);


        generateSimulationSumTxtFile(cauchy.getResultsTab(), "cauchy.txt");
        generateSimulationSumTxtFile(jednostajny.getResultsTab(), "jednostajny.txt");
        generateSimulationSumTxtFile(normalny.getResultsTab(), "normalny.txt");
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
}
