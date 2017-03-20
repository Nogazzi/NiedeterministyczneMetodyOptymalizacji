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
        double x1 = random.nextDouble()*10-5;
        double x2 = random.nextDouble()*10-5;
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(1000, x1, x2);
        simulatedAnnealing.simulateAnnealing();
        saveArray(simulatedAnnealing.getResults(), "simulatedAnnealing.txt");
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
}
